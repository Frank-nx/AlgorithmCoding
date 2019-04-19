package 程序员代码面试指南.problem01_StackAndQueue;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Code07_生成窗口最大值数组Test {

    Code07_生成窗口最大值数组 code07 = new Code07_生成窗口最大值数组();

    @Test
    public void getMaxWindow() {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] res = code07.getMaxWindow(arr,3);
        System.out.println(Arrays.toString(res));
    }
}