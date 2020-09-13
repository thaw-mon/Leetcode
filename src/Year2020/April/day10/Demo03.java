package Year2020.April.day10;

import java.util.Arrays;
import java.util.Comparator;

public class Demo03 {

    /**
     * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
     * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        //1.对pairs排序
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        //2.对数组进行查找
        int ret = 1;
        int[] dp = new int[pairs.length]; //dp[i]表示以pairs结尾的最大长度
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 1; //默认为1
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(1 + dp[j], dp[i]);
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
