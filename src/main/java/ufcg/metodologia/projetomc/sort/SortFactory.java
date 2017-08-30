package ufcg.metodologia.projetomc.sort;

import ufcg.metodologia.projetomc.util.SortAlgorithm;

public class SortFactory {

    /** O algoritmo de ordenação default é o insertion sortAscending.
     * 'MergeSort' to create the MergeSort algorithm; 'QuickSort', to create QuickSort.
    * */
    public static Sort createSort(SortAlgorithm sortAlgorithm) {
        Sort selected;
        

        switch(sortAlgorithm) {
            case MERGE:
                selected = new MergeSort();
                break;
            case QUICK:
                selected = new QuickSort();
                break;
            case INSERTION:
                selected = new InsertionSort();
                break;
            default:
                throw new RuntimeException("No sort detected for the following input: " + sortAlgorithm);
        }

        return selected;
    }
}
