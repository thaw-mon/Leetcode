package Year2020.April.day01;

import java.util.HashMap;

public class Demo03 {

    /**
     * 给定一个整数数组 A，找出索引为 (i, j, k) 的三元组，使得：
     * 0 <= i < A.length
     * 0 <= j < A.length
     * 0 <= k < A.length
     * A[i] & A[j] & A[k] == 0，其中 & 表示按位与（AND）操作符。
     *
     * @param A
     * @return
     */
    public int countTriplets(int[] A) {
        //三个数按位与为0？？  0 & anyNum == 0
        //1.暴力遍历法 : 超时了
        int n = A.length;
        int res = 0;
        //判定A[k]
        for (int k = 0; k < n; k++) {
            if (A[k] == 0) {
                res += n * n;
                continue;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((A[k] & A[i] & A[j]) == 0)
                        res++;
                }
            }
        }
        return res;
    }

    //2.使用hash优化为O(n)
//     作者：KLEA
//        链接：https://leetcode-cn.com/problems/triples-with-bitwise-and-equal-to-zero/solution/an-wei-yu-wei-ling-de-san-yuan-zu-by-lenn123/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int countTriplets2(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, N = A.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = A[i] & A[j];
                map.put(temp, map.getOrDefault(temp, 0)+1);
            }
        }
        for (int key : map.keySet()) {
            // 一个优化，当key = 0时，数组中任何值与其&运算结果均为0
            if (key == 0) {
                ans += map.get(key) * N;
                continue;
            }
            for (int i = 0; i < N; i++)
                if ((A[i] & key) == 0) ans += map.get(key);
        }

        return ans;


    }
}

