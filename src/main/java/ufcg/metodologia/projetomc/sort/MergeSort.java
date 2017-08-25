package ufcg.metodologia.projetomc.sort;

import java.util.Arrays;

import ufcg.metodologia.projetomc.util.Range;

public class MergeSort extends Sort {

    private Double[] helper;

    @Override
    public long sort(Double[] array, boolean isAscending) {
        long startTime = System.nanoTime();
        sort(array, new Range(0, array.length - 1), isAscending);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public void sort(Double[] array, Range range, boolean isAscending) {
        if (range.getBeginIndex() < range.getEndIndex()){
            int mid = (range.getEndIndex() + range.getBeginIndex()) / 2;
            sort(array, new Range(range.getBeginIndex(), mid), isAscending);
            sort(array, new Range(mid + 1, range.getEndIndex()), isAscending);
            if (isAscending){
                mergeTwoSortedListAsc(array, new Range(range.getBeginIndex(), mid, range.getEndIndex()));
            } else {
                mergeTwoSortedListDesc(array, new Range(range.getBeginIndex(), mid, range.getEndIndex()));
            }
        }
    }

    private void mergeTwoSortedListAsc(Double[] array, Range range) {
        final int beginIndex = range.getBeginIndex();
        final int endIndex = range.getEndIndex();
        final int midIndex = range.getMidIndex();

        helper = Arrays.copyOfRange(array, beginIndex, endIndex + 1);

        int i = 0;
        int j = midIndex - beginIndex + 1;
        int k = beginIndex;

        while (i <= midIndex - beginIndex && j <= endIndex - beginIndex) {
            if (helper[i].compareTo(helper[j]) < 0) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= midIndex - beginIndex) {
            array[k++] = helper[i++];
        }
        while (j <= endIndex - beginIndex) {
            array[k++] = helper[j++];
        }
    }

    private void mergeTwoSortedListDesc(Double[] array, Range range) {
        final int beginIndex = range.getBeginIndex();
        final int endIndex = range.getEndIndex();
        final int midIndex = range.getMidIndex();

        helper = Arrays.copyOfRange(array, beginIndex, endIndex + 1);

        int i = 0;
        int j = midIndex - beginIndex + 1;
        int k = beginIndex;

        while (i <= midIndex - beginIndex &&
                j <= endIndex - beginIndex) {
            if (helper[i].compareTo(helper[j]) > 0) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= midIndex - beginIndex) {
            array[k++] = helper[i++];
        }
        while (j <= endIndex - beginIndex) {
            array[k++] = helper[j++];
        }
    }
}
