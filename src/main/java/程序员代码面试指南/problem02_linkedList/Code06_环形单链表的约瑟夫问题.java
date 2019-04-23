package 程序员代码面试指南.problem02_linkedList;

import 程序员代码面试指南.a_nodeClass.Node;
import 程序员代码面试指南.a_util.ListUtil;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-23 08:07
 **/
public class Code06_环形单链表的约瑟夫问题 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        Node head = ListUtil.arrayToCircularList(arr);
        Node node = josephusKill(head,2);
        System.out.println(node.value);

    }

    public static Node josephusKill(Node head,int n){
        if (head == null || head.next == null || n < 1){
            return head;
        }
        Node cur = head;
        while (cur.next != head){
            cur = cur.next;
        }
        int count = 0;
        while(cur.next != cur){
            count++;
            if (count == n){
                cur.next = cur.next.next;
                count = 0;
            }else{
                cur = cur.next;
            }
        }
        return cur;
    }
}
