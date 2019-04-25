package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-25 09:22
 **/
public class Code13_删除无序单链表中值重复出现的节点 {

    public static void main(String[] args) {
        int[] arr = {1,1,3,1,3,1,2};
        Node head = ListUtil.arrayToList(arr);
        removeRep1(head);
        ListUtil.printList(head);
        ListUtil.printList(head);
    }

    public static void removeRep1(Node head){
        if (head == null || head.next == null){
            return;
        }
        Set<Integer> set = new HashSet<>();
        Node cur = head;
        set.add(cur.value);
        while (cur.next != null){
            Node next = cur.next;
            if (set.contains(next.value)){
                cur.next = cur.next.next;
                continue;
            }else{
                set.add(next.value);
            }
            cur = cur.next;
        }
    }

    public static void removeRep2(Node head){
        if (head == null || head.next == null){
            return;
        }
        Node cur = head;
        Node pre = null;
        while (cur != null){
            pre = cur;
            Node node = cur.next;
            while (node != null){
                if (node.value == cur.value){
                    pre.next = node.next;
                }else{
                    pre = pre.next;
                }
                node = node.next;
            }
        }
    }

}
