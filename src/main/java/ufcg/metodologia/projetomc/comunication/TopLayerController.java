package ufcg.metodologia.projetomc.comunication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ufcg.metodologia.projetomc.io.InputLoader;
import ufcg.metodologia.projetomc.io.OutputSaver;
import ufcg.metodologia.projetomc.sort.Sort;
import ufcg.metodologia.projetomc.sort.SortFactory;
import ufcg.metodologia.projetomc.util.OutputEntry;
import ufcg.metodologia.projetomc.util.SortAlgorithm;
import ufcg.metodologia.projetomc.util.SortOrder;

public class TopLayerController implements TopLayerFacade {
	public static final int WARM_UP_VALUE = 10;
	
	@Override
	public void sortMilestone1(String algorithmStr, String inputStr, String outputStr, String orderStr, String replicationsStr) {
		SortOrder orderEnum = SortOrder.valueOf(orderStr.toUpperCase());
		SortAlgorithm algorithmEnum = SortAlgorithm.valueOf(algorithmStr.toUpperCase());
		int replications = Integer.parseInt(replicationsStr);
	
		InputLoader inputLoader = new InputLoader();
		OutputSaver outputSaver = new OutputSaver();
	        
		List<Double[]> input = inputLoader.load(inputStr);
	    List<OutputEntry> outputEntries = applySort(algorithmEnum, input, orderEnum, replications);
	    
	    outputSaver.save(outputStr, outputEntries);
	}

	@Override
	public void generateDataset(String name, String order, String sortType, String arraySize, String datasetSize) {
		
	}
	
	private List<OutputEntry> applySort(SortAlgorithm algorithmType, List<Double[]> input, SortOrder sortOrder, int replications) {
		List<OutputEntry> outputEntries = new ArrayList<OutputEntry>();
		Sort sort = SortFactory.createSort(algorithmType);
		
		List<Double[]> preparedInput = prepareInput(input, replications);
		
		for (int i = 0; i < preparedInput.size(); i++) {
			Double[] array = preparedInput.get(i);
			String arrayStr = Arrays.toString(array);
			
			long executionTime = sort.sort(array, sortOrder.getValue());
			
			if (i >= WARM_UP_VALUE) {
				
				int showReplication = 0;
				
				if (replications != 0) {
					showReplication = (i - WARM_UP_VALUE) % (replications + 1);
				}
				
				OutputEntry entry = new OutputEntry(arrayStr, algorithmType.toString(), sortOrder.toString(), executionTime, showReplication);
				outputEntries.add(entry);
			}
		}

		return outputEntries;
	}
	
	private List<Double[]> prepareInput(List<Double[]> input, int replications) {
		List<Double[]> newInput = new ArrayList<>();
		
		// Generate warm up entries.
		for (int i = 0; i < WARM_UP_VALUE; i++) {
			newInput.add(Arrays.copyOf(input.get(0), input.get(0).length));
		}
		
		// Generate arrays.
		for (Double[] array : input) {
			for (int i = 0; i <= replications; i++) {
				newInput.add(Arrays.copyOf(array, array.length));
			}
		}
		
		return newInput;
	}
}
