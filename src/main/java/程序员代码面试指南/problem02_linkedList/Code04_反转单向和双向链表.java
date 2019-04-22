package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.DoubleNode;
import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-22 11:05
 **/
public class Code04_反转单向和双向链表 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Node head = ListUtil.arrayToList(arr);
        ListUtil.printList(head);
        ListUtil.printList(reverseList(head));

        int[] arr1 = {1,2,3,4,5,6};
        DoubleNode head1 = ListUtil.arrayToDoubleList(arr1);
        ListUtil.printDoubleList(head1);
        ListUtil.printDoubleList(reverseDoubleList(head1));
    }

    public static Node reverseList(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node cur = head;
        while (cur != null){
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head){
        if (head == null || head.next == null){
            return head;
        }
        DoubleNode pre = null;
        DoubleNode cur = head;
        while (cur != null){
            DoubleNode temp = cur.next;
            cur.next = pre;
            cur.last = temp;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
