package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-09 08:35
 **/
public class Code17_判断一棵树是否是完全二叉树 {

    public static void main(String[] args) {
        String s = "1!2!3!4!5!6!#!#!#!#!#!#!#!";
        TreeNode root = TreeUtil.buildTreeByLevel(s);
        System.out.println(isCBT(root));
    }

    public static boolean isCBT(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        boolean onlyLeaf = false;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if (cur.left == null && cur.right != null){
                return false;
            }
            if (onlyLeaf && (cur.left != null || cur.right != null)){
                return false;
            }
            if (cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }else{
                onlyLeaf = true;
            }
        }
        return true;
    }

}
