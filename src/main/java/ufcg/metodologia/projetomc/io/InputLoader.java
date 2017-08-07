package ufcg.metodologia.projetomc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ufcg.metodologia.projetomc.util.CSVUtils;

public class InputLoader {
	public InputLoader() {
		
	}
	
	public List<Double[]> load(String inputPath) {
        List<Double[]> content = new ArrayList<Double[]>();

        try {
            File inputFile = new File(inputPath);
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
        } catch(FileNotFoundException e) {
        	e.printStackTrace();
            throw new RuntimeException("Error while trying to convert input for path: " + inputPath + ". " + e.getMessage());
        }
    }
}
