package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;

import java.nio.file.attribute.PosixFileAttributes;
import java.time.chrono.IsoChronology;
import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-27 10:06
 **/
public class Code01_二叉树的前中后遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println("前序遍历：");
        preOrderRec(root);
        System.out.println();
        preOrder(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderRec(root);
        System.out.println();
        inOrder(root);
        System.out.println();

        System.out.println("后序遍历：");
        posOrderRec(root);
        System.out.println();
        posOrder(root);
        System.out.println();
        posOrderWithOneStack(root);
    }

    public static void preOrderRec(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.value + ",");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    public static void preOrder(TreeNode root){
        System.out.print("preOrder:");
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        while (!stack.isEmpty()){
            cur = stack.pop();
            System.out.print(cur.value + ",");
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        System.out.println();
    }

    public static void inOrderRec(TreeNode root){
        if (root == null){
            return;
        }
        inOrderRec(root.left);
        System.out.print(root.value + ",");
        inOrderRec(root.right);
    }

    public static void inOrder(TreeNode root){
        System.out.print("inOrder:");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.value + ",");
            cur = cur.right;
        }
        System.out.println();
    }

    public static void posOrderRec(TreeNode root){
        if (root == null){
            return;
        }
        posOrderRec(root.left);
        posOrderRec(root.right);
        System.out.print(root.value + ",");
    }

    public static void posOrder(TreeNode root){
        System.out.print("posOrder:");
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        while (!stack.isEmpty()){
            cur = stack.pop();
            help.push(cur);
            if (cur.left != null){
                stack.push(cur.left);
            }
            if (cur.right != null){
                stack.push(cur.right);
            }
        }
        while (!help.isEmpty()){
            System.out.print(help.pop().value + ",");
        }
        System.out.println();
    }

    public static void posOrderWithOneStack(TreeNode root){
        System.out.print("posOrder:");
        if (root != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode h = root;
            TreeNode top = null;
            while (!stack.isEmpty()){
                top = stack.peek();
                if (top.left != null && top.left != h && top.right != h){
                    stack.push(top.left);
                }else if (top.right != null && top.right != h){
                    stack.push(top.right);
                }else{
                    System.out.print(top.value + ",");
                    h = stack.pop();
                }
            }
        }
        System.out.println();
    }
}
