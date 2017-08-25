package ufcg.metodologia.projetomc.dataset;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ufcg.metodologia.projetomc.sort.QuickSort;
import ufcg.metodologia.projetomc.util.CSVUtils;
import ufcg.metodologia.projetomc.util.SortOrder;
import ufcg.metodologia.projetomc.util.SortedElements;

public class Dataset {
    public final static long MAX_RANDOM_NUM = 1000000;
    public final static long MIN_RANDOM_NUM = -1000000;

    private String name;
    private int arraySize;
    private SortedElements sortedElements;
    private int datasetSize;
    private SortOrder sortOrder;

    private List<Double[]> content;

    public static void main(String[] args) throws IOException {
        Dataset dataset = new Dataset("dataset_1.csv", SortOrder.DESCENDING, SortedElements.ALL, 10, 100);
        dataset.save();
    }

    public Dataset(String name, SortOrder sortOrder, SortedElements sortedElements, int arraySize, int datasetSize) {
        this.name = name;
        this.sortOrder = sortOrder;
        this.sortedElements = sortedElements;
        this.arraySize = arraySize;
        this.datasetSize = datasetSize;

        this.content = createContent();
    }

    private List<Double[]> createContent() {
        List<Double[]> content = new ArrayList<Double[]>();
        
        if ((sortOrder == SortOrder.ASCENDING && sortedElements == SortedElements.ALL) || (sortOrder == SortOrder.DESCENDING && sortedElements == SortedElements.NONE)) {
        	for (int i = 0; i < this.datasetSize; i++) {
                Double[] array = new Double[arraySize];
                generateAscendingOrderedArray(array);
                System.out.println("Array " + i + " generated!");
                content.add(array);
            }
        } else if ((sortOrder == SortOrder.DESCENDING && sortedElements == SortedElements.ALL) || (sortOrder == SortOrder.ASCENDING && sortedElements == SortedElements.NONE)) {
        	for (int i = 0; i < this.datasetSize; i++) {
                Double[] array = new Double[arraySize];
                generateDescendingOrderedArray(array);
                System.out.println("Array " + i + " generated!");
                content.add(array);
            }
        } else if (sortedElements == SortedElements.RANDOM) {
        	for (int i = 0; i < this.datasetSize; i++) {
                Double[] array = new Double[arraySize];
                generateDescendingOrderedArray(array);
                generateRandomArray(array);
                content.add(array);
            }
        } else {
            throw new RuntimeException("Error, for input: sortOrder=" + sortOrder + " and sortType=" + sortedElements + ".");
        }

        return content;
    }

    private void generateAscendingOrderedArray(Double[] array) {
        QuickSort sort = new QuickSort();
        generateRandomArray(array);
        sort.sort(array, SortOrder.ASCENDING.getValue());
    }

    private void generateDescendingOrderedArray(Double[] array) {
        QuickSort sort = new QuickSort();
        generateRandomArray(array);
        sort.sort(array, SortOrder.DESCENDING.getValue());
    }

    private void generateRandomArray(Double[] array) {
        for (int j = 0; j < array.length; j++) {
            array[j] = generateRandomDouble();
        }
    }

    private Double generateRandomDouble() {
        return (MIN_RANDOM_NUM + (MAX_RANDOM_NUM - MIN_RANDOM_NUM) * new Random().nextDouble());
    }

    public void save() throws IOException {
        File file = new File("datasets/" + name);
        FileWriter writer = new FileWriter(file);

        for (Double[] c : content) {
            CSVUtils.writeLine(writer, Arrays.asList((c)));
        }


        writer.flush();
        writer.close();
    }

    public List<Double[]> getContent() {
        return content;
    }
}
