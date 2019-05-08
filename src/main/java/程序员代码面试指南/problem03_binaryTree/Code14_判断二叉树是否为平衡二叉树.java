package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-08 10:12
 **/
public class Code14_判断二叉树是否为平衡二叉树 {

    public static void main(String[] args) {
        String s1 = "1!2!3!4!5!6!7!#!8!9!#!#!#!#!#!#!#!#!#!";
        TreeNode root1 = TreeUtil.buildTreeByLevel(s1);
        System.out.println(isBalanceTree(root1));
        System.out.println(isBalanceTree1(root1));
        String s2 = "1!2!#!3!#!#!#!";
        TreeNode root2 = TreeUtil.buildTreeByLevel(s2);
        System.out.println(isBalanceTree(root2));
        System.out.println(isBalanceTree1(root2));
    }

    public static boolean isBalanceTree(TreeNode root){
        if (root == null){
            return false;
        }
        return check(root) != -1;
    }

    private static int check(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = check(root.left);
        if (left == -1){
            return -1;
        }
        int right = check(root.right);
        if (right == -1){
            return -1;
        }
        int diff = Math.abs(left - right);
        if (diff > 1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

    public static boolean isBalanceTree1(TreeNode root){
        if (root == null){
            return true;
        }
        return check1(root).isB;
    }

    private static ReturnType check1(TreeNode root) {
        if (root == null){
            return new ReturnType(true,0);
        }
        ReturnType left = check1(root.left);
        if (!left.isB){
            return new ReturnType(false,-1);
        }
        ReturnType right = check1(root.right);
        if (!right.isB){
            return new ReturnType(false,-1);
        }
        int diff = Math.abs(left.height - right.height);
        if (diff > 1){
            return new ReturnType(false,-1);
        }
        return new ReturnType(true,Math.max(left.height,right.height)+1);
    }

    private static class ReturnType{
        public boolean isB;
        public int height;

        public ReturnType(boolean isB, int height) {
            this.isB = isB;
            this.height = height;
        }
    }

}
