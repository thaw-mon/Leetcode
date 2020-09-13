package Year2020.March.day05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo03 {

    /**
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次
     * 找到所有出现两次的元素。
     *
     * @param nums 一个整数数组
     * @return 找到所有出现两次的元素。
     */
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> ret = new ArrayList<>();
        //1.使用Set记录
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                ret.add(num);
            } else
                set.add(num);
        }
        return ret;
    }
    //思路二 ： 由于 1 ≤ a[i] ≤ n,可以使用符号进行原地hash
    public List<Integer> findDuplicates2(int[] nums) {

        List<Integer> ret = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if(nums[index] < 0){ //元素为第二次出现
                ret.add(index+1);
            }else {
                //第一次出现对应位置元素变为负数
                nums[index] = -nums[index];
            }
        }
        return ret;
    }
}
