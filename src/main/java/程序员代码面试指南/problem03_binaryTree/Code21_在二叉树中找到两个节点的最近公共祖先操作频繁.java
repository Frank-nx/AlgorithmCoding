package 程序员代码面试指南.problem03_binaryTree;

import 程序员代码面试指南.a_nodeClass.TreeNode;
import 程序员代码面试指南.a_util.TreeUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-09 21:57
 **/
public class Code21_在二叉树中找到两个节点的最近公共祖先操作频繁 {

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
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node7.left = node8;

        Record record = new Record(node1);
        TreeUtil.printNodeValue(record.query(node4,node2));
        TreeUtil.printNodeValue(record.query(node5,node6));
        TreeUtil.printNodeValue(record.query(node1,node2));
    }

    public static class Record{
        Map<TreeNode,TreeNode> map = new HashMap<>();

        public Record(TreeNode head){
            if (head == null){
                return;
            }
            map.put(head,null);
            setMap(head);
        }

        private void setMap(TreeNode head){
            if (head == null){
                return;
            }
            if (head.left != null){
                map.put(head.left,head);
            }
            if (head.right != null){
                map.put(head.right,head);
            }
            setMap(head.left);
            setMap(head.right);
        }

        public TreeNode query(TreeNode node1,TreeNode node2){
            if (node1 == null || node2 == null){
                return node1 == null ? node2 :node1;
            }
            Set<TreeNode> set = new HashSet<>();
            set.add(node1);
            TreeNode temp =  map.get(node1);
            while (temp != null){
                set.add(temp);
                temp = map.get(temp);
            }
            while (!set.contains(node2)){
                node2 = map.get(node2);
            }
            return node2;
        }
    }

}
