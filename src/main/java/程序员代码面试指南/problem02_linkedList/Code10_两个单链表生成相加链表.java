package 程序员代码面试指南.problem02_linkedList;

import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;
import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-24 08:24
 **/
public class Code10_两个单链表生成相加链表 {

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,1};
        int[] arr2 =     {3,2};
        Node head1 = ListUtil.arrayToList(arr1);
        Node head2 = ListUtil.arrayToList(arr2);
        Node node1 = addList1(head1,head2);
        Node node2 = addList2(head1,head2);
        ListUtil.printList(node1);
        ListUtil.printList(node2);
    }

    public static Node addList1(Node head1,Node head2){
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null){
            s1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null){
            s2.push(head2.value);
            head2 = head2.next;
        }
        Node node = null;
        Node pre = null;
        int base = 0;
        while (!s1.isEmpty() || !s2.isEmpty()){
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = n1 + n2 + base;
            node = new Node(sum % 10);
            node.next = pre;
            pre = node;
            base = sum / 10;
        }
        if (base == 1){
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

    public static Node addList2(Node head1,Node head2){
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        Node node1 = reverseList(head1);
        Node node2 = reverseList(head2);
        Node cur = null;
        Node pre = null;
        int base = 0;
        while (node1 != null || node2 != null){
            int n1 = node1 == null ? 0 : node1.value;
            int n2 = node2 == null ? 0 : node2.value;
            int sum = n1 + n2 + base;
            cur = new Node(sum % 10);
            cur.next = pre;
            pre = cur;
            base = sum / 10;
            node1 = node1 == null ? node1 : node1.next;
            node2 = node2 == null ? node2 : node2.next;
        }
        if (base == 1){
            cur = new Node(1);
            cur.next = pre;
        }
        return cur;
    }

    private static Node reverseList(Node head){
        Node pre = null;
        Node cur = head;
        while (cur != null){
            Node temp = cur.next;
            cur.next = pre;
            pre =cur;
            cur = temp;
        }
        return pre;
    }

}
