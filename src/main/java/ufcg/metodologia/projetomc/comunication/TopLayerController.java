package ufcg.metodologia.projetomc.comunication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ufcg.metodologia.projetomc.dataset.Dataset;
import ufcg.metodologia.projetomc.io.InputLoader;
import ufcg.metodologia.projetomc.io.OutputSaver;
import ufcg.metodologia.projetomc.sort.Sort;
import ufcg.metodologia.projetomc.sort.SortFactory;
import ufcg.metodologia.projetomc.util.OutputEntry;
import ufcg.metodologia.projetomc.util.SortAlgorithm;
import ufcg.metodologia.projetomc.util.SortOrder;
import ufcg.metodologia.projetomc.util.SortedElements;

public class TopLayerController implements TopLayerFacade {
	public static final int WARM_UP_VALUE = 10;
	
	@Override
	public void sortMilestone1(String algorithmStr, String inputStr, String outputStr, String orderStr, String replicationsStr) {
		SortOrder orderEnum = SortOrder.valueOf(orderStr.toUpperCase());
		SortAlgorithm algorithmEnum = SortAlgorithm.valueOf(algorithmStr.toUpperCase());
		int replications = Integer.parseInt(replicationsStr.trim());
	
		InputLoader inputLoader = new InputLoader();
		OutputSaver outputSaver = new OutputSaver();
	        
		List<Double[]> input = inputLoader.load(inputStr);
	    //List<OutputEntry> outputEntries = applySort(algorithmEnum, input, orderEnum, replications);
	    
	    //outputSaver.save(outputStr, outputEntries);
	}
	
	@Override
	public void generateDataset(String nameStr, String orderStr, String sortedElementsStr, String arraySizeStr, String datasetSizeStr) {
		try {
	    	SortOrder orderEnum = SortOrder.valueOf(orderStr.toUpperCase());
	    	SortedElements sortedElementsEnum = SortedElements.valueOf(sortedElementsStr.toUpperCase());
	    	int arraySize = Integer.parseInt(arraySizeStr);
	    	int datasetSize = Integer.parseInt(datasetSizeStr);
	    	
	    	Dataset dataset = new Dataset(nameStr, orderEnum, sortedElementsEnum, arraySize, datasetSize);
	    	dataset.save();
    	} catch (IOException e) {
    		e.printStackTrace();
    		throw new RuntimeException("Error while trying to generate dataset. " + e.getMessage());
    	}
	}
	
	private List<OutputEntry> applySort(SortAlgorithm algorithmType, List<Double[]> input, SortedElements sortedElements, int replication) {
		List<OutputEntry> outputEntries = new ArrayList<OutputEntry>();
		Sort sort = SortFactory.createSort(algorithmType);
		
		for (int i = 0; i < input.size(); i++) {
			Double[] array = input.get(i);
			String arrayStr = Arrays.toString(array);
			
			long executionTime = sort.sort(array, true);
			//OutputEntry entry = new OutputEntry(algorithmType.toString(), sortedElements.toString(), executionTime, replication);
			//outputEntries.add(entry);
		}

		return outputEntries;
	}
	
	public void sortExperiment() {
		List<OutputEntry> outputEntries = new ArrayList<OutputEntry>();
		InputLoader inputLoader = new InputLoader();
		
		//List<Double[]> wurmup = inputLoader.load("datasets/dataset1.csv");
		
		List<Double[]> dataset1 = inputLoader.load("datasets/novoset/dataset1_ordered_100000.csv");
		List<Double[]> dataset2 = inputLoader.load("datasets/novoset/dataset2_notordered_100000.csv");
		List<Double[]> dataset3 = inputLoader.load("datasets/novoset/dataset3_random_100000.csv");
		List<Double[]> dataset4 = inputLoader.load("datasets/novoset/dataset4_ordered_100.csv");
		List<Double[]> dataset5 = inputLoader.load("datasets/novoset/dataset5_notordered_100.csv");
		List<Double[]> dataset6 = inputLoader.load("datasets/novoset/dataset6_random_100.csv");
		
		SortAlgorithm[] algorithms = {SortAlgorithm.QUICK, SortAlgorithm.INSERTION, SortAlgorithm.MERGE};
		//outputForDataset(new ArrayList<>(), SortedElements.RANDOM, algorithms, wurmup);
		outputForDataset(outputEntries, SortedElements.ORDERED, algorithms, dataset1);
		outputForDataset(outputEntries, SortedElements.UNORDERED, algorithms, dataset2);
		outputForDataset(outputEntries, SortedElements.RANDOM, algorithms, dataset3);
		outputForDataset(outputEntries, SortedElements.ORDERED, algorithms, dataset4);
		outputForDataset(outputEntries, SortedElements.UNORDERED, algorithms, dataset5);
		outputForDataset(outputEntries, SortedElements.RANDOM, algorithms, dataset6);
		
		OutputSaver outputSaver = new OutputSaver();
		outputSaver.save("output/output.csv", outputEntries);
	}
	
	private void outputForDataset(List<OutputEntry> outputEntries, SortedElements se, SortAlgorithm[] algorithms, List<Double[]> dataset) {
		for (Double[] array : dataset) {
			for (SortAlgorithm sa : algorithms) {
				for (int i = 1; i <= 5; i++) {
					Double[] cpyArray = Arrays.copyOf(array, array.length);
					Sort sort = SortFactory.createSort(sa);
					long executionTime = sort.sort(cpyArray, true);
					OutputEntry entry = new OutputEntry(sa.toString().toLowerCase(), cpyArray.length, se.toString().toLowerCase(), executionTime, i);
					outputEntries.add(entry);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		TopLayerController c = new TopLayerController();
		c.sortExperiment();
	}
}