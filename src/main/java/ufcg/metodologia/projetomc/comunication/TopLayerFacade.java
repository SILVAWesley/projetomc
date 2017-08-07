package ufcg.metodologia.projetomc.comunication;

public interface TopLayerFacade {
	public abstract void sortMilestone1(String algorithmStr, String inputStr, String outputStr, String orderStr, String replicationsStr);
	public abstract void generateDataset(String nameStr, String orderStr, String sortedElementsStr, String arraySizeStr, String datasetSizeStr);
}
