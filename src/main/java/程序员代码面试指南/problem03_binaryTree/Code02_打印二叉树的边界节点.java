package 程序员代码面试指南.problem03_binaryTree;

import com.sun.javafx.geom.Edge;
import 程序员代码面试指南.a_nodeClass.TreeNode;

import java.util.LinkedList;
import java.util.logging.Level;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-28 08:52
 **/
public class Code02_打印二叉树的边界节点 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
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

        root.left = node2;
        root.right = node3;
        node2.right = node4;
        node4.left = node7;
        node4.right = node8;
        node8.right = node11;
        node11.left = node13;
        node11.right = node14;
        node3.left = node5;
        node3.right = node6;
        node5.left = node9;
        node5.right = node10;
        node9.left = node12;
        node12.left = node15;
        node12.right = node16;

        LinkedList<Integer> res = printEdge1(root);
        System.out.println(res);
        LinkedList<Integer> res1 = printEdge2(root);
        System.out.println(res1);
    }

    public static LinkedList<Integer> printEdge1(TreeNode root){
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null){
            return null;
        }
        int height = getHeight(root,0);
        TreeNode[][] edgeMap = new TreeNode[height][2];
        getLeftRightEdge(root,edgeMap,0);
        for (int i = 0; i < edgeMap.length; i++){
            res.add(edgeMap[i][0].value);
        }
        printLeafNode(root,res,edgeMap,0);
        for (int i = edgeMap.length - 1;i >=0;i--){
            if (edgeMap[i][0] != edgeMap[i][1]){
                res.add(edgeMap[i][1].value);
            }
        }
        return res;
    }

    private static int getHeight(TreeNode root,int level){
        if (root == null){
            return level;
        }
        return Math.max(getHeight(root.left,level+1),getHeight(root.right,level+1));
    }

    private static void getLeftRightEdge(TreeNode root,TreeNode[][] edgeMap,int level){
        if (root == null){
            return;
        }
        edgeMap[level][0] = edgeMap[level][0] == null ? root : edgeMap[level][0];
        edgeMap[level][1] = root;
        getLeftRightEdge(root.left,edgeMap,level+1);
        getLeftRightEdge(root.right,edgeMap,level+1);
    }

    private static void printLeafNode(TreeNode root,LinkedList<Integer> res,TreeNode[][] edgeMap,int level){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null && root != edgeMap[level][0] && root != edgeMap[level][1]){
            res.add(root.value);
        }
        printLeafNode(root.left,res,edgeMap,level+1);
        printLeafNode(root.right,res,edgeMap,level+1);
    }

    public static LinkedList<Integer> printEdge2(TreeNode root){
        LinkedList<Integer> res = new LinkedList<>();
        printEdge2(root,res);
        return res;
    }

    private static void printEdge2(TreeNode root, LinkedList<Integer> res) {
        if (root == null){
            return;
        }
        res.add(root.value);
        if (root.left == null || root.right == null){
            printEdge2(root.left == null ? root.right : root.left,res);
        }else{
            printLeftEdge(root.left,res,true);
            printRightEdge(root.right,res,true);
        }
        System.out.println();
    }

    private static void printRightEdge(TreeNode root, LinkedList<Integer> res, boolean print) {
        if (root == null){
            return;
        }
        printRightEdge(root.left,res,print&&root.right == null ? true : false);
        printRightEdge(root.right,res,print);
        if (print || (root.left == null && root.right == null)){
            res.add(root.value);
        }
    }

    private static void printLeftEdge(TreeNode root, LinkedList<Integer> res, boolean print) {
        if (root == null){
            return;
        }
        if (print || (root.left == null && root.right == null)){
            res.add(root.value);
        }
        printLeftEdge(root.left,res,print);
        printLeftEdge(root.right,res,print&&root.left == null?true:false);
}

}
