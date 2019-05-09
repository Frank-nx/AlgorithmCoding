package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

import java.net.NoRouteToHostException;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-09 09:08
 **/
public class Code18_通过有序数组生成平衡搜索二叉树 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        TreeNode root = generateTree(arr);
        TreeUtil.inOrder(root);
    }

    public static TreeNode generateTree(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        return generateTree(arr,0,arr.length-1);
    }

    private static TreeNode generateTree(int[] arr, int start, int end) {
        if (start > end){
            return null;
        }
        int mid = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(arr[mid]);
        root.left = generateTree(arr,start,mid-1);
        root.right = generateTree(arr,mid + 1,end);
        return root;
    }

}
