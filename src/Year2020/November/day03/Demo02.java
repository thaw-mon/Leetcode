package Year2020.November.day03;

import java.util.Scanner;

public class Demo02 {

    /**
     * 信号测量的结果包括测量编号和测量值。存在信号测量结果丢弃及测量结果重复的情况。
     * 1.测量编号不连续的情况，认为是测量结果丢弃。
     * 对应测量结果丢弃的情况，需要进行插值操作以更准确的评估信号。
     * 采用简化的一阶插值方法,由丢失的测量结果两头的测量值算出两者中间的丢失值。
     * 2.测量编号相同，则认为测量结果重复，需要对丢弃后来出现的测量结果。
     * 输入说明
     * 1 输入两个整数m, n
     * 2 输入m个数据组
     */
    //TODO 这道题就不浪费时间了，题目都说不清楚。
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int m,n,M,A,N,B;
            m = input.nextInt();
            n = input.nextInt();
            M = input.nextInt();
            A = input.nextInt();
            System.out.println(M + " " + A);
            for(int i = 1; i < m; i++){
                N = input.nextInt();
                B = input.nextInt();
                if(N == M) continue;
                for(int j = 1; j < N - M; j++)
                    System.out.println((M + j) + " " + (A + ((B - A) / (N - M)) * j));
                System.out.println(N + " " + B);
                M = N;
                A = B;
            }
        }
    }
}
