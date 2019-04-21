package 程序员代码面试指南.problem01_StackAndQueue;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-21 09:38
 **/
public class Code11_可见山峰对数量_无重复 {

    public static void main(String[] args) {
        int[] arr = {2,4,6};
        System.out.println(getVisibleNum(arr));
    }

    public static int getVisibleNum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return 2*arr.length - 3;
    }
}
