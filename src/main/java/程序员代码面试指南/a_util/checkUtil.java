package 程序员代码面试指南.a_util;

import java.util.Random;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-23 09:18
 **/
public class checkUtil {

    private int[] generateRandomArray(int size){
        if (size < 0){
            throw new RuntimeException("the size must more than or equals zero!");
        }
        int len = (int) (Math.random()*((double)size+1));
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int num = (int) (Math.random()*((double) Integer.MAX_VALUE+1) + Math.random()*((double) Integer.MIN_VALUE-1));
            arr[i] = num;
        }
        return arr;
    }

}
