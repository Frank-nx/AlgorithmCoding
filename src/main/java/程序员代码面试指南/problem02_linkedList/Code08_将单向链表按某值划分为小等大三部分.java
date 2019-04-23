package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-23 09:52
 **/
public class Code08_将单向链表按某值划分为小等大三部分 {

    public static void main(String[] args) {
        int[] arr = {4,6,8,3,2,7,9,4,0,5,5};
        Node head = ListUtil.arrayToList(arr);
        Node node1 = listPartition(head,0);
        ListUtil.printList(node1);
    }


    public static Node listPartition(Node head,int pivot){
        if (head == null || head.next == null){
            return head;
        }
        Node lh = null;
        Node lt = null;
        Node eh = null;
        Node et = null;
        Node mh = null;
        Node mt = null;
        Node cur = head;
        while (cur != null){
            if (pivot > cur.value){
                if (lh == null){
                    lh = cur;
                    lt = cur;
                }else{
                    lt.next = cur;
                    lt = lt.next;
                }
            }else if (pivot == cur.value){
                if (eh == null){
                    eh = cur;
                    et = cur;
                }else{
                    et.next = cur;
                    et = et.next;
                }
            }else {
                if (mh == null){
                    mh = cur;
                    mt = cur;
                }else{
                    mt.next = cur;
                    mt = mt.next;
                }
            }
            cur = cur.next;
        }
        Node newHead = lh;
        if (lt != null){
            lt.next = eh;
            if (et == null){
                lt.next = mh;
            }
        }else{
            if (et != null){
                newHead = eh;
                et.next = mh;
            }else{
                newHead = mh;
            }
        }
        if (mt != null){
            mt.next = null;
        }
        return newHead;
    }
}
