package ufcg.metodologia.projetomc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ufcg.metodologia.projetomc.sort.Sort;
import ufcg.metodologia.projetomc.sort.SortFactory;
import ufcg.metodologia.projetomc.util.CSVUtils;
import ufcg.metodologia.projetomc.util.OutputEntry;
import ufcg.metodologia.projetomc.util.SortAlgorithm;
import ufcg.metodologia.projetomc.util.SortOrder;

/**
 * Created by Wesley Silva on 06/08/2017.
 */

public class Main {
    public static void main(String[] args) {
        String argAlgorithm = args[0];
        String argInput = args[1];
        String argOutput = args[2];
        String argOrder = args[3];
        String argReplications = args[4];

        SortOrder orderType = SortOrder.valueOf(argOrder.toUpperCase());
        SortAlgorithm algorithmType = SortAlgorithm.valueOf(argAlgorithm.toUpperCase());
        int replications = Integer.parseInt(argReplications);

        List<Double[]> input = convertInput(argInput);
        List<OutputEntry> outputEntries = applySort(algorithmType, input, orderType, replications);
        generateOutput(argOutput, outputEntries);
    }

    public static void generateOutput(String path, List<OutputEntry> outputEntries) {
        try {
            File output = new File(path);
            FileWriter writer = new FileWriter(output);

            for (OutputEntry entry : outputEntries) {
                CSVUtils.writeLine(writer, entry);
            }

            writer.flush();
            writer.close();
        } catch(IOException e) {
            throw new RuntimeException("Path: " + path + " not found.");
        }

    }

    public static List<OutputEntry> applySort(SortAlgorithm algorithmType, List<Double[]> input, SortOrder sortOrder, int replications) {
        List<OutputEntry> outputEntries = new ArrayList<OutputEntry>();
        Sort sort = SortFactory.createSort(algorithmType);
        for (Double[] array : input) {
            for (int i = 0 ; i <= replications; i++) {
                long executionTime = sort.sort(array, sortOrder.getValue());
                OutputEntry entry = new OutputEntry(Arrays.toString(array), algorithmType.toString(), sortOrder.toString(), executionTime, i);
                outputEntries.add(entry);
            }
        }

        return outputEntries;
    }

    public static List<Double[]> convertInput(String argInput) {
        List<Double[]> content = new ArrayList<Double[]>();

        try {
            File inputFile = new File(argInput);
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNext()) {
                List<String> line = CSVUtils.parseLine(scanner.nextLine());

                Double[] array = new Double[line.size()];

                for (int i = 0; i < line.size(); i += 1) {
                    array[i] = Double.parseDouble(line.get(i));
                }

                content.add(array);
            }

            scanner.close();
            return content;
        } catch(FileNotFoundException e1) {
            throw new RuntimeException("The file: " + argInput + " was not found in the system.");
        }
    }
}
