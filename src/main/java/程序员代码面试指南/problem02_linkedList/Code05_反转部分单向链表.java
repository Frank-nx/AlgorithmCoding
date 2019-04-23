package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-22 19:09
 **/
public class Code05_反转部分单向链表 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node head = ListUtil.arrayToList(arr);
        Node newHead = reversePart(head,3,5);
        ListUtil.printList(newHead);
    }

    public static Node reversePart(Node head,int from,int to){
        Node pHead = new Node(-1);
        pHead.next = head;
        Node cur = pHead;
        int len = 0;
        Node fPre = null;
        Node tPre = null;
        while(cur != null){
            len++;
            fPre = len == from ? cur : fPre;
            tPre = len == to ? cur : tPre;
            cur = cur.next;
        }
        if (head == null || from < 1 || to > len || from >= to){
            return head;
        }
        Node reverseTail = fPre.next;
        Node reverseHead = tPre.next;
        Node pre = null;
        cur = fPre.next;
        while(pre != reverseHead){
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        fPre.next = pre;
        reverseTail.next = cur;
        return pHead.next;
    }
}
