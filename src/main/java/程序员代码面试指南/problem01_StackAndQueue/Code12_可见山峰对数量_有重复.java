package 程序员代码面试指南.problem01_StackAndQueue;

import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-21 09:38
 **/
public class Code12_可见山峰对数量_有重复 {

    public static void main(String[] args) {
        int[] arr = {5,3,2,5,4,3,5,4,2,4,4};
        System.out.println(getVisibleNum(arr));
    }

    public static int getVisibleNum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        Stack<Record> help = new Stack<>();
        int max = 0;
        for (int i = 0;i < arr.length;i++){
            max = arr[max] > arr[i] ? max : i;
        }
        help.push(new Record(arr[max],1));
        int index = max == arr.length - 1?0:max+1;
        int res = 0;
        while(index != max){
            while (help.peek().value < arr[index]){
                Record temp = help.pop();
                res += 2 * temp.time + c(temp.time);
            }
            if (help.peek().value == arr[index]){
                help.peek().time++;
            }else{
                help.push(new Record(arr[index],1));
            }
            index++;
            index = index == arr.length ? 0 : index;
        }
        while (!help.isEmpty()){
            Record temp = help.pop();
            if (help.size() > 1){
                res += 2 * temp.time + c(temp.time);
            }else if (help.size() == 1){
                res += help.peek().time == 1?temp.time+c(temp.time):temp.time*2+c(temp.time);
            }else{
                res += c(temp.time);
            }
        }
        return res;
    }

    private static int c(int b){
        return b == 1 ? 0 :(b-1)*b/2;
    }

    private static class Record{
        private int value;
        private int time;

        public Record(int value,int time){
            this.value =  value;
            this.time = time;
        }
    }

}
