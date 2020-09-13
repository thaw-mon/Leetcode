package Year2020.April.day11;

import java.util.Scanner;

public class Demo03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //表示卡牌数目
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        //判定是否可以通过操作使得数组a非递减排列
        int count = 0;
        for (int i = 1; i < n; i++) {
            //当前数字比前面大
            if (a[i] > a[i - 1]) {

            }
        }
    }

    int minCount = Integer.MAX_VALUE;

    public boolean dp(int[] a, int[] b, int index, int count) {
        if (index == a.length) {
            minCount = Math.min(minCount, count);
            return true;
        }
        //判定当前数字是否符合非递减顺序
        if (a[index] >= a[index - 1])
            return dp(a, b, index + 1, count);
        //不符合非递减情形 两种策略 和前面的交换或和后面的交换
        //1. 和前面的交换
        if (b[index] >= b[index - 1] && (index < 2 || b[index] >= a[index - 2])) {
            //交换 a[index] a[index-1]
            int tmpA = a[index];
            int tmpB = a[index];
            a[index] = b[index-1];
            b[index] = a[index-1];
            a[index-1] = tmpA;
            b[index-1] = tmpB;
            dp(a,b,index+1,count+1);
        }

        return false;
    }
}
