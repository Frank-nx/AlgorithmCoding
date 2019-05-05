package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-29 10:58
 **/
public class Code05_morris遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node4.right = node7;
        node3.left = node5;
        node3.right = node6;

        TreeUtil.preOrder(root);
        morrisPreOrder(root);

        System.out.println("====================");

        TreeUtil.inOrder(root);
        morrisInOrder(root);

        System.out.println("====================");

        TreeUtil.posOrder(root);
        morrisPosOrder(root);
    }

    public static void morris(TreeNode root){
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void morrisPreOrder(TreeNode root){
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    System.out.print(cur.value + ",");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }else{
                System.out.print(cur.value + ",");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    public static void morrisInOrder(TreeNode root){
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value + ",");
            cur = cur.right;
        }
        System.out.println();
    }

    public static void morrisPosOrder(TreeNode root){
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(root  );
        System.out.println();
    }

    private static void printEdge(TreeNode root) {
        TreeNode tail = reverse(root);
        TreeNode cur = tail;
        while (cur != null){
            System.out.print(cur.value + ",");
            cur = cur.right;
        }
        reverse(tail);
    }

    private static TreeNode reverse(TreeNode root){
        TreeNode pre = null;
        while (root != null){
            TreeNode temp = root.right;
            root.right = pre;
            pre = root;
            root = temp;
        }
        return pre;
    }

}
