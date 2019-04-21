package 程序员代码面试指南.problem01_StackAndQueue;

import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-20 21:52
 **/
public class Code09_求最大子矩阵的大小 {


    public static void main(String[] args) {
        int[][] map = {
                {1,0,1,1},
                {1,1,1,1},
                {1,1,1,0}
        };
        int res = maxRecSize(map);
        System.out.println(res);
        int[] arr = {3,4,5,4,3,6};
        System.out.println(maxSizeOfArray(arr));
    }

    public static int maxRecSize(int[][] map){
        if (map == null ||map.length == 0){
            return 0;
        }
        int[] help = new int[map[0].length];
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                help[j] = map[i][j] == 0 ? 0 : map[i][j] + help[j];
            }
            int max = maxSizeOfArray(help);
            res = Math.max(res,max);
        }
        return res;
    }

    public static int maxSizeOfArray(int[] arr){
        if (arr == null || arr.length ==  0){
            return 0;
        }
        Stack<Integer> help = new Stack<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            while(!help.isEmpty() && arr[help.peek()] > arr[i]){
                int high = arr[help.pop()];
                int width = i - 1 - (help.isEmpty()?-1:help.peek());
                res = Math.max(res,high*width);
            }
            help.push(i);
        }
        while (!help.isEmpty()){
            int high = arr[help.pop()];
            int width = arr.length - 1 - (help.isEmpty()?-1:help.peek());
            res = Math.max(res,high*width);
        }
        return res;
    }

}
