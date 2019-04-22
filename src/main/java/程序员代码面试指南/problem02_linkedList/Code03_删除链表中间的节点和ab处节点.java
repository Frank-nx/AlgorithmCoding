package 程序员代码面试指南.problem02_linkedList;

import sun.nio.cs.ext.MacThai;
import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

import java.nio.file.NotDirectoryException;

/**
 * @program: AlgorithmCoding
 * @description: Code03_ 删除链表的中间节点和a/b处的节点
 * @author: nixuan
 * @create: 2019-04-22 10:10
 **/
public class Code03_删除链表中间的节点和ab处节点 {

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,7};
        Node head = ListUtil.arrayToList(arr);
        ListUtil.printList(removeMidNode(head));
        head = ListUtil.arrayToList(arr);
        ListUtil.printList(removeNodeByRatio(head,2,3));
    }

    public static Node removeMidNode(Node head){
        if (head == null || head.next == null){
            return head;
        }
        if (head.next.next == null){
            return head.next;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node target = slow.next;
        slow.next = slow.next.next;
        target.next = null;
        return head;
    }

    public static Node removeNodeByRatio(Node head,int a,int b){
        if (head == null || a==0 || b == 0 || a/b < 0 || (double)a/b > 1){
            return head;
        }
        int count = 0;
        Node cur = head;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        int target = (int)Math.ceil(a*count/b);
        System.out.println("target:" + target);
        if (target == 1){
            return head.next;
        }
        cur = head;
        while (--target != 1){
            cur = cur.next;
        }
        Node temp = cur.next;
        cur.next = cur.next.next;
        temp.next = null;
        return head;
    }

}
