package 程序员代码面试指南.problem01_StackAndQueue;

import org.junit.Test;

import static org.junit.Assert.*;

public class Code05_递归解决汉罗塔Test {

    Code05_递归解决汉罗塔 code05 = new Code05_递归解决汉罗塔();

    @Test
    public void hanoiProblemRec() {
        int steps = code05.hanoiProblemRec(2,"left","mid","right");
        System.out.println(steps);
    }
}