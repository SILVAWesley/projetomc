package ufcg.metodologia.projetomc.util;

import java.util.Random;

/**
 * Created by Lucas on 06/08/2017.
 */
public class ArrayGenerator {

    private static Random random;

    private final static double MAX_NUMBER = 1000000.0;
    private final static double MIN_NUMBER = -1000000.0;

    private final static int TOTAL_OF_ARRAYS = 5000;
    private final static int TOTAL_NUMBS_IN_ARRAY = 10000;

    public static int getArrayMaxSize() {
        return TOTAL_NUMBS_IN_ARRAY;
    }

    public static Double[][] generateArraysWithRandomNumbers() {
        int curr_array = 0;
        random = new Random();

        Double[][] randomMatrix = new Double[TOTAL_OF_ARRAYS][TOTAL_OF_ARRAYS];

        final boolean isNotLargestPossibleDouble = !Double.valueOf(MAX_NUMBER - MIN_NUMBER).isInfinite();
        if(isNotLargestPossibleDouble) {
            while (curr_array < TOTAL_OF_ARRAYS) {
                Double[] array = new Double[TOTAL_NUMBS_IN_ARRAY];
                for (int i = 0; i < TOTAL_NUMBS_IN_ARRAY; i++) {
                    array[i] = MIN_NUMBER + (MAX_NUMBER - MIN_NUMBER) * random.nextDouble();//gerar valores aleatórios double
                }
                randomMatrix[curr_array] = array;
                curr_array++;
            }
        }
        return randomMatrix;
    }
}
