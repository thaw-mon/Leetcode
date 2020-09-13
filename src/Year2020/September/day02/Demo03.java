package Year2020.September.day02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo03 {

    /**
     * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
     * 如果存在则返回 true，不存在返回 false。
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    //ERROR 超时了
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //1.遍历操作
        int n = nums.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + k && j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        return flag;
    }


    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (t < 0) return false;
        if (t == 0) return helper(nums, k);
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int left, right, len;
        for (int i = 0; i < n; i++) {

            //防止溢出问题
            left = nums[i] < (t + Integer.MIN_VALUE) ? Integer.MIN_VALUE : nums[i] - t;
            right = (Integer.MAX_VALUE - t) < nums[i] ? Integer.MAX_VALUE : nums[i] + t;

            if (isContain(new ArrayList<>(set), left, right))
                return true;
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }

    public boolean helper(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    //判断set是否存在value 在lNum - rNum之间
    private boolean isContain(List<Integer> list, int lNum, int rNum) {
        int n = list.size();
        int l = 0, r = n - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (list.get(mid) < lNum) {
                l = mid + 1;
            } else if (list.get(mid) > rNum)
                r = mid - 1;
            else
                return true;
        }
        return false;
    }
}
