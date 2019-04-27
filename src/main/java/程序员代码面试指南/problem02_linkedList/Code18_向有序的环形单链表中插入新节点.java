package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-26 10:11
 **/
public class Code18_向有序的环形单链表中插入新节点 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;

        Node head = insertNum(node1,6);
        Node cur = head;
        while (cur.next != head){
            System.out.print(cur.value + "->");
            cur =cur.next;
        }
        System.out.println(cur.value);
    }

    public static Node insertNum(Node head,int num){
        Node newNode = new Node(num);
        if (head == null){
            newNode.next = newNode;
            return newNode;
        }
        Node cur = head;
        if (num <= head.value){
            while (cur.next != head){
                cur = cur.next;
            }
            cur.next = newNode;
            newNode.next = head;
            return newNode;
        }
        cur = cur.next;
        Node pre = head;
        while (cur.value < num && cur != head){
            pre = cur;
            cur = cur.next;
        }
        newNode.next = cur;
        pre.next = newNode;
        return head;
    }

}
