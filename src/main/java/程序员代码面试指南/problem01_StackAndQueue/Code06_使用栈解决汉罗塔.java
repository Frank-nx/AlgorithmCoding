package 程序员代码面试指南.problem01_StackAndQueue;

import sun.nio.cs.ext.MS874;

import java.util.Map;
import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-19 14:49
 **/
public class Code06_使用栈解决汉罗塔 {

    private enum Action{
        No,LToM,MToL,RToM,MToR;
    }

    public int hanoiProblem(int n,String left,String mid,String right){
        if (n <= 0){
            return 0;
        }
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> ms = new Stack<>();
        Stack<Integer> rs = new Stack<>();
        Action[] record = {Action.No};
        for (int i = n;i>0; i--){
            ls.push(i);
        }
        int step = 0;
        while (rs.size() < n){
            step += processCore(record,Action.MToL,Action.LToM,ls,ms,left,mid);
            step += processCore(record,Action.MToR,Action.RToM,rs,ms,right,mid);
            step += processCore(record,Action.LToM,Action.MToL,ms,ls,mid,left);
            step += processCore(record,Action.RToM,Action.MToR,ms,rs,mid,right);
        }
        return step;
    }

    private int processCore(Action[] record, Action preAct, Action nowAct, Stack<Integer> fs, Stack<Integer> ts, String from, String to) {
        if (record[0] != preAct && !fs.isEmpty() && (ts.isEmpty() || fs.peek() < ts.peek())){
            ts.push(fs.pop());
            System.out.println(" move " + ts.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }
}
