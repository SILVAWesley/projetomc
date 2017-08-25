package ufcg.metodologia.projetomc.sort;

import ufcg.metodologia.projetomc.util.Range;

public class QuickSort extends Sort {

    @Override
    public long sort(Double[] array, boolean isAscending) {
        long startTime = System.nanoTime();
        sort(array, new Range(0, array.length - 1), isAscending);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public void sort(Double[] array, Range range, boolean isAscending) {
        if (range.getBeginIndex() < range.getEndIndex() && range.getBeginIndex() >= 0){
            int pivot_position = partition(array, new Range(range.getBeginIndex(), range.getEndIndex()), isAscending);
            sort(array, new Range(range.getBeginIndex(), pivot_position - 1), isAscending);
            sort(array, new Range(pivot_position + 1, range.getEndIndex()), isAscending);
        }
    }

    public int partition(Double[] array, Range range, boolean isAscending){
        int pivot_index = range.getBeginIndex();
        Double pivot = array[range.getBeginIndex()];

        for (int j = pivot_index + 1; j <= range.getEndIndex(); j++) {
            if (isAscending) {
                if (array[j].compareTo(pivot) < 0){
                    pivot_index++;
                    swap(array, pivot_index, j);
                }
            } else {
                if (array[j].compareTo(pivot) > 0){
                    pivot_index++;
                    swap(array, pivot_index, j);
                }
            }
        }
        swap(array, range.getBeginIndex(), pivot_index);

        return pivot_index;
    }

    private void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
