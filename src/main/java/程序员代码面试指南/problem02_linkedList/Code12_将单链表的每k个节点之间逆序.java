package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-25 07:56
 **/
public class Code12_将单链表的每k个节点之间逆序 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] arr1 = {1,2,3,4,5};
        Node head = ListUtil.arrayToList(arr);
        Node node = reverseKthNode(head,4);
        ListUtil.printList(node);
    }

    public static Node reverseKthNode(Node head,int k){
        if (head == null || head.next == null || k < 2){
            return head;
        }
        Node pre = null;
        Node cur = head;
        Node next = null;
        Node start = head;
        int count = 0;
        while (cur != null){
            count++;
            next = cur.next;
            if (count == k){
                head = pre == null ? cur : head;
                reverseKNode(pre,start,cur,next);
                pre = start;
                start = next;
                count = 0;
            }
            cur = next;
        }
        return head;
    }

    public static void reverseKNode(Node left,Node head,Node tail,Node right){
        Node cur = head.next;
        Node pre = head;
        while (cur != right){
            Node temp = cur.next;
            cur.next = pre;
            pre =cur;
            cur = temp;
        }
        if (left != null){
            left.next = tail;
        }
        head.next = right;
    }
}
