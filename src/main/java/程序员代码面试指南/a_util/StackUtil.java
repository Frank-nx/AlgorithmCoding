package 程序员代码面试指南.a_util;

import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-18 18:10
 **/
public class StackUtil {

    public static Stack<Integer> arrToStack(int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        for (int e:arr){
            stack.push(e);
        }
        return stack;
    }

    public static Stack<Integer> reverse(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while(!stack.isEmpty()){
            help.push(stack.pop());
        }
        return help;
    }
}
