package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-26 11:06
 **/
public class Code20_按照左右半区的方式重新组合单链表 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7 };
        Node head = ListUtil.arrayToList(arr);
        relocate(head);
        ListUtil.printList(head);
    }

    public static void relocate(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        Node cur = head;
        Node next = null;
        while (cur.next != slow){
            next = mid.next;
            mid.next = cur.next;
            cur.next = mid;
            cur = mid.next;
            mid = next;
        }
        cur.next = mid;
    }
}
