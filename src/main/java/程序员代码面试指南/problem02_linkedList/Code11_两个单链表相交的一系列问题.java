package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;

import java.nio.file.NotDirectoryException;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-24 09:07
 **/
public class Code11_两个单链表相交的一系列问题 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.next = node4;
        node2.next = node3;
        node3.next = node6;
       // node7.next = node3;
        node4.next = node5;
        node5.next = node6;
        node6.next = node5;

        Node res = cross(node1,node2);
        if (res == null){
            System.out.println("the result is null!");
        }else{
            System.out.println("the result is " + res.value);
        }
    }


    public static Node cross(Node head1,Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Node node1 = loopEntrance(head1);
        Node node2 = loopEntrance(head2);
        if (node1 == null && node2 == null){
            return crossPointOfList(head1,head2,null,null);
        }else if (node1 != null && node2 != null){
            return bothLoop(head1,head2,node1,node2);
        }
        return null;
    }

    public static Node bothLoop(Node head1,Node head2,Node node1,Node node2){
        if (node1 == node2){
            Node cross = crossPointOfList(head1,head2,node1,node2);
            return cross == null ? node1 : cross;
        }
        Node cur = node2.next;
        while (cur != node1 && cur != node2){
            cur = cur.next;
        }
        return cur == node1 ? node1 : null;
    }


    public static Node loopEntrance(Node head){
        if (head == null || head.next == null){
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast!= null && fast.next != null && slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow != fast){
            return null;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node crossPointOfList(Node head1,Node head2,Node end1,Node end2){
        if (head1 == null || head2 == null){
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        Node list1 = head1;
        Node list2 = head2;
        while(list1 != end1){
            len1++;
            list1 = list1.next;
        }
        while (list2 != end2){
            len2++;
            list2 = list2.next;
        }
        list1 = head1;
        list2 = head2;
        while (len1 > len2){
            list1 = list1.next;
            len1--;
        }
        while (len2 > len1){
            list2 = list2.next;
            len2--;
        }
        while(list1 != end1 && list1 != list2){
            list1 = list1.next;
            list2 = list2.next;
        }
        if (list1 != end1){
            return list1;
        }
        return null;
    }
}
