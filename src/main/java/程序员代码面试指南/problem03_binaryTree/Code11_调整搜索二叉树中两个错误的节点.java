package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;

import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-07 09:14
 **/
public class Code11_调整搜索二叉树中两个错误的节点 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node4.left = node5;
        node4.right = node2;
        node5.left = node1;
        node5.right = node3;
        node2.right = node6;

        TreeNode[] res = getTwoErrNodes(node4);
        System.out.println(res[0].value + "   " + res[1].value);
    }

    public static TreeNode[] getTwoErrNodes(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode[] err = new TreeNode[2];
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.value > cur.value){
                err[0] = err[0] == null ? pre : err[0];
                err[1] = cur;
            }
            pre = cur;
            cur = cur.right;
        }
        return err;
    }

}
