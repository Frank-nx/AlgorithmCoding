package 程序员代码面试指南.problem03_binaryTree;

import jdk.nashorn.internal.ir.ReturnNode;
import sun.awt.SunHints;
import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 *                 6
 *        /                 \
 *       1                   12
 *    /      \           /         \
 *   0       3          10          13
 *                   /      \     /    \
 *                  4       14   20     16
 *                /   \    /  \
 *               2     5  11   15
 *
 * @author: nixuan
 * @create: 2019-05-06 07:45
 **/
public class Code07_找到二叉树中的最大搜索二叉子树 {

    private static class ReturnType{
        public TreeNode root;
        public int num;
        public int max;
        public int min;

        public ReturnType(TreeNode root, int num, int max, int min) {
            this.root = root;
            this.num = num;
            this.max = max;
            this.min = min;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);
        TreeNode node16 = new TreeNode(16);
        TreeNode node20 = new TreeNode(20);

        root.left = node1;
        root.right = node12;
        node1.left = node0;
        node1.right = node3;
        node12.left = node10;
        node12.right = node13;
        node10.left = node4;
        node10.right = node14;
        node13.left = node20;
        node13.right = node16;
        node4.left = node2;
        node4.right = node5;
        node14.left =  node11;
        node14.right = node15;

        TreeNode res = maxBST(root);
        TreeUtil.preOrder(res);

    }

    public static TreeNode maxBST(TreeNode root){
        if (root == null){
            return root;
        }
        return maxBSTCore(root).root;
    }

    private static ReturnType maxBSTCore(TreeNode root) {
        if (root == null){
            return new ReturnType(null,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        ReturnType left = maxBSTCore(root.left);
        ReturnType right = maxBSTCore(root.right);
        if (root.left == left.root && root.right == right.root && root.value > left.max && root.value < right.min){
            return new ReturnType(root,left.num+right.num+1,Math.min(left.min,root.value),Math.max(right.max,root.value));
        }
        if (left.num > right.num){
            return left;
        }
        return right;
    }
}
