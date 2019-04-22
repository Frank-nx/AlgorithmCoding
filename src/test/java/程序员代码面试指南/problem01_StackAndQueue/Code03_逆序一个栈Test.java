package 程序员代码面试指南.problem01_StackAndQueue;


import org.junit.Test;
import 程序员代码面试指南.a_util.StackUtil;

import java.util.Stack;

public class Code03_逆序一个栈Test {

    Code03_逆序一个栈 code03 = new Code03_逆序一个栈();

    @Test
    public void reverseStack() {
        int[] arr = {1,2,3,4,5};
        Stack<Integer> stack = StackUtil.arrToStack(arr);
        stack = StackUtil.reverse(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        code03.reverseStack(stack);
        System.out.println(stack);
    }
}
