package 程序员代码面试指南.a_util;

import 程序员代码面试指南.a_nodeClass.DoubleNode;
import 程序员代码面试指南.a_nodeClass.Node;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-22 08:42
 **/
public class ListUtil {

    public static Node arrayToList(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static Node arrayToCircularList(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }
        cur.next = head;
        return head;
    }

    public static DoubleNode arrayToDoubleList(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        DoubleNode head = new DoubleNode(arr[0]);
        DoubleNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoubleNode node = new DoubleNode(arr[i]);
            cur.next = node;
            node.last = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void printList(Node head){
        while (head != null){
            System.out.print(head.value + "->");
            head = head.next;
            if (head == null){
                System.out.println("null");
            }
        }
    }

    public static void printDoubleList(DoubleNode head){
        System.out.print("from head to tail:");
        DoubleNode lastHead = null;
        while (head != null){
            System.out.print(head.value + "->");
            if (head.next == null){
                System.out.println("null");
                lastHead = head;
            }
            head = head.next;
        }
        System.out.print("from tail to head:");
        while (lastHead != null){
            System.out.print(lastHead.value + "->");
            if (lastHead.last == null){
                System.out.println("null");
            }
            lastHead = lastHead.last;
        }
    }
}
