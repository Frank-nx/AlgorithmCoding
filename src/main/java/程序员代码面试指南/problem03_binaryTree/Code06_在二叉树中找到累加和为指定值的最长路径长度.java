package 程序员代码面试指南.problem03_binaryTree;


import 程序员代码面试指南.a_nodeClass.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-05 18:16
 **/
public class Code06_在二叉树中找到累加和为指定值的最长路径长度 {

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

        System.out.println(getMaxLength(root,8));
    }

    public static int getMaxLength(TreeNode root,int sum){
        Map<Integer,Integer> help = new HashMap<>();
        help.put(0,0);
        return getMaxLengthCore(root,sum,0,1,0,help);
    }

    private static int getMaxLengthCore(TreeNode root, int sum, int preSum, int level, int maxLen, Map<Integer, Integer> help) {
        if (root == null){
            return maxLen;
        }
        int curSum = preSum + root.value;
        if (!help.containsKey(curSum)){
            help.put(curSum,level);
        }
        if (help.containsKey(curSum - sum)){
            maxLen = Math.max(maxLen,level - help.get(curSum-sum));
        }
        maxLen = getMaxLengthCore(root.left,sum,curSum,level+1,maxLen,help);
        maxLen = getMaxLengthCore(root.right,sum,curSum,level+1,maxLen,help);
        if (level == help.get(curSum)){
            help.remove(curSum);
        }
        return maxLen;
    }

}
