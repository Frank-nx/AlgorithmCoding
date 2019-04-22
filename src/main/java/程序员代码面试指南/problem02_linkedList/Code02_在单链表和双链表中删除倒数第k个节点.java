package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.DoubleNode;
import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-22 09:06
 **/
public class Code02_在单链表和双链表中删除倒数第k个节点 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        Node head = ListUtil.arrayToList(arr);
        Node head1 =  removeLastKthNode(head,6);
        ListUtil.printList(head1);
        head = ListUtil.arrayToList(arr);
        Node head2 = removeLastKthNode(head,8);
        ListUtil.printList(head2);

        System.out.println("========================");
        int[] arr1 = {1};
        DoubleNode node1 = ListUtil.arrayToDoubleList(arr1);
        ListUtil.printDoubleList(node1);
        DoubleNode doubleHead = removeLastKthDoubleNode(node1,1);
        ListUtil.printDoubleList(doubleHead);
    }

    public static Node removeLastKthNode(Node head,int k){
        if (head == null || k < 1){
            return head;
        }
        Node cur = head;
        while(cur != null){
            k--;
            cur = cur.next;
        }
        if (k > 0){
            return head;
        }
        if (k == 0){
            return head.next;
        }
        cur = head;
        // 先加后判断
        while (++k != 0){
            cur = cur.next;
        }
        Node target = cur.next;
        cur.next = cur.next.next;
        target.next = null;
        return head;
    }

    public static DoubleNode removeLastKthDoubleNode(DoubleNode head,int k){
        if (head == null || k < 1){
            return null;
        }
        DoubleNode cur = head;
        while (cur != null){
            cur = cur.next;
            k--;
        }
        if (k == 0){
            if (head.next == null){
                return null;
            }
            cur = head.next;
            head.next = null;
            cur.last = null;
            return null;
        }
        if (k > 0){
            return head;
        }
        cur = head;
        while(++k != 0){
            cur = cur.next;
        }
        if (cur.next.next == null){
            cur.next.last = null;
            cur.next = null;
        }else{
            DoubleNode target = cur.next;
            cur.next = cur.next.next;
            cur.next.last = cur;
            target.next = null;
            target.last = null;
        }
        return head;
    }

}
