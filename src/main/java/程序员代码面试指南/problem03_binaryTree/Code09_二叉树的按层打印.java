package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCoding
 * @description:
 *             1
 *         /       \
 *        2         3
 *       /        /   \
 *     4         5     6
 *             /  \
 *            7    8
 * @author: nixuan
 * @create: 2019-05-07 08:23
 **/
public class Code09_二叉树的按层打印 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
        node5.right = node8;

        printByLevel(node1);
    }

    public static void printByLevel(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode last = root;
        TreeNode nLast = null;
        int level  = 1;
        Queue<TreeNode> help = new LinkedList<>();
        help.add(root);
        System.out.print("level " + level++ + ":");
        while (!help.isEmpty()){
            TreeNode cur = help.remove();
            System.out.print(cur.value + " ");
            if (cur.left != null){
                help.add(cur.left);
                nLast = cur.left;
            }
            if (cur.right != null){
                help.add(cur.right);
                nLast = cur.right;
            }
            if (last == cur && !help.isEmpty()){
                last = nLast;
                System.out.print("\nlevel " + level++ + ":");
            }
        }
        System.out.println();
    }
}
