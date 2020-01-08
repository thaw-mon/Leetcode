package January.day03;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：466. Count The Repetitions
 * @Data 20/01/08
 * @题目描述： Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".
 * <p>
 * On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.
 * <p>
 * You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.
 * @题目链接： 链接：https://leetcode-cn.com/problems/count-the-repetitions
 * @示例1: ######
 * Input:
 * s1="acb", n1=4
 * s2="ab", n2=2
 * <p>
 * Return:
 * 2
 * @示例2: ######
 * @示例3: ###
 */


public class CountTheRepetitions {

    public static void main(String[] args) {
        String s1 = "phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikef", s2 = "fmznimkkasvwsrenzkycxfxtlsgypsfad";
        System.out.println(new CountTheRepetitions().getMaxRepetitions(s1, 1000000, s2, 333));
    }
    //意思就是[s1,n1]可以组成多少个[s2,n2],s1可以删除某些字母
    //考虑鸽巢原理
    //m * s1 = n * s2 ==> 找到m,n m=5 n=3  (n1= 18 n2 = 3) ==> n1 = 6 n2 = 1 ok

    //直观的一遍遍历法 ： 超时了
    //问题在于有时候找不到这样的m和n满足条件
    //注意：还要输入 n = 0的情形
    //最后优化勉强通过了
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0 || n2 == 0) return 0;

        //1.找到n1,n2的最大公约数
        int divisor = getCommonDivisor(n1, n2);
        n1 /= divisor;
        n2 /= divisor;

        int len1 = s1.length(), len2 = s2.length();
        int i = 0, j = 0;
        boolean flag = false; //增加一个标志位
        List<Integer> index = new ArrayList<>(); //表示第i个位置匹配j
        index.add(0);
        while (i < len1 * n1) {
            if (s1.charAt(i % len1) == s2.charAt(j % len2)) {
                j++;
            }
            i++;
            //m * s1 = n * s2
            if (i % len1 == 0) {
                index.add(j);  //改为每 len1计数1次
                if (j % len2 == 0) {
                    i = i / len1;
                    j = j / len2;
                    flag = true;
                    break;
                }

            }
        }
        //此时 i * s1 = j * s2;
        //1.判断n1 = k * i;
        int count = 0;
        if (flag) {
            count += n1 / i * j;
            count += index.get(n1 % i) / len2;
            count /= n2;
        } else {
            //没有找到m，n
            count = index.get(n1) / len2;
            count /= n2;
        }

        return count;
    }

    //辗转相除法：获取两个数的最大公约数
    int getCommonDivisor(int m, int n) {
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }
        int a;
        // 辗转相除法的核心就是用较大的数n去除较小的数m，如果刚好能整除，则m与n的最大公约数为m，
        // 如果不能整除，则将m的值赋给n，余数r赋给m，再进行下一次的相除，以此循环，直到整除为止
        while ((a = n % m) != 0) {
            n = m;
            m = a;
        }
        return m;
    }
}
