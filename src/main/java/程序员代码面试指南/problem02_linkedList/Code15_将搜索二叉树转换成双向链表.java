package 程序员代码面试指南.problem02_linkedList;

import jdk.nashorn.internal.ir.IfNode;
import 程序员代码面试指南.a_nodeClass.DoubleNode;
import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_nodeClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-25 09:58
 **/
public class Code15_将搜索二叉树转换成双向链表 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
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

        root.left = node3;
        root.right = node8;

        TreeNode head = convert2(root);
        print(head);

    }

    public static TreeNode convert(TreeNode root){
        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        inOrderTravesal(root,queue);
        TreeNode head = queue.remove();
        TreeNode pre = head;
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            temp.left = pre;
            pre.right = temp;
            pre = pre.right;
        }
        return head;
    }

    private static void inOrderTravesal(TreeNode root,Queue<TreeNode> queue){
        if (root == null){
            return;
        }
        inOrderTravesal(root.left,queue);
        queue.add(root);
        inOrderTravesal(root.right,queue);
    }

    private static void print(TreeNode head){
        if (head == null){
            System.out.println("null");
        }
        TreeNode pre = head;
        System.out.print("right:");
        while (pre.right != null){
            System.out.print(pre.value + "->");
            pre = pre.right;
        }
        System.out.println(pre.value + "->null");
        System.out.print("left:");
        while (pre != null){
            System.out.print(pre.value + "->");
            pre = pre.left;
        }
        System.out.println("null");
    }

    public static TreeNode convert2(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode pre =null;
        TreeNode max = convertCore(root,pre);
        while(max.left != null){
            max = max.left;
        }
        return max;
    }

    private static TreeNode convertCore(TreeNode root,TreeNode pre){
        if (root == null){
            return null;
        }
        if (root.left != null){
            pre = convertCore(root.left,pre);
        }
        if (pre != null){
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        if (root.right != null){
            pre = convertCore(root.right,pre);
        }
        return pre;
    }

    public static TreeNode convert3(TreeNode root){
        if (root == null){
            return null;
        }
        return process(root).min;
    }

    public static ReturnType process(TreeNode root){
        if (root == null){
            return new ReturnType(null,null);
        }
        ReturnType leftRes = process(root.left);
        ReturnType rightRes = process(root.right);
        if (leftRes.max != null){
            leftRes.max.right = root;
        }
        if (rightRes.min != null){
            rightRes.min.left = root;
        }
        root.left = leftRes.max;
        root.right = rightRes.min;
        return new ReturnType(leftRes.min == null ? root : leftRes.min,rightRes.max == null ? root :rightRes.max);
    }

    private static class ReturnType{
        TreeNode min;
        TreeNode max;
        public ReturnType(TreeNode min,TreeNode max){
            this.min = min;
            this.max = max;
        }
    }

}
