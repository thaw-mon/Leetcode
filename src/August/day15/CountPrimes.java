package August.day15;

/**
 * @题目 ：204. Count Primes
 * @Data 19/8/30
 * @题目描述： Count the number of prime numbers less than a non-negative number, n.
 * @题目地址： 链接：https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @示例1: ######
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * @示例2: ###
 * @示例3: ###
 */

public class CountPrimes {

    //求小于n的质数的数量
    //超时了
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }

    //     ————————————————
//    版权声明：本文为CSDN博主「Alex_Drag」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//    原文链接：https://blog.csdn.net/qq_40181007/article/details/86289833
    public int countPrimes2(int n) {
        boolean[] prime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                count++;
                //这里使用 j = i 会导致大数字溢出问题   eg n = 499979
                for (int j = i; j <= n / i; j++) {
                    if (i * j == n) continue;
                    prime[j * i] = true;
                }
            }
        }
        return count;
    }
}
