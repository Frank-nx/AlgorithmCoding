package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-29 09:37
 **/
public class Code04_二叉树的序列化和反序列化 {

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

        TreeUtil.preOrder(root);
        String res = serialByPre(root);
        TreeNode newRoot = deserialByPre(res);
        TreeUtil.preOrder(newRoot);
    }

    public static String serialByPre(TreeNode root){
        if (root == null){
            return "#!";
        }
        String res = root.value + "!";
        res += serialByPre(root.left);
        res += serialByPre(root.right);

        return res;
    }

    public static TreeNode deserialByPre(String res){
        if (res == null || res.length() == 0){
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        String[] arr = res.split("!");
        for (int i = 0; i < arr.length; i++) {
            queue.add((arr[i]));
        }
        return buildTree(queue);
    }

    private static TreeNode buildTree(Queue<String> queue) {
        if (queue.isEmpty()){
            return null;
        }else{
            String param = queue.remove();
            if ("#".equals(param)){
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(param));
            root.left = buildTree(queue);
            root.right = buildTree(queue);
            return root;
        }
    }

}
