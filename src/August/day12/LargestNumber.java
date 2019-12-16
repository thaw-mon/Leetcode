package August.day12;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @题目 ：179. Largest Number
 * @Data 19/8/20
 * @题目描述： Given a list of non negative integers, arrange them such that they form the largest number.
 * @题目地址： 链接：https://leetcode-cn.com/problems/largest-number/
 * @Note: The result may be very large, so you need to return a string instead of an integer.
 * @示例1: ######
 * Input: [10,2]
 * Output: "210"
 * @示例2: ###
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * @示例3: ###
 */

public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        new LargestNumber().largestNumber(nums);
    }

    //注意 [0,0]输入情形
    //[824,938,1399,5607,6973,5703,9609,4398,8247]
//    9609 938  8247  824  6973  5703 5607  4398  1399

    //    [216,1548,2281,1090,1380,1147,1495,2000,2697,1763,1143,1417,2313,1048,282,2970,192,273,2060,2,2362,2465,213,2362,2745,1518]
    public String largestNumber(int[] nums) {

        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        Collections.sort(strList, new Comparator<String>() {
            //重新降序排序
            @Override
            public int compare(String o1, String o2) {
                int leftLen = o1.length();
                int rightLen = o2.length();
                int len = Math.min(leftLen, rightLen);
                for (int i = 0; i < len; i++) {
                    if (o1.charAt(i) > o2.charAt(i))
                        return -1;
                    else if (o1.charAt(i) < o2.charAt(i))
                        return 1;
                }
                //注意特殊情形  2  2281   and 12  121


                if (leftLen > rightLen) {
                    String s1 = o1.substring(len) + o2;
                    for(int i=0;i<s1.length();i++){
                        if(s1.charAt(i) > o1.charAt(i))
                            return -1;
                        else if(s1.charAt(i) < o1.charAt(i))
                            return 1;
                    }
                } else if (leftLen < rightLen) {
                    String s2 = o2.substring(len) + o1;
                    for(int i=0;i<s2.length();i++){
                        if(o2.charAt(i) > s2.charAt(i))
                            return -1;
                        else if(o2.charAt(i) < s2.charAt(i))
                            return 1;
                    }
                }
                return 1;
            }
        });
        String res = String.join("", strList);
        if (res.charAt(0) == '0' && res.charAt(res.length() - 1) == '0')
            res = "0";
        return res;
    }

    // 作者：LeetCode
    //    链接：https://leetcode-cn.com/problems/largest-number/solution/zui-da-shu-by-leetcode/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //重新compare方法
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber2(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }


}
