package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-08 11:07
 **/
public class Code16_判断一棵树是否是搜索二叉树 {

    public static void main(String[] args) {
        String s1 = "6!#!5!#!4!#!3!#!2!#!1!#!#!";
        String s2 = "6!5!#!4!#!3!#!2!#!1!#!#!#!";
        TreeNode root = TreeUtil.buildTreeByLevel(s2);
        System.out.println(isBST(root));
    }

    public static boolean isBST(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur =cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.value > cur.value){
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}
