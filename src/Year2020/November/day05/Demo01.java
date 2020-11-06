package Year2020.November.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Demo01 {

    //根据时间比较通过算法2远优于算法1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo01 demo01 = new Demo01();
        //System.out.println(demo01.getNumFactor(2096128));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long start1 = System.currentTimeMillis();
            System.out.println(demo01.countPerfectNum(n));
            long end1 = System.currentTimeMillis();
            long start2 = System.currentTimeMillis();
            System.out.println(demo01.countPerfectNum2(n));
            long end2 = System.currentTimeMillis();
            System.out.println("time1 = " + (end1 - start1) + " time2 = " + (end2 - start2));
        }
    }

    /**
     * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
     * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
     * 输入n，请输出n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
     */

    public int countPerfectNum(int n) {
        //通过分析发现Perfect Number一定是偶数
        int count = 0;
        for (int i = 2; i <= n; i += 2) {
            if (getNumFactor(i) == i) {
                //System.out.println(i);
                count++;
            }
        }
        return count;
    }

    //2 3 ==> 3*2 = 6为完全数
    //3 7 ==> 7* 4 = 28
    //7
    //利用欧拉的公式：如果i是质数，2^i-1也是质数，那么(2^i-1)*2^(i-1)就是完全数
    public int countPerfectNum2(int n) {
        List<Integer> perfectNum = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            int k = (int) (Math.pow(2, i) - 1) * (int) (Math.pow(2, i - 1));
            if (k > n) break;
            if (!isPrimary(i) || !isPrimary((int) (Math.pow(2, i) - 1))) {
                continue;
            }
            //根据i计算完全数
            perfectNum.add(k);
        }
        return perfectNum.size();
    }

    private int getNumFactor(int n) {
        int ret = 1;
        //优化策略，可以对N开根号
        int k = (int) Math.sqrt(n);
        for (int i = 2; i <= k; i++) {
            if (n % i == 0) {
                ret += i;
                ret += n / i;
            }
        }
        return ret;
    }

    private boolean isPrimary(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
