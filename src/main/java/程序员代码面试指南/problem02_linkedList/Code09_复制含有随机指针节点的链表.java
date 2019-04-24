package 程序员代码面试指南.problem02_linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-24 07:43
 **/
public class Code09_复制含有随机指针节点的链表 {

    public static void main(String[] args) {
        RandomNode node1 = new RandomNode(1);
        RandomNode node2 = new RandomNode(2);
        RandomNode node3 = new RandomNode(3);
        RandomNode node4 = new RandomNode(4);
        RandomNode node5 = new RandomNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.rand = node5;
        node3.rand = node4;

        RandomNode head1 = copyListWithRand1(node1);
        RandomNode head2 = copyListWithRand2(node1);
        head1.print(head1);
        System.out.println("=========================");
        head2.print(head2);
    }

    public static RandomNode copyListWithRand1(RandomNode head){
        if (head == null){
            return head;
        }
        Map<RandomNode,RandomNode> map = new HashMap<>();
        RandomNode cur = head;
        while (cur != null){
            map.put(cur,new RandomNode(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static RandomNode copyListWithRand2(RandomNode head){
        if (head == null){
            return head;
        }
        RandomNode cur = head;
        while (cur != null){
            RandomNode temp = new RandomNode(cur.value);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null){
            if (cur.rand != null){
                cur.next.rand = cur.rand.next;
            }
            cur = cur.next.next;
        }
        RandomNode newHead = head.next;
        RandomNode pre = head;
        RandomNode last = newHead;
        while (last.next != null){
            pre.next = last.next;
            pre = pre.next;
            last.next = pre.next;
            last = last.next;
        }
        pre.next = null;
        return newHead;
    }




    public static class RandomNode{
        public int value;
        public RandomNode next;
        public RandomNode rand;

        public RandomNode(int value){
            this.value = value;
        }

        public void print(RandomNode head){
            if (head == null){
                return;
            }
            RandomNode cur = head;
            while (cur != null){
                System.out.print(cur.value + "->");
                cur = cur.next;
            }
            System.out.println("null");
            cur = head;
            RandomNode random = null;
            while (cur != null){
                random = cur;
                while (random != null){
                    System.out.print(random.value + "->");
                    random = random.rand;
                }
                System.out.println("null");
                cur = cur.next;
            }
        }
    }
}
