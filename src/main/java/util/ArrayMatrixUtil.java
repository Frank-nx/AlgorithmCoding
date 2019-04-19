package util;

import java.util.Arrays;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-19 16:33
 **/
public class ArrayMatrixUtil {

    public static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void printMatrix(int[][] matrix){
        if (matrix == null || matrix.length < 1){
            return;
        }
        for (int[] arr:matrix){
            printArray(arr);
        }
    }
}
