package Year2020.November.day10;

import java.util.Scanner;

public class Demo03 {
    /**
     * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
     * 一、密码长度:
     * <p>
     * 5 分: 小于等于4 个字符
     * 10 分: 5 到7 字符
     * 25 分: 大于等于8 个字符
     * <p>
     * 二、字母:
     * <p>
     * 0 分: 没有字母
     * 10 分: 全都是小（大）写字母
     * 20 分: 大小写混合字母
     * <p>
     * 三、数字:
     * <p>
     * 0 分: 没有数字
     * 10 分: 1 个数字
     * 20 分: 大于1 个数字
     * <p>
     * 四、符号:
     * <p>
     * 0 分: 没有符号
     * 10 分: 1 个符号
     * 25 分: 大于1 个符号
     * <p>
     * 五、奖励:
     * <p>
     * 2 分: 字母和数字
     * 3 分: 字母、数字和符号
     * 5 分: 大小写字母、数字和符号
     * 最后的评分标准:
     * <p>
     * >= 90: 非常安全
     * >= 80: 安全（Secure）
     * >= 70: 非常强
     * >= 60: 强（Strong）
     * >= 50: 一般（Average）
     * >= 25: 弱（Weak）
     * >= 0:  非常弱
     * VERY_SECURE
     * SECURE,
     * VERY_STRONG,
     * STRONG,
     * AVERAGE,
     * WEAK,
     * VERY_WEAK,
     */
    public static int getPasswordScore(String str) {
        char[] arr = str.toCharArray();
        int N = arr.length;
        int score = 0;
        //1.长度判断
        if (N <= 4) score += 5;
        else if (N <= 7) score += 10;
        else score += 25;
        //2.符号判断
        int[] wordType = new int[2];
        int numCount = 0;
        int symbolCount = 0;
        for (char c : arr) {
            if (c >= 'a' && c <= 'z') wordType[0]++;
            else if (c >= 'A' && c <= 'Z') wordType[1]++;
            else if (c >= '0' && c <= '9') numCount++;
            else symbolCount++;
        }
        //2-1 字母判断
        for (int word : wordType) {
            if (word > 0) score += 10;
        }
        //2-2 数字判断
        if (numCount == 1) score += 10;
        else if (numCount > 1) score += 20;
        //2-3 符号判断
        if (symbolCount == 1) score += 10;
        else if (symbolCount > 1) score += 25;
        //3.奖励类型
        if ((wordType[0] > 0 || wordType[1] > 0) && numCount > 0) {
            score += 2; //字母和数字
            if (symbolCount > 0) {
                score += 1; //字母、数字和符号
                if (wordType[0] > 0 && wordType[1] > 0) {
                    score += 2;    //大小写字母、数字和符号
                }
            }
        }
        return score;
    }

    public static void print(int score) {
        if (score >= 90) System.out.println("VERY_SECURE");
        else if (score >= 80) System.out.println("SECURE");
        else if (score >= 70) System.out.println("VERY_STRONG");
        else if (score >= 60) System.out.println("STRONG");
        else if (score >= 50) System.out.println("AVERAGE");
        else if (score >= 25) System.out.println("WEAK");
        else System.out.println("VERY_WEAK");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            int score = getPasswordScore(s);
            print(score);
        }
        scanner.close();
    }
}
