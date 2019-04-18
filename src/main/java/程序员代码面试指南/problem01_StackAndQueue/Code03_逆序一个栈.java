package 程序员代码面试指南.problem01_StackAndQueue;

import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-18 17:06
 **/
public class Code03_逆序一个栈 {

    public void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int lastVal = getLastValue(stack);
        reverseStack(stack);
        stack.push(lastVal);
    }

    private int getLastValue(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else{
            int last = getLastValue(stack);
            stack.push(result);
            return last;
        }
    }
}
