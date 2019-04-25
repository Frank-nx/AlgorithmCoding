package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-25 09:42
 **/
public class Code14_在单链表中删除指定值的节点 {

    public static void main(String[] args) {
        System.out.println(removeValue(null,1));
        int[] arr = {3,4,5,6,3,7,3,2,3};
        Node head = ListUtil.arrayToList(arr);
        Node node = removeValue(head,3);
        ListUtil.printList(node);
    }

    public static Node removeValue(Node head,int value){
        Node newHead = new Node(-1);
        Node pre = newHead;
        Node cur = head;
        while (cur != null){
            if (cur.value == value){
                pre.next = cur.next;
            }else{
                pre = pre.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}
