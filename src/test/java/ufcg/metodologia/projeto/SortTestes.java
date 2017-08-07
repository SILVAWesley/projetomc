package ufcg.metodologia.projeto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ufcg.metodologia.projetomc.sort.InsertionSort;
import ufcg.metodologia.projetomc.sort.MergeSort;
import ufcg.metodologia.projetomc.sort.QuickSort;
import ufcg.metodologia.projetomc.sort.Sort;
import ufcg.metodologia.projetomc.sort.SortFactory;
import ufcg.metodologia.projetomc.util.ArrayGenerator;
import ufcg.metodologia.projetomc.util.SortAlgorithm;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Lucas on 02/08/2017.
 */
public class SortTestes {
    private final Double[] ascendingArray = {-1.0, -1.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
    private final Double[] descendingArray = {10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, -1.0, -1.0};
    private final Double[] shuffledArray = {10.0, -1.0, -1.0, 3.0, 9.0, 5.0, 8.0, 4.0, 7.0, 6.0};
    private final Double[] shuffledNegArray = {-10.0, -1.0, -1.0, -3.0, -9.0, -5.0, -8.0, -4.0, -7.0, -6.0};
    private final Double[] emptyArray = {};

    private Double[] ascending = new Double[10];
    private Double[] descending = new Double[10];
    private Double[] shuffled = new Double[10];
    private Double[] shuffledNeg = new Double[10];
    private Double[] empty = {};

    private final Double[] expectedArray = {-1.0, -1.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
    private final Double[] expectedNegArray = {-10.0, -9.0, -8.0, -7.0, -6.0, -5.0, -4.0, -3.0, -1.0, -1.0};

    private Double[][] randomArrays;

    private Sort quickSort;
    private Sort mergeSort;
    private Sort insertionSort;

    @Before
    public void setUp() {
        randomArrays = ArrayGenerator.generateArraysWithRandomNumbers();

        ascending = Arrays.copyOfRange(ascendingArray, 0, 10);
        descending = Arrays.copyOfRange(descendingArray, 0, 10);
        shuffled = Arrays.copyOfRange(shuffledArray, 0, 10);
        shuffledNeg = Arrays.copyOfRange(shuffledNegArray, 0, 10);
        quickSort = new QuickSort();
        insertionSort = new InsertionSort();
        mergeSort = new MergeSort();
    }

    @Test
    public void testQuickSortElementsElementsAscendingOrderOrder(){
        quickSort.sort(ascending, true);
        assertArrayEquals(expectedArray, ascending);
    }

    @Test
    public void testQuickSortElementsDescendingOrder(){
        quickSort.sort(descending, true);
        assertArrayEquals(expectedArray, descending);
    }

    @Test
    public void testQuickSortShuffled(){
        quickSort.sort(shuffled, true);
        assertArrayEquals(expectedArray, shuffled);
    }

    @Test
    public void testQuickSortNegShuffled(){
        quickSort.sort(shuffledNeg, true);
        assertArrayEquals(expectedNegArray, shuffledNeg);
    }

    @Test
    public void testQuickSortEmpty(){
        quickSort.sort(empty,true );
        assertArrayEquals(emptyArray, empty);
    }

    @Test
    public void testMergeSortElementsAscendingOrder(){
        mergeSort.sort(ascending, true);
        assertArrayEquals(expectedArray, ascending);
    }

    @Test
    public void testMergeSortElementsElementsDescendingOrderOrder(){
        mergeSort.sort(descending,true );
        assertArrayEquals(expectedArray, descending);
    }

    @Test
    public void testMergeSortShuffled(){
        mergeSort.sort(shuffled,true );
        assertArrayEquals(expectedArray, shuffled);
    }

    @Test
    public void testMergeSortNegShuffled(){
        mergeSort.sort(shuffledNeg,true );
        assertArrayEquals(expectedNegArray, shuffledNeg);
    }

    @Test
    public void testMergeSortEmpty(){
        mergeSort.sort(empty, true);
        assertArrayEquals(emptyArray, empty);
    }

    @Test
    public void testInsertionSortElementsAscendingOrder(){
        insertionSort.sort(ascending,true );
        assertArrayEquals(expectedArray, ascending);
    }

    @Test
    public void testInsertionSortElementsDescendingOrder(){
        insertionSort.sort(descending,true );
        assertArrayEquals(expectedArray, descending);
    }

    @Test
    public void testInsertionSortShuffled(){
        insertionSort.sort(shuffled, true);
        assertArrayEquals(expectedArray, shuffled);
    }

    @Test
    public void testInsertionSortNegShuffled(){
        insertionSort.sort(shuffledNeg, true);
        assertArrayEquals(expectedNegArray, shuffledNeg);
    }

    @Test
    public void testInsertionSortEmpty(){
        insertionSort.sort(empty, true);
        assertArrayEquals(emptyArray, empty);
    }

    /*Esse teste demora na faixa de 60-70 segundos para rodar.*/
    @Test
    public void automatedTestForQuickSort(){
        Sort qs = SortFactory.createSort(SortAlgorithm.QUICK);
        evaluateSort(qs);
    }

    /*Esse teste demora na faixa de 60-65 segundos para rodar.*/
    @Test
    public void automatedTestForMergeSort(){
        Sort ms = SortFactory.createSort(SortAlgorithm.MERGE);
        evaluateSort(ms);
    }

    /*Esse teste demora na faixa de 3 minutos e 10-20 segundos para rodar.*/
    @Test
    public void automatedTestForInsertionSort(){
        Sort is = SortFactory.createSort(SortAlgorithm.INSERTION);
        evaluateSort(is);
    }

    /**Avalia meu algoritmo de ordenação contra a implementação fornecida pelo próprio Java.
     * Isso fornece confiança de que minha implementação está adequada.*/
    private void evaluateSort(Sort mySort) {
        for (Double[] array: randomArrays) {
            Double[] tmp = Arrays.copyOfRange(array, 0, ArrayGenerator.getArrayMaxSize());
            mySort.sort(array, true);
            Arrays.sort(tmp);
            Assert.assertArrayEquals(tmp, array);
        }
    }

}
