package 程序员代码面试指南.a_util;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.problem03_binaryTree.Code01_二叉树的前中后遍历;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-27 10:24
 **/
public class TreeUtil {

    private static Code01_二叉树的前中后遍历 code01 = new Code01_二叉树的前中后遍历();

    public static TreeNode buildTreeByLevel(String[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        return buildTreeByLevel(arr,0);
    }

    private static TreeNode buildTreeByLevel(String[] arr, int index) {
        if (arr[index] == "#"){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        if (2*index+1 < arr.length){
            root.left = buildTreeByLevel(arr,index*2+1);
        }
        if (2 * index + 2 < arr.length){
            root.right = buildTreeByLevel(arr,index*2+2);
        }
        return root;
    }

    public static void preOrder(TreeNode root){
        code01.preOrder(root);
    }

    public static void inOrder(TreeNode root){
        code01.inOrder(root);
    }

    public static void posOrder(TreeNode root){
        code01.posOrder(root);
    }
}
