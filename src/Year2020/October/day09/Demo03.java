package Year2020.October.day09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo03 {


    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        List<Long> ret = demo03.getAllPrimeFactor(input);
        for (long num : ret) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
     * 最后一个数后面也要有空格
     */
    public List<Long> getAllPrimeFactor(long num) {
        //最小质数为2
        List<Long> ret = new ArrayList<>();
        int current = 2; //当前的质数
        while (num > 1) {
            while (num % current == 0) {
                num /= current;
                ret.add((long) current);
            }
            //获取下一个质数
            current = getNextPrime(current);
        }
        return ret;
    }

    private int getNextPrime(int n) {
        n++;
        if (n <= 3) return n;
        //获取下一个候选集 6x+1 和6x-1
        while (!isPrime(n)) {
           n++;
        }
        return n;
    }

    //判定一个数字是否为质数
    private boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
