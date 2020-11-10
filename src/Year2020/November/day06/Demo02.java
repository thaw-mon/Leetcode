package Year2020.November.day06;

import java.util.Scanner;

public class Demo02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            int k = scanner.nextInt();
            System.out.println(getMaxSubStr(s, k));
        }
    }

    /**
     * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
     * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
     */
    //TODO 题意和测试用例是不一致的，测试用例是子串固定长度为minLen
    public static String getMaxSubStr(String s, int minLen) {
        int maxCount = 0;
        int index = 0;
        for (int i = 0; i < minLen; i++) {
            char c = s.charAt(i);
            if (c == 'G' || c == 'C') {
                maxCount++;
            }
        }
        int currentCount = maxCount;
        for (int i = 1; i < s.length() - minLen; i++) {
            char c1 = s.charAt(i - 1);
            if (c1 == 'G' || c1 == 'C') {
                currentCount--;
            }
            char c2 = s.charAt(i + minLen - 1);
            if (c2 == 'G' || c2 == 'C') {
                currentCount++;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                index = i;
            }
        }

        return s.substring(index,index + minLen);
    }
}
