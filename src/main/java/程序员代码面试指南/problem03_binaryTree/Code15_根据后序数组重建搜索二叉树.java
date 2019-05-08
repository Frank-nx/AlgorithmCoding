package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-08 10:39
 **/
public class Code15_根据后序数组重建搜索二叉树 {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        System.out.println(isPostArray(arr1));
        int[] arr2 = {6,5,4,3,2,1};
        System.out.println(isPostArray(arr2));
        int[] arr3 = {1,2,5,3,6,4};
        System.out.println(isPostArray(arr3));

        TreeNode root1 = postArrayToBST(arr1);
        TreeUtil.posOrder(root1);
    }

    public static boolean isPostArray(int[] arr){
        if (arr == null || arr.length == 0){
            return false;
        }
        return isPostArrayCore(arr,0,arr.length-1);
    }

    private static boolean isPostArrayCore(int[] arr, int start, int end) {
        if (start >= end){
            return true;
        }
        int index = start;
        while (arr[index] < arr[end]){
            index++;
        }
        for (int i = index; i < end; i++) {
            if (arr[i] < arr[end]){
                return false;
            }
        }
        return isPostArrayCore(arr,start,index-1) && isPostArrayCore(arr,index,end-1);
    }

    public static TreeNode postArrayToBST(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        return postArrayToBSTCore(arr,0,arr.length-1);
    }

    private static TreeNode postArrayToBSTCore(int[] arr, int start, int end) {
        if (start > end){
            return null;
        }
        if (start == end){
            return new TreeNode(arr[start]);
        }
        int index = start;
        while (arr[index] < arr[end]){
            index++;
        }
        TreeNode root = new TreeNode(arr[end]);
        root.left = postArrayToBSTCore(arr,start,index-1);
        root.right = postArrayToBSTCore(arr,index,end-1);
        return root;
    }
}
