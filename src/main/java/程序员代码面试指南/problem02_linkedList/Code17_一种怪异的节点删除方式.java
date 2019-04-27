package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-26 10:05
 **/
public class Code17_一种怪异的节点删除方式 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = ListUtil.arrayToList(arr);
        removeNodeWired(head.next);
        ListUtil.printList(head);
    }

    public static void removeNodeWired(Node node){
        if (node == null){
            return;
        }
        if (node.next == null){
            throw new RuntimeException("can not remove the last node.");
        }
        node.value = node.next.value;
        node.next = node.next.next;
    }

}
