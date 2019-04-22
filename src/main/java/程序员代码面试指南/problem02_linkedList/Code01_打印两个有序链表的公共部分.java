package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-22 08:27
 **/
public class Code01_打印两个有序链表的公共部分 {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node head2 = new Node(2);
        head1.next = new Node(3);
        Node node1 = new Node(8);
        Node node2 = new Node(9);
        Node node3 = new Node(10);
        head1.next = node1;
        head1.next.next = node2;
        head1.next.next.next = node3;
        head2.next = node2;
        head2.next.next = node3;
        System.out.print("head1:");
        ListUtil.printList(head1);
        System.out.print("head2:");
        ListUtil.printList(head2);

        printCommonPart(head1,head2);
    }

    public static void printCommonPart(Node head1,Node head2){
        while (head1 != null && head2 != null){
            if (head1.value > head2.value){
                head2 = head2.next;
            }else if (head1.value == head2.value){
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }else{
                head1 = head1.next;
            }
        }
        System.out.println();
    }

    public static void printCommonPart1(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return;
        }
        int len1 = 0;
        int len2 = 0;
        Node list1 = head1;
        Node list2 = head2;
        while(list1 != null){
            len1++;
            list1 = list1.next;
        }
        while (list2 != null){
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
        while(list1 != null && list1 != list2){
            list1 = list1.next;
            list2 = list2.next;
        }
        while (list1 != null){
            System.out.println(list1.value);
            list1 = list1.next;
        }

    }

}
