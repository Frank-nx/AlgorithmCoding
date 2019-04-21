package 程序员代码面试指南.problem01_StackAndQueue;

import org.omg.CORBA.INTERNAL;
import sun.java2d.pipe.SpanIterator;

import java.util.LinkedList;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-20 22:28
 **/
public class Code10_最大值减去最小值小于等于num的子数组数量 {

    public static void main(String[] args) {
        int[] arr = {1,4,2,4,6};
        System.out.println(getNum(arr,2));
    }

    public static int getNum(int[] arr,int num){
        if (arr == null || arr.length == 0 || num < 0){
            return 0;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int res = 0;
        int i = 0;
        int j = 0;
        while(i < arr.length){
            while(j < arr.length) {
                if (qmax.isEmpty() || qmax.peekLast() != j) {
                    while (!qmax.isEmpty() && arr[qmax.peekLast()] < arr[j]) {
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                    while (!qmin.isEmpty() && arr[qmin.peekLast()] > arr[j]) {
                        qmin.pollLast();
                    }
                    qmin.addLast(j);
                }
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
                    break;
                }
                j++;
            }
            res += j - i;
            if (qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            if (qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            i++;
        }
        return res;
    }

}
