package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-09 20:48
 **/
public class Code20_在二叉树中找到两个节点的最近公共祖先 {

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
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node7.left = node8;

        TreeUtil.printNodeValue(lowestAncestor(node1,node4,node8));
        TreeUtil.printNodeValue(lowestAncestor(node1,node4,node2));
        TreeUtil.printNodeValue(lowestAncestor(node1,node5,node1));
    }

    public static TreeNode lowestAncestor(TreeNode head,TreeNode node1,TreeNode node2){
        if (head == null || head == node1 || head == node2){
            return head;
        }
        TreeNode left = lowestAncestor(head.left,node1,node2);
        TreeNode right = lowestAncestor(head.right,node1,node2);
        if (left != null && right != null){
            return head;
        }
        return left == null ? right : left;

    }



}
