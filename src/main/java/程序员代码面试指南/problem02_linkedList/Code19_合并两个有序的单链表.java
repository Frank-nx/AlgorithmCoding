package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-26 10:33
 **/
public class Code19_合并两个有序的单链表 {

    public static void main(String[] args) {
        int[] arr1 = {0,2,3,7};
        int[] arr2 = {1,3,5,7,9};
        Node list1 = ListUtil.arrayToList(arr1);
        Node list2 = ListUtil.arrayToList(arr2);
        Node head = merge1(list1,list2);
        ListUtil.printList(head);
    }

    public static Node merge(Node list1,Node list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.value > list2.value){
            list2.next = merge(list1,list2.next);
            return list2;
        }
        list1.next = merge(list1.next,list2);
        return list1;
    }

    public static Node merge1(Node head1,Node head2){
        if (head1 == null || head2 == null){
            return head1 == null ? head2 : head1;
        }
        Node newHead = head1.value > head2.value ? head2 : head1;
        Node cur1 = newHead == head1 ? head1.next : head1;
        Node cur2 = newHead == head1 ? head2 : head2.next;
        Node cur = newHead;
        while (cur1 != null && cur2 != null){
            if (cur1.value > cur2.value){
                cur.next = cur2;
                cur2 = cur2.next;
            }else{
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur = cur.next;
        }
        cur.next = cur1 == null ? cur2 : cur1;
        return newHead;
    }

}
