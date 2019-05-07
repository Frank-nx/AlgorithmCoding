package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;

import java.util.LinkedList;

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
 * @create: 2019-05-07 08:41
 **/
public class Code10_二叉树的zigzag打印 {

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

        printByZigZag(node1);
    }

    public static void printByZigZag(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode last = root;
        TreeNode nLast = null;
        boolean leftToRight = true;
        int level = 1;
        TreeNode cur = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("level " + level++ + " from left to right:");
        while (!queue.isEmpty()){
            if (leftToRight){
                cur = queue.pollFirst();
                System.out.print(cur.value + " ");
                if (cur.left != null){
                    queue.addLast(cur.left);
                    nLast = nLast == null ? cur.left : nLast;
                }
                if (cur.right != null){
                    queue.addLast(cur.right);
                    nLast = nLast == null ? cur.right : nLast;
                }
            }else {
                cur = queue.pollLast();
                System.out.print(cur.value + " ");
                if (cur.right != null){
                    queue.addFirst(cur.right);
                    nLast = nLast == null ? cur.right : nLast;
                }
                if (cur.left != null){
                    queue.addFirst(cur.left);
                    nLast = nLast == null ? cur.left : nLast;
                }
            }
            if (last == cur && !queue.isEmpty()){
                last = nLast;
                leftToRight = !leftToRight;
                nLast = null;
                System.out.print("\nlevel " + level++);
                System.out.print(leftToRight ? " from left to right:" : " from right to left:");
            }
        }
        System.out.println();
    }

}
