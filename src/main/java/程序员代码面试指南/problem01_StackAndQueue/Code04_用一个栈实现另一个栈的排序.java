package 程序员代码面试指南.problem01_StackAndQueue;

import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-18 21:44
 **/
public class Code04_用一个栈实现另一个栈的排序 {

    public void sortStackByStack(Stack<Integer> stack){
        if (stack == null || stack.isEmpty()){
            return;
        }
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()){
            int top = stack.pop();
            while (!help.isEmpty() && help.peek() < top){
                stack.push(help.pop());
            }
            help.push(top);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
