package 程序员代码面试指南.problem03_binaryTree;


import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 *            1
 *         /       \
 *        2         3
 *       /        /   \
 *      4         5     6
 *              /  \
 *             7    8
 * @author: nixuan
 * @create: 2019-05-09 09:25
 **/
public class Code19_在二叉树中找到一个节点的后续节点 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
        node5.right = node8;

        node4.parent = node2;
        node2.parent = node1;
        node7.parent = node5;
        node8.parent = node5;
        node5.parent = node3;
        node6.parent = node3;
        node3.parent = node1;

        TreeUtil.inOrder(node1);
        TreeNode[] arr = {node1,node2,node3,node4,node5,node6,node7,node8};
        for (int i = 0; i < arr.length; i++) {
            TreeUtil.printNodeValue(getNextNode(arr[i]));
        }

    }

    private static TreeNode getNextNode(TreeNode root){
        if (root == null){
            return null;
        }
        if (root.right != null){
            return getRightLeft(root.right);
        }else{
            TreeNode parent = root.parent;
            while (parent != null && parent.right == root){
                root = parent;
                parent = root.parent;
            }
            return parent;
        }
    }

    private static TreeNode getRightLeft(TreeNode root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
}
