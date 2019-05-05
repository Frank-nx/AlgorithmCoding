package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-29 09:06
 **/
public class Code03_如何较为直观的打印二叉树 {

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

        printTree(root);
    }

    public static void printTree(TreeNode root){
        System.out.println("Binary Tree:");
        printInOrder(root,0,"H",17);
        System.out.println();
    }

    private static void printInOrder(TreeNode root, int height, String to, int len) {
        if (root == null){
            return;
        }
        printInOrder(root.right,height+1,"v",len);
        int numLen = (root.value + "").length();
        int frontSpace = (len - 2 - numLen) / 2;
        int backSpace = len - 2 - numLen - frontSpace;
        String param = to + getNumSpace(frontSpace) + root.value + getNumSpace(backSpace) + to;
        System.out.println(getNumSpace(height*len)+param);
        printInOrder(root.left,height+1,"^",len);
    }

    private static String getNumSpace(int len) {
        if (len <= 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }


}
