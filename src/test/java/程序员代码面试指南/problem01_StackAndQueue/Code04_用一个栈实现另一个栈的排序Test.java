package 程序员代码面试指南.problem01_StackAndQueue;

import org.junit.Test;
import util.StackUtil;

import java.util.Stack;

import static org.junit.Assert.*;

public class Code04_用一个栈实现另一个栈的排序Test {

    Code04_用一个栈实现另一个栈的排序 code04 = new Code04_用一个栈实现另一个栈的排序();

    @Test
    public void sortStackByStack() {
        int[] arr = {2,4,3,1,5};
        Stack<Integer> stack = StackUtil.arrToStack(arr);
        System.out.println(stack);
        code04.sortStackByStack(stack);
        System.out.println(stack);
    }
}