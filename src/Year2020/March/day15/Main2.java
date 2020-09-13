package Year2020.March.day15;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    //结果超时了
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        //1.对strs进行排序
        Arrays.sort(strs);

        int ret = 0;
        int[] dp = new int[n]; //前i段拼接的最大长度
        for (int i = 0; i < n; i++) {
            //最小直接为本身
            int len = strs[i].length();
            dp[i] = len;
            //如何提前退出循环？
            for (int j = i - 1; j >= 0; j--) {
                if(strs[j].charAt(strs[j].length()-1) <= strs[i].charAt(0)){
                    dp[i] = Math.max(dp[i],len + dp[j]);
                }
            }
            ret = Math.max(ret,dp[i]);
        }
        System.out.println(ret);
    }
}
