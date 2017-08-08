package ufcg.metodologia.projetomc;

import ufcg.metodologia.projetomc.comunication.TopLayerController;
import ufcg.metodologia.projetomc.comunication.TopLayerFacade;

public class Main {
	/* INSTRUÇÕES:
	 * 
	 * - PARA RODAR O SORT PARA O MILESTONE 1 USE 'sort_m1' NO PRIMEIRO ARGUMENTO.
	 * 		CASO ESCOLHA RODAR O SORT, TAMBÉM INSIRA OS SEGUINTES ARGUMENTOS EM ORDEM:
	 * 			1) O ALGORITMO ('insertion', 'merge' ou 'quick').
	 * 			2) O CAMINHO DO ARQUIVO DE INPUT (Caminho para um dataset gerado pelo comando 'dataset_gen').
	 * 			3) A ORDEM DE ORDENAÇÃO DO ALGORITMO (ascending ou descending, não colocar none).
	 * 			4) A QUANTIDADE DE REPLICAÇÕES SOBRE CADA EXECUÇÃO DO ALGORITMO (Um número inteiro '0' ou maior. '0' significa sem replicação).
	 * 		EXEMPLOS: sort_m1 datasets/milestone1/dataset1.csv output/output1.csv merge ascending 0
	 * 				  sort_m1 quick descending 1
	 * 				  sort_m1 insertion ascending 5
	 * - PARA GERAR UM DATASET USE 'dataset_gen' NO PRIMEIRO ARGUMENTO.
	 * 		CASO ESCOLHA GERAR UM DATASET, TAMBÉM INSIRA OS SEGUINTES ARGUMENTOS EM ORDEM:
	 * 			1) O NOME DO ARQUIVO A SER GERADO (Sem incluir a extensão CSV).
	 * 			2) A ORDEM NA QUAL OS NÚMEROS SERÃO ORDENADOS ('ascending', 'descending' ou 'none'. None para não especificar uma ordem). 
	 * 			3) A QUANTIDADE DE ELEMENTOS QUE SERÃO GERADOS ORDENADOS ('all' para todos os elementos e 'none' para nenhum).
	 * 			4) O TAMANHO DE CADA ARRAY GERADO (Um número inteiro 0 ou maior).
	 * 			5) A QUANTIDADE DE ARRAYS QUE SERÃO GERADOS (Um número inteiro 0 ou maior).
	 * 		EXEMPLOS: dataset_gen meu_dataset.csv ascending all 10 10
	 * 			      dataset_gen milestone1/meu_dataset none all 1 100
	 * OBS.: IGNORAR OS CARACTERES ' E " NAS INSTRUÇÕES.
	 */
    public static void main(String[] args) {
    	TopLayerFacade facade = new TopLayerController();
    	
    	if (args[0].equalsIgnoreCase("sort_m1")) {
    		String argAlgorithm = args[1];
    		String argInput = args[2];
    		String argOutput = args[3];
    		String argOrder = args[4];
    		String argReplications = args[5];
    		facade.sortMilestone1(argAlgorithm, argInput, argOutput, argOrder, argReplications);
    	} else if (args[0].equalsIgnoreCase("dataset_gen")) {
    		String argName = args[1];
    		String argOrder = args[2];
    		String argSortType = args[3];
    		String argArraySize = args[4];
    		String argDatasetSize = args[5];
    		facade.generateDataset(argName, argOrder, argSortType, argArraySize, argDatasetSize);
    	} else if (args[0].equalsIgnoreCase("run_experiment")) {
    		throw new RuntimeException("Area under construction. Choose another command to run.");
    	} else {
    		throw new RuntimeException("The value of the first argument is not valid.");
    	}
    }
}
