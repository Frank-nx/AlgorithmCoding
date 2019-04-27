package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-26 09:41
 **/
public class Code16_单链表的选择排序 {


    public static void main(String[] args) {
        int[] arr = {1,4,6,8,3,2,5};
        Node head = ListUtil.arrayToList(arr);
        ListUtil.printList(head);
        head = selectionSort(head);
        ListUtil.printList(head);
    }

    public static Node selectionSort(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node newHead = new Node(-1);
        Node newCur = newHead;
        Node cur = head;
        Node pre= null;
        Node min = null;
        while (cur != null){
            pre = null;
            min = cur;
            while (cur != null){
                Node next = cur.next;
                if (next != null && next.value < min.value){
                    min = next;
                    pre = cur;
                }
                cur = next;
            }
            if (pre == null){
                head = head.next;
            }else{
                pre.next = pre.next.next;
            }
            newCur.next = min;
            newCur = newCur.next;
            cur = head;
        }
        return newHead.next;
    }

}
