package October.day08;

import java.util.*;

/**
 * @题目 ： 321. Create Maximum Number
 * @Data 19/10/16
 * @题目描述： TGiven two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 * <p>
 * <p>
 * 题目地址： 链接：https://leetcode-cn.com/problems/create-maximum-number
 * @示例1: ######
 * Input:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * Output:
 * [9, 8, 6, 5, 3]
 * @示例2: ######
 * Input:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * Output:
 * [6, 7, 6, 0, 4]
 * @示例3: ###
 * Input:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * Output:
 * [9, 8, 9]
 */
public class CreateMaximumNumber {
    public static void main(String[] args) {
        int[] nums1 = {8,9,7,3,5,9,1,0,8,5,3,0,9,2,7,4,8,9,8,1,0,2,0,2,7,2,3,5,4,7,4,1,4,0,1,4,2,1,3,1,5,3,9,3,9,0,1,7,0,6,1,8,5,6,6,5,0,4,7,2,9,2,2,7,6,2,9,2,3,5,7,4,7,0,1,8,3,6,6,3,0,8,5,3,0,3,7,3,0,9,8,5,1,9,5,0,7,9,6,8,5,1,9,6,5,8,2,3,7,1,0,1,4,3,4,4,2,4,0,8,4,6,5,5,7,6,9,0,8,4,6,1,6,7,2,0,1,1,8,2,6,4,0,5,5,2,6,1,6,4,7,1,7,2,2,9,8,9,1,0,5,5,9,7,7,8,8,3,3,8,9,3,7,5,3,6,1,0,1,0,9,3,7,8,4,0,3,5,8,1,0,5,7,2,8,4,9,5,6,8,1,1,8,7,3,2,3,4,8,7,9,9,7,8,5,2,2,7,1,9,1,5,5,1,3,5,9,0,5,2,9,4,2,8,7,3,9,4,7,4,8,7,5,0,9,9,7,9,3,8,0,9,5,3,0,0,3,0,4,9,0,9,1,6,0,2,0,5,2,2,6,0,0,9,6,3,4,1,2,0,8,3,6,6,9,0,2,1,6,9,2,4,9,0,8,3,9,0,5,4,5,4,6,1,2,5,2,2,1,7,3,8,1,1,6,8,8,1,8,5,6,1,3,0,1,3,5,6,5,0,6,4,2,8,6,0,3,7,9,5,5,9,8,0,4,8,6,0,8,6,6,1,6,2,7,1,0,2,2,4,0,0,0,4,6,5,5,4,0,1,5,8,3,2,0,9,7,6,2,6,9,9,9,7,1,4,6,2,8,2,5,3,4,5,2,4,4,4,7,2,2,5,3,2,8,2,2,4,9,8,0,9,8,7,6,2,6,7,5,4,7,5,1,0,5,7,8,7,7,8,9,7,0,3,7,7,4,7,2,0,4,1,1,9,1,7,5,0,5,6,6,1,0,6,9,4,2,8,0,5,1,9,8,4,0,3,1,2,4,2,1,8,9,5,9,6,5,3,1,8,9,0,9,8,3,0,9,4,1,1,6,0,5,9,0,8,3,7,8,5};
        int[] nums2 = {7,8,4,1,9,4,2,6,5,2,1,2,8,9,3,9,9,5,4,4,2,9,2,0,5,9,4,2,1,7,2,5,1,2,0,0,5,3,1,1,7,2,3,3,2,8,2,0,1,4,5,1,0,0,7,7,9,6,3,8,0,1,5,8,3,2,3,6,4,2,6,3,6,7,6,6,9,5,4,3,2,7,6,3,1,8,7,5,7,8,1,6,0,7,3,0,4,4,4,9,6,3,1,0,3,7,3,6,1,0,0,2,5,7,2,9,6,6,2,6,8,1,9,7,8,8,9,5,1,1,4,2,0,1,3,6,7,8,7,0,5,6,0,1,7,9,6,4,8,6,7,0,2,3,2,7,6,0,5,0,9,0,3,3,8,5,0,9,3,8,0,1,3,1,8,1,8,1,1,7,5,7,4,1,0,0,0,8,9,5,7,8,9,2,8,3,0,3,4,9,8,1,7,2,3,8,3,5,3,1,4,7,7,5,4,9,2,6,2,6,4,0,0,2,8,3,3,0,9,1,6,8,3,1,7,0,7,1,5,8,3,2,5,1,1,0,3,1,4,6,3,6,2,8,6,7,2,9,5,9,1,6,0,5,4,8,6,6,9,4,0,5,8,7,0,8,9,7,3,9,0,1,0,6,2,7,3,3,2,3,3,6,3,0,8,0,0,5,2,1,0,7,5,0,3,2,6,0,5,4,9,6,7,1,0,4,0,9,6,8,3,1,2,5,0,1,0,6,8,6,6,8,8,2,4,5,0,0,8,0,5,6,2,2,5,6,3,7,7,8,4,8,4,8,9,1,6,8,9,9,0,4,0,5,5,4,9,6,7,7,9,0,5,0,9,2,5,2,9,8,9,7,6,8,6,9,2,9,1,6,0,2,7,4,4,5,3,4,5,5,5,0,8,1,3,8,3,0,8,5,7,6,8,7,8,9,7,0,8,4,0,7,0,9,5,8,2,0,8,7,0,3,1,8,1,7,1,6,9,7,9,7,2,6,3,0,5,3,6,0,5,9,3,9,1,1,0,0,8,1,4,3,0,4,3,7,7,7,4,6,4,0,0,5,7,3,2,8,5,1,4,5,8,5,6,7,5,7,3,3,9,6,8,1,5,1,1,1,0,3};
        int k = 500;
        int[] ans = new CreateMaximumNumber().maxNumber2(nums1, nums2, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    //存在一个问题，当nums1 和nums2同时存在满足条件的数字i时,应该选择那个
    //nums1 = 8,9 nums2 = 3,9 k =3  max = 989  -->error ans = 939
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map1.containsKey(nums1[i])) {
                map1.put(nums1[i], new ArrayList<>());
            }
            map1.get(nums1[i]).add(i);
        }
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!map2.containsKey(nums2[i])) {
                map2.put(nums2[i], new ArrayList<>());
            }
            map2.get(nums2[i]).add(i);
        }
        int[] res = new int[k];
        int m = nums1.length, n = nums2.length;
        int index1 = -1, index2 = -1;
        //每次选择一个数字
        for (int i = 0; i < k; i++) {
            //数字从大选到小
            boolean flag = false;
            int tmpIndex1 = index1;
            int tmpIndex2 = index2;
            for (int j = 9; j >= 0; j--) {
                if (map1.containsKey(j)) {
                    for (int index : map1.get(j)) {
                        if (index > index1 && (m - index + n - index2 - 2) >= (k - i - 1)) {
                            tmpIndex1 = index;
//                            res[i] = j;
//                            map1.get(j).remove((Integer) index);
                            flag = true;
                            break;
                        }
                    }
                }
                if (map2.containsKey(j)) {
                    for (int index : map2.get(j)) {
                        if (index > index2 && (m - index1 + n - index - 2) >= (k - i - 1)) {
                            tmpIndex2 = index;
//                            res[i] = j;
//                            map2.get(j).remove((Integer) index);
                            flag = true;
                            break;
                        }
                    }
                }
                //这一轮找到了符合条件的数字
                if (flag) {
                    res[i] = j;
                    //两个map中都存在符合条件的数字
                    if (tmpIndex1 > index1 && tmpIndex2 > index2) {
                        //TODO 如何处理呢？

                    } else if (tmpIndex1 > index1) {
                        index1 = tmpIndex1;
                        map1.get(j).remove((Integer) tmpIndex1);
                    } else {
                        index2 = tmpIndex2;
                        map2.get(j).remove((Integer) tmpIndex2);
                    }
                }
            }
        }
        return res;
    }

    int[][] dp1, dp2;
    int[] res;

    //TODO 结果超时了
    public int[] maxNumber2(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        res = new int[k];
        dp1 = new int[m][m];
        dp2 = new int[n][n];
        //dp[i][j] 表示i到j的最大值的索引
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                if (j == i) {
                    dp1[i][j] = j;
                    continue;
                }
                dp1[i][j] = nums1[j] > nums1[dp1[i][j - 1]] ? j : dp1[i][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j == i) {
                    dp2[i][j] = j;
                    continue;
                }
                dp2[i][j] = nums2[j] > nums2[dp2[i][j - 1]] ? j : dp2[i][j - 1];
            }
        }

        helper(0, 0, nums1, nums2, 0, k, new int[k], true);
        return res;
    }

    private void helper(int index1, int index2, int[] nums1, int[] nums2, int index, int k, int[] tmpRes, boolean flag) {
        if (index == k) {
            for (int i = 0; i < k; i++) {
                if (tmpRes[i] < res[i])
                    break;
                else if (tmpRes[i] > res[i]) {
                    System.arraycopy(tmpRes, i, res, i, k - i);
                    //这是浅拷贝 res = tmpRes;
                    break;
                }
            }
            return;
        }
        if (!flag) return;
        int m = nums1.length, n = nums2.length;
        int l1 = m + n - index2 - (k - index);
        int l2 = m + n - index1 - (k - index);
//        int len = m - index1 + n - index2 - (k - index - 1);
        int max1 = -1;
        if (index1 < m)
            max1 = nums1[dp1[index1][Math.min(l1, m - 1)]];
        int max2 = -1;
        if (index2 < n)
            max2 = nums2[dp2[index2][Math.min(l2, n - 1)]];
        //二者数字相同的情形--需要比较下一个选择的数字
        if (max1 == max2) {
            tmpRes[index] = max1;
            if (tmpRes[index] < res[index]) {
                flag = false;
            }
            helper(dp1[index1][Math.min(l1, m - 1)] + 1, index2, nums1, nums2, index + 1, k, tmpRes, flag);
            helper(index1, dp2[index2][Math.min(l2, n - 1)] + 1, nums1, nums2, index + 1, k, tmpRes, flag);
        } else {
            tmpRes[index] = Math.max(max1, max2);
            if (tmpRes[index] < res[index]) {
                flag = false;
            }
            if (max1 > max2) {
                helper(dp1[index1][Math.min(l1, m - 1)] + 1, index2, nums1, nums2, index + 1, k, tmpRes, flag);
            } else {
                helper(index1, dp2[index2][Math.min(l2, n - 1)] + 1, nums1, nums2, index + 1, k, tmpRes, flag);
            }
        }
    }


}
