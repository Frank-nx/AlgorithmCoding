package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-23 08:47
 **/
public class Code07_判断一个链表是否是回文结构 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,1};
        Node head = ListUtil.arrayToList(arr);
        System.out.println(isPalindrome1(head));
        System.out.println(isPalindrome2(head));
    }

    public static boolean isPalindrome1(Node head){
        if (head == null || head.next == null ){
            return true;
        }
        Stack<Node> help = new Stack<>();
        Node cur = head;
        while (cur != null){
            help.push(cur);
            cur = cur.next;
        }
        while (!help.isEmpty()){
            if (help.pop().value != head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node pre = slow;
        Node cur = slow.next;
        while(cur != null){
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        slow.next = null;
        Node start = pre;
        fast = head;
        boolean res = true;
        while (fast != null){
            if (start.value != fast.value){
                res = false;
                break;
            }
            start = start.next;
            fast = fast.next;
        }
        cur = pre;
        pre = null;
        while(cur != null){
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return res;
    }
}
