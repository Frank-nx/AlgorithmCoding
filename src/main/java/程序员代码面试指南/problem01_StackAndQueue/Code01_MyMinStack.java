package 程序员代码面试指南.problem01_StackAndQueue;

import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-18 16:04
 **/
public class Code01_MyMinStack {

    // 方法一：存入的数小于等于min的栈顶值才存，否则就不存
    private Stack<Integer> data;
    private Stack<Integer> min;

    public Code01_MyMinStack(){
        data = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int val){
        if (min.isEmpty() || min.peek() >= val){
            min.push(val);
        }
        data.push(val);
    }

    public int pop(){
        if (data.isEmpty()){
            throw new RuntimeException("the stack is empty!");
        }
        int val = data.pop();
        if (val == min.peek()){
            min.pop();
        }
        return val;
    }

    public int top(){
        if (data.isEmpty()){
            throw new RuntimeException("the stack is empty!");
        }
        return data.peek();
    }

    public int getMin(){
        if (data.isEmpty()){
            throw new RuntimeException("the stack is empty!");
        }
        return min.peek();
    }

    // 方法二： 存入的数小于等于min的栈顶值才存，否则就将min的栈顶值再存一次
    private static class Code01_MyMinStack1{
        private Stack<Integer> data;
        private Stack<Integer> min;

        public Code01_MyMinStack1(){
            data = new Stack<Integer>();
            min = new Stack<Integer>();
        }

        public void push(int val){
            if (min.isEmpty() || min.peek() >= val){
                min.push(val);
            }else{
                min.push(min.peek());
            }
            data.push(val);
        }

        public int pop(){
            if (data.isEmpty()){
                throw new RuntimeException("the stack is empty!");
            }
            min.pop();
            return data.pop();
        }

        public int top(){
            if (data.isEmpty()){
                throw new RuntimeException("the stack is empty!");
            }
            return data.peek();
        }

        public int getMin(){
            if (data.isEmpty()){
                throw new RuntimeException("the stack is empty!");
            }
            return min.peek();
        }
    }
}
