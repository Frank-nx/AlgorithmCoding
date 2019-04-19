package 程序员代码面试指南.problem01_StackAndQueue;

import org.junit.Test;

import static org.junit.Assert.*;

public class Code06_使用栈解决汉罗塔Test {

    Code06_使用栈解决汉罗塔 code06 = new Code06_使用栈解决汉罗塔();
    Code05_递归解决汉罗塔 code05 = new Code05_递归解决汉罗塔();

    @Test
    public void hanoiProblem() {
        int res = code06.hanoiProblem(10,"left","mid","right");
        System.out.println(res);
    }

    @Test
    public void check(){
        int n = 10;
        for (int i = 0;i < n;i++){
            int step1 = code05.hanoiProblemRec(i,"left","mid","right");
            int step2 = code06.hanoiProblem(i,"left","mid","right");
            if (step1 != step2){
                System.out.println("error!");
            }
        }
        System.out.println("succussful");
    }
}