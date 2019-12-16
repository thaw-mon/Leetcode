package June.day01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Data 19/5/29
 * @题目描述： 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @示例： 输入："abcabcbb" "bbbbbbb"  "pwwkew"
 * 输出：3  1  3
 * 原因： 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class NoReapeatSubString {
    public static void main(String[] args) {

        int ans = lengthOfLongestSubstring("abcabcbb");
        System.out.println(ans);
        ans = lengthOfLongestSubstring("bbbbbbb");
        System.out.println(ans);
        ans = lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);
    }


    public static int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int[] nums = new int[array.length]; //默认初始化0
        int k=0;
        for (int i = 0; i < array.length; i++) {
            char tmp = array[i];
            nums[i] = 1;
            for (int j = i - 1; j >= k; j--) {
                //
                if (tmp != array[j]) {
                    nums[j] += 1;
                    continue;
                }
                //结束J循环
                if(tmp==array[j]){
                    k=j+1;
                    break;
                }
            }
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = max> nums[i]?max:nums[i];
        }
        return max;
    }
    //滑动窗口思想(参考答案)
    //思想和我的差不过。不过使用set可以用 O(1) 的时间来完成对字符是否在当前的子字符串中的检查
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    //优化滑动窗口  [i,j]
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
