package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-06 09:05
 **/
public class Code08_找到二叉树中符合搜索二叉树条件的最大拓扑结构 {

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

        System.out.println(bstTopoSize1(root));
        System.out.println(bstTopoSize2(root));
    }

    public static int bstTopoSize1(TreeNode root){
        if (root == null){
            return 0;
        }
        int max = maxTop(root,root);
        max = Math.max(bstTopoSize1(root.left),max);
        max = Math.max(bstTopoSize1(root.right),max);
        return max;
    }

    public static int maxTop(TreeNode root,TreeNode node){
        if (node != null && isBST(root,node)){
            return maxTop(root,node.left) + maxTop(root,node.right) + 1;
        }
        return 0;
    }

    public static boolean isBST(TreeNode root,TreeNode node){
        if (root == null){
            return false;
        }
        if (root == node){
            return true;
        }
        return isBST(root.value > node.value ? root.left:root.right,node);
    }

    private static class Record{
        public int leftNum;
        public int rightNum;

        public Record(int leftNum, int rightNum) {
            this.leftNum = leftNum;
            this.rightNum = rightNum;
        }
    }

    public static int bstTopoSize2(TreeNode root){
        if (root == null){
            return 0;
        }
        Map<TreeNode,Record> help = new HashMap<>();
        return posOrder(root,help);
    }

    private static int posOrder(TreeNode root, Map<TreeNode, Record> help) {
        if (root == null){
            return 0;
        }
        int ls = posOrder(root.left,help);
        int rs = posOrder(root.right,help);
        modifyMap(root.left,root.value,help,true);
        modifyMap(root.right,root.value,help,false);
        Record l = help.get(root.left);
        Record r = help.get(root.right);
        int lbst = l == null ? 0 : l.leftNum+l.rightNum+1;
        int rbst = r == null ? 0 : r.leftNum+r.rightNum+1;
        help.put(root,new Record(lbst,rbst));
        return Math.max(lbst+rbst+1,Math.max(ls,rs));
    }

    private static int modifyMap(TreeNode root,int value, Map<TreeNode,Record> help, boolean right) {
        if (root == null || !help.containsKey(root)){
            return 0;
        }
        if ((right && root.value > value) || (!right && root.value < value)){
            Record r = help.remove(root);
            return r.leftNum + r.rightNum + 1;
        }
        int diff = modifyMap(right ? root.right : root.left,value,help,right);
        Record r = help.get(root);
        help.put(root,new Record(right ? r.leftNum - diff:r.leftNum,!right ? r.rightNum - diff : r.rightNum));
        return diff;
    }
}
