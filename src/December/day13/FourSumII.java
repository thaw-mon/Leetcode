package December.day13;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @题目 ：454. 4Sum II
 * @Data 19/12/27
 * @题目描述： Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * @题目链接： 链接：https://leetcode-cn.com/problems/4sum-ii
 * @示例1: ######
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * @示例2: ######
 * @示例3: ###
 */
public class FourSumII {

    public static void main(String[] args) {
        int[] A = {0, 1, -1};
        int[] B = {-1, 1, 0};
        int[] C = {0, 0, 1};
        int[] D = {-1, 1, 1};

        System.out.println(new FourSumII().fourSumCount2(A, B, C, D));
    }

    //求四个集合数中字和为0的数目
    //暴力map法 ：结果超时了
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> maps1 = new HashMap<>();
        Map<Integer, Integer> maps2 = new HashMap<>();
        for (int a : A) {
            if (!maps1.containsKey(a))
                maps1.put(a, 1);
            else
                maps1.put(a, maps1.get(a) + 1);
        }
        for (int b : B) {
            for (Map.Entry<Integer, Integer> entry : maps1.entrySet()) {
                if (!maps2.containsKey(b + entry.getKey()))
                    maps2.put(b + entry.getKey(), entry.getValue());
                else
                    maps2.put(b + entry.getKey(), maps2.get(b + entry.getKey()) + entry.getValue());
            }
        }
        maps1.clear();
        for (int c : C) {
            for (Map.Entry<Integer, Integer> entry : maps2.entrySet()) {
                if (!maps1.containsKey(c + entry.getKey()))
                    maps1.put(c + entry.getKey(), entry.getValue());
                else
                    maps1.put(c + entry.getKey(), maps1.get(c + entry.getKey()) + entry.getValue());
            }
        }
        maps2.clear();
        for (int d : D) {
            for (Map.Entry<Integer, Integer> entry : maps1.entrySet()) {
                if (!maps2.containsKey(d + entry.getKey()))
                    maps2.put(d + entry.getKey(), entry.getValue());
                else
                    maps2.put(d + entry.getKey(), maps2.get(d + entry.getKey()) + entry.getValue());
            }
        }
        return maps2.getOrDefault(0, 0);
    }

    //排序法
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {

        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        //1.先两两相加获得两个数组(由于全部长度一致)
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                num1.add(A[i] + B[j]);
                num2.add(C[i] + D[j]);
            }
        }
        //对数组进行排序
        num1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        num2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int res = 0;

        int j = num2.size() - 1;
        int preCount = 0;
        //可以优化为一个循环两个指针 : 采用二分法循环
        for (int i = 0; i < num1.size(); i++) {
            if (i > 0 && num1.get(i).equals(num1.get(i - 1))) {
                res += preCount;
                continue;
            }
            preCount = 0;
            for (; j >= 0; j--) {
                if (num1.get(i) + num2.get(j) == 0) {
                    preCount++;
                } else if (num1.get(i) + num2.get(j) < 0) {
                    break;
                }
            }
            res += preCount;
            if (j < 0 && preCount == 0) break;
        }
        return res;
    }
}
