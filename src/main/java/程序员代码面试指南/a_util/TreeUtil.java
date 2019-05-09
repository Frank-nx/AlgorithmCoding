package 程序员代码面试指南.a_util;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.problem03_binaryTree.Code01_二叉树的前中后遍历;
import 程序员代码面试指南.problem03_binaryTree.Code04_二叉树的序列化和反序列化;
import 程序员代码面试指南.problem03_binaryTree.Code09_二叉树的按层打印;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-27 10:24
 **/
public class TreeUtil {

    private static Code01_二叉树的前中后遍历 code01 = new Code01_二叉树的前中后遍历();

    public static TreeNode buildTreeByLevel(String s){
        return Code04_二叉树的序列化和反序列化.deserialByLevel(s);
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

    public static void printLevel(TreeNode root){
        Code09_二叉树的按层打印.printByLevel(root);
    }

    public static void printNodeValue(TreeNode root){
        if (root == null){
            System.out.println("null");
        }else{
            System.out.println(root.value);
        }
    }
}
