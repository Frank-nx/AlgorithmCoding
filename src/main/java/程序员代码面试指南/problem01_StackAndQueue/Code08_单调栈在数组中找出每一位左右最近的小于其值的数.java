package 程序员代码面试指南.problem01_StackAndQueue;

import 程序员代码面试指南.a_util.ArrayMatrixUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-19 16:23
 **/
public class Code08_单调栈在数组中找出每一位左右最近的小于其值的数 {

    public static void main(String[] args) {
        int[] arr = {3,4,1,5,6,2,7};
        int[][] res = getNearLessNoRepeat(arr);
        ArrayMatrixUtil.printMatrix(res);
        System.out.println("===============================");
        int[] arr1 = {3,4,1,5,3,2,2,6};
        int[][] res1 = getNearLessRepeat(arr1);
        ArrayMatrixUtil.printMatrix(res1);
    }

    public static int[][] getNearLessNoRepeat(int[] arr){
        if (arr == null){
            return null;
        }
        int[][] res = new int[arr.length][2];
        Stack<Integer> help = new Stack<>();
        for (int i = 0; i < res.length; i++) {
            while(!help.isEmpty() && arr[help.peek()] > arr[i]){
                int index = help.pop();
                res[index][0] = help.isEmpty() ? -1 : help.peek();
                res[index][1] = i;
            }
            help.push(i);
        }
        while (!help.isEmpty()){
            int index = help.pop();
            res[index][0] = help.isEmpty() ? -1 : help.peek();
            res[index][1] = -1;
        }
        return res;
    }

    public static int[][] getNearLessRepeat(int[] arr){
        if (arr == null || arr.length < 1){
            return null;
        }
        Stack<LinkedList<Integer>> help = new Stack<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!help.isEmpty() && arr[help.peek().get(0)] > arr[i]){
                List<Integer> list = help.pop();
                for(Integer index:list){
                    res[index][0] = help.isEmpty() ? -1 : help.peek().get(help.peek().size()-1);
                    res[index][1] = i;
                }
            }
            int index = help.isEmpty() ? -1 : help.peek().get(0);
            LinkedList<Integer> temp = (index == -1?false:arr[index]==arr[i])?help.peek():new LinkedList<>();
            temp.add(i);
            help.push(temp);
        }
        while (!help.isEmpty()){
            List<Integer> list = help.pop();
            for(Integer index:list){
                res[index][0] = help.isEmpty() ? -1 : help.peek().get(help.peek().size()-1);
                res[index][1] = -1;
            }
        }
        return res;
    }

}
