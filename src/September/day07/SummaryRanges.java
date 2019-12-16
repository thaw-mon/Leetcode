package September.day07;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ： 228. Summary Ranges
 * @Data 19/9/11
 * @题目描述： Given a sorted integer array without duplicates, return the summary of its ranges.
 * @题目地址： 链接：https://leetcode-cn.com/problems/summary-ranges
 * @示例1: ######
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * @示例2: ###
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 * @示例3: ###
 */

public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new SummaryRanges().summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        StringBuilder sb = new StringBuilder();
        int start = nums[0];
        int end = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] != end) {
                if (start == end - 1) {
                    sb.append(start);
                } else {
                    sb.append(start);
                    sb.append("->");
                    sb.append(end - 1);
                }
                res.add(sb.toString());
                sb.delete(0, sb.length());
                start = nums[i];
                end = nums[i];
            }
            end++;
        }
        //最后一个序列
        if (start == end - 1) {
            sb.append(start);
        } else {
            sb.append(start);
            sb.append("->");
            sb.append(end - 1);
        }
        res.add(sb.toString());
        return res;
    }

    // 作者：LeetCode
    //    链接：https://leetcode-cn.com/problems/summary-ranges/solution/hui-zong-qu-jian-by-leetcode/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //思路一样，写的很简洁
    public List<String> summaryRanges2(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; ++j) {
            // check if j + 1 extends the range [nums[i], nums[j]]
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;
            // put the range [nums[i], nums[j]] into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        return summary;
    }

}
