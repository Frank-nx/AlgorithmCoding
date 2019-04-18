package 程序员代码面试指南.problem01_StackAndQueue;

import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-18 16:40
 **/
public class Code02_两个栈组成一个队列 {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public Code02_两个栈组成一个队列(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public boolean empty(){
        return stackPush.isEmpty()&&stackPop.isEmpty();
    }

    public void push(int val){
        stackPush.push(val);
    }

    public int pop(){
        if (empty()){
            throw new RuntimeException("the queue is empty!");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if (empty()){
            throw new RuntimeException("the queue is empty!");
        }
        pushToPop();
        return stackPop.peek();
    }

    private void pushToPop(){
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }
}
