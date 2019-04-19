package 程序员代码面试指南.problem01_StackAndQueue;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-04-19 10:33
 **/
public class Code05_递归解决汉罗塔 {

    public int hanoiProblemRec(int n,String left,String mid,String right){
        if (n <= 0){
            return 0;
        }
        return processCore(n,left,mid,right,left,right);
    }

    private int processCore(int n, String left, String mid, String right, String from, String to) {
        if (n == 1){
            if (from.equals(mid) || to.equals(mid)){
                System.out.println("move 1 from " + from + " to " + to);
                return 1;
            }else{
                System.out.println("move 1 from " + from + " to " + mid);
                System.out.println("move 1 from " + mid + " to " + to);
                return 2;
            }
        }else{
            if ((from.equals(left) && to.equals(mid)) || (from.equals(mid)) && to.equals(left)){
                int part1 = processCore(n-1,left,mid,right,from,right);
                System.out.println("move " + n + " from " + from + " to " + to);
                int part2 = processCore(n-1,left,mid,right,right,to);
                return part1 + part2 + 1;
            }else if ((from.equals(right) && to.equals(mid)) || (from.equals(mid) && to.equals(right))){
                int part1 = processCore(n-1,left,mid,right,from,left);
                System.out.println("move " + n + " from " + from + " to " + to);
                int part2 = processCore(n-1,left,mid,right,left,to);
                return part1 + part2 + 1;
            }else{
                int part1 = processCore(n,left,mid,right,from,mid);
                int part2 = processCore(n-1,left,mid,right,mid,from);
                System.out.println("move " + n + " from " + mid + " to " + to);
                int part3 = processCore(n-1,left,mid,right,from,to);
                return part1 + part2 + part3 + 1;
            }
        }
    }
}
