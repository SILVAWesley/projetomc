package ufcg.metodologia.projetomc;

import ufcg.metodologia.projetomc.comunication.TopLayerController;
import ufcg.metodologia.projetomc.comunication.TopLayerFacade;

public class ExperimentMilestone3 {
	public static void main(String[] args) {
		TopLayerFacade facade = new TopLayerController();
		
		facade.generateDataset("novoset/dataset1_ordered_100000.csv", "ASCENDING", "ORDERED", "5000", "5");
		facade.generateDataset("novoset/dataset2_notordered_100000.csv", "ASCENDING", "UNORDERED", "5000", "5");
		facade.generateDataset("novoset/dataset3_random_100000.csv", "ASCENDING", "RANDOM", "5000", "5");
		
		facade.generateDataset("novoset/dataset4_ordered_100.csv", "ASCENDING", "ORDERED", "100", "5");
		facade.generateDataset("novoset/dataset5_notordered_100.csv", "ASCENDING", "UNORDERED", "100", "5");
		facade.generateDataset("novoset/dataset6_random_100.csv", "ASCENDING", "RANDOM", "100", "5");
		
		/*facade.sortMilestone1("quick", "datasets/milestone3/dataset1_ordered_10000.csv", "output/quick/dataset1/dataset1_rep0.csv", "ascending", "0");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset1_ordered_10000.csv", "output/quick/dataset1/dataset1_rep1.csv", "ascending", "1");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset1_ordered_10000.csv", "output/quick/dataset1/dataset1_rep2.csv", "ascending", "2");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset1_ordered_10000.csv", "output/quick/dataset1/dataset1_rep3.csv", "ascending", "3");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset1_ordered_10000.csv", "output/quick/dataset1/dataset1_rep4.csv", "ascending", "4");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset1_ordered_10000.csv", "output/quick/dataset1/dataset1_rep5.csv", "ascending", "5");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset1_ordered_10000.csv", "output/quick/dataset1/dataset1_rep6.csv", "ascending", "6");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset1_ordered_10000.csv", "output/quick/dataset1/dataset1_rep7.csv", "ascending", "7");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset1_ordered_10000.csv", "output/quick/dataset1/dataset1_rep8.csv", "ascending", "8");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset1_ordered_10000.csv", "output/quick/dataset1/dataset1_rep9.csv", "ascending", "9");
		
		facade.sortMilestone1("quick", "datasets/milestone3/dataset2_notordered_10000.csv", "output/quick/dataset2/dataset2_rep0.csv", "ascending", "0");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset2_notordered_10000.csv", "output/quick/dataset2/dataset2_rep1.csv", "ascending", "1");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset2_notordered_10000.csv", "output/quick/dataset2/dataset2_rep2.csv", "ascending", "2");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset2_notordered_10000.csv", "output/quick/dataset2/dataset2_rep3.csv", "ascending", "3");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset2_notordered_10000.csv", "output/quick/dataset2/dataset2_rep4.csv", "ascending", "4");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset2_notordered_10000.csv", "output/quick/dataset2/dataset2_rep5.csv", "ascending", "5");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset2_notordered_10000.csv", "output/quick/dataset2/dataset2_rep6.csv", "ascending", "6");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset2_notordered_10000.csv", "output/quick/dataset2/dataset2_rep7.csv", "ascending", "7");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset2_notordered_10000.csv", "output/quick/dataset2/dataset2_rep8.csv", "ascending", "8");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset2_notordered_10000.csv", "output/quick/dataset2/dataset2_rep9.csv", "ascending", "9");
		
		facade.sortMilestone1("quick", "datasets/milestone3/dataset3_random_10000.csv", "output/quick/dataset3/dataset3_rep0.csv", "ascending", "0");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset3_random_10000.csv", "output/quick/dataset3/dataset3_rep1.csv", "ascending", "1");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset3_random_10000.csv", "output/quick/dataset3/dataset3_rep2.csv", "ascending", "2");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset3_random_10000.csv", "output/quick/dataset3/dataset3_rep3.csv", "ascending", "3");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset3_random_10000.csv", "output/quick/dataset3/dataset3_rep4.csv", "ascending", "4");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset3_random_10000.csv", "output/quick/dataset3/dataset3_rep5.csv", "ascending", "5");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset3_random_10000.csv", "output/quick/dataset3/dataset3_rep6.csv", "ascending", "6");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset3_random_10000.csv", "output/quick/dataset3/dataset3_rep7.csv", "ascending", "7");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset3_random_10000.csv", "output/quick/dataset3/dataset3_rep8.csv", "ascending", "8");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset3_random_10000.csv", "output/quick/dataset3/dataset3_rep9.csv", "ascending", "9");*/
		
		/*facade.sortMilestone1("quick", "datasets/milestone3/dataset4_ordered_100.csv", "output/quick/dataset4/dataset4_rep0.csv", "ascending", "0");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset4_ordered_100.csv", "output/quick/dataset4/dataset4_rep1.csv", "ascending", "1");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset4_ordered_100.csv", "output/quick/dataset4/dataset4_rep2.csv", "ascending", "2");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset4_ordered_100.csv", "output/quick/dataset4/dataset4_rep3.csv", "ascending", "3");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset4_ordered_100.csv", "output/quick/dataset4/dataset4_rep4.csv", "ascending", "4");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset4_ordered_100.csv", "output/quick/dataset4/dataset4_rep5.csv", "ascending", "5");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset4_ordered_100.csv", "output/quick/dataset4/dataset4_rep6.csv", "ascending", "6");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset4_ordered_100.csv", "output/quick/dataset4/dataset4_rep7.csv", "ascending", "7");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset4_ordered_100.csv", "output/quick/dataset4/dataset4_rep8.csv", "ascending", "8");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset4_ordered_100.csv", "output/quick/dataset4/dataset4_rep9.csv", "ascending", "9");
		
		facade.sortMilestone1("quick", "datasets/milestone3/dataset5_notordered_100.csv", "output/quick/dataset5/dataset5_rep0.csv", "ascending", "0");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset5_notordered_100.csv", "output/quick/dataset5/dataset5_rep1.csv", "ascending", "1");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset5_notordered_100.csv", "output/quick/dataset5/dataset5_rep2.csv", "ascending", "2");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset5_notordered_100.csv", "output/quick/dataset5/dataset5_rep3.csv", "ascending", "3");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset5_notordered_100.csv", "output/quick/dataset5/dataset5_rep4.csv", "ascending", "4");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset5_notordered_100.csv", "output/quick/dataset5/dataset5_rep5.csv", "ascending", "5");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset5_notordered_100.csv", "output/quick/dataset5/dataset5_rep6.csv", "ascending", "6");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset5_notordered_100.csv", "output/quick/dataset5/dataset5_rep7.csv", "ascending", "7");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset5_notordered_100.csv", "output/quick/dataset5/dataset5_rep8.csv", "ascending", "8");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset5_notordered_100.csv", "output/quick/dataset5/dataset5_rep9.csv", "ascending", "9");
		
		facade.sortMilestone1("quick", "datasets/milestone3/dataset6_random_100.csv", "output/quick/dataset6/dataset6_rep0.csv", "ascending", "0");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset6_random_100.csv", "output/quick/dataset6/dataset6_rep1.csv", "ascending", "1");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset6_random_100.csv", "output/quick/dataset6/dataset6_rep2.csv", "ascending", "2");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset6_random_100.csv", "output/quick/dataset6/dataset6_rep3.csv", "ascending", "3");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset6_random_100.csv", "output/quick/dataset6/dataset6_rep4.csv", "ascending", "4");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset6_random_100.csv", "output/quick/dataset6/dataset6_rep5.csv", "ascending", "5");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset6_random_100.csv", "output/quick/dataset6/dataset6_rep6.csv", "ascending", "6");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset6_random_100.csv", "output/quick/dataset6/dataset6_rep7.csv", "ascending", "7");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset6_random_100.csv", "output/quick/dataset6/dataset6_rep8.csv", "ascending", "8");
		facade.sortMilestone1("quick", "datasets/milestone3/dataset6_random_100.csv", "output/quick/dataset6/dataset6_rep9.csv", "ascending", "9");*/
		
		/*for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("merge", "datasets/milestone3/dataset1_ordered_10000.csv", "output/merge/dataset1/dataset1_rep" + i + ".csv", "ascending", "" + i);
		}
		
		for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("merge", "datasets/milestone3/dataset2_notordered_10000.csv", "output/merge/dataset2/dataset2_rep" + i + ".csv", "ascending", "" + i);
		}
	
		for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("merge", "datasets/milestone3/dataset3_random_10000.csv", "output/merge/dataset3/dataset3_rep" + i + ".csv", "ascending", "" + i);
		}
		
		for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("merge", "datasets/milestone3/dataset4_ordered_100.csv", "output/merge/dataset4/dataset4_rep" + i + ".csv", "ascending", "" + i);
		}
		
		for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("merge", "datasets/milestone3/dataset5_notordered_100.csv", "output/merge/dataset5/dataset5_rep" + i + ".csv", "ascending", "" + i);
		}
		
		for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("merge", "datasets/milestone3/dataset6_random_100.csv", "output/merge/dataset6/dataset6_rep" + i + ".csv", "ascending", "" + i);
		}*/
		
		/*for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("insertion", "datasets/milestone3/dataset1_ordered_10000.csv", "output/insertion/dataset1/dataset1_rep" + i + ".csv", "ascending", "" + i);
		}
		
		for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("insertion", "datasets/milestone3/dataset2_notordered_10000.csv", "output/insertion/dataset2/dataset2_rep" + i + ".csv", "ascending", "" + i);
		}
	
		for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("insertion", "datasets/milestone3/dataset3_random_10000.csv", "output/insertion/dataset3/dataset3_rep" + i + ".csv", "ascending", "" + i);
		}
		
		for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("insertion", "datasets/milestone3/dataset4_ordered_100.csv", "output/insertion/dataset4/dataset4_rep" + i + ".csv", "ascending", "" + i);
		}
		
		for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("insertion", "datasets/milestone3/dataset5_notordered_100.csv", "output/insertion/dataset5/dataset5_rep" + i + ".csv", "ascending", "" + i);
		}
		
		for (int i = 0; i < 10; i++) {
			facade.sortMilestone1("insertion", "datasets/milestone3/dataset6_random_100.csv", "output/insertion/dataset6/dataset6_rep" + i + ".csv", "ascending", "" + i);
		}*/
	}
}
