package ufcg.metodologia.projetomc.sort;

import ufcg.metodologia.projetomc.util.Range;

public class InsertionSort extends Sort {

    @Override
    public long sort(Double[] array, boolean isAscending) {
        long st = System.currentTimeMillis();
        long startTime = System.nanoTime();
        sort(array, new Range(0, array.length), isAscending);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime + "ns - Insertionsort");

        return endTime - startTime;
    }

    public void sort(Double[] array, Range range, boolean isAscending) {
        if (isAscending) {
            sortAscending(array, new Range(range.getBeginIndex(), range.getEndIndex()));
        } else {
            sortDescending(array, new Range(range.getBeginIndex(), range.getEndIndex()));
        }
    }

    private void sortAscending(Double[] array, Range range) {
        final int beginIndex = range.getBeginIndex();
        final int endIndex = range.getEndIndex();

        for (int j = beginIndex; j < endIndex; j++) {
            int i = j - 1;
            Double key = array[j];
            while (i >= 0 && key < array[i]) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }
    }

    private void sortDescending(Double[] array, Range range) {
        final int beginIndex = range.getBeginIndex();
        final int endIndex = range.getEndIndex();

        for (int j = beginIndex; j < endIndex; j++) {
            int i = j - 1;
            Double key = array[j];
            while (i >= 0 && key > array[i]) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }
    }

}
