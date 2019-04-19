package 程序员代码面试指南.problem01_StackAndQueue;

import java.util.LinkedList;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-19 15:59
 **/
public class Code07_生成窗口最大值数组 {

    public int[] getMaxWindow(int[] arr,int n){
        if (arr == null || n < 1 || arr.length < n){
            return null;
        }
        int[] res = new int[arr.length - n + 1];
        LinkedList<Integer> qMax = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]){
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (i >= n-1){
                res[i-n+1] = arr[qMax.peekFirst()];
            }
            if (i - qMax.peekFirst() == n - 1){
                qMax.pollFirst();
            }
        }
        return res;
    }

}
