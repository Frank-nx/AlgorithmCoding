package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-08 09:11
 **/
public class Code12_判断t1树是否包含t2树的全部的拓扑结构 {

    public static void main(String[] args) {
        String s1 = "1!2!3!4!5!6!7!8!9!10!#!#!#!#!#!#!#!#!#!#!#!";
        String s2 = "2!4!5!8!#!#!#!#!#!";
        TreeNode root1 = TreeUtil.buildTreeByLevel(s1);
        TreeNode root2 = TreeUtil.buildTreeByLevel(s2);
        System.out.println(contains(root1,root2));
    }

    public static boolean contains(TreeNode root1,TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        return check(root1,root2) || contains(root1.left,root2) || contains(root1.right,root2);
    }

    private static boolean check(TreeNode root1, TreeNode root2) {
        if (root2 == null){
            return true;
        }
        if (root1 == null || root1.value != root2.value){
            return false;
        }
        return check(root1.left,root2.left) && check(root1.right,root2.right);
    }

}
