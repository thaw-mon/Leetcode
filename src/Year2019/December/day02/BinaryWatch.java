package Year2019.December.day02;


import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ： 401. Binary Watch
 * @Data 19/12/03
 * @题目描述： A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * <p>
 * Each LED represents a zero or one, with the least significant bit on the right.
 * For example, the above binary watch reads "3:25".
 * <p>
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 * @题目链接： 链接：https://leetcode-cn.com/problems/binary-watch
 * @示例1: ######
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * @示例2: ######
 * @示例3: ###
 */

public class BinaryWatch {

    int[] array = {1, 2, 4, 8, 16, 32};

    //实际上可以使用简单的穷举法
    //4 + 6 分别表示小时（0--11）和分钟（0--59）
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int hours = 12, minutes = 60;
        //1.先满足小时，然后是分钟(小时最多三个灯同时亮，分钟最多5个灯同时亮)
        int nNum = Math.min(3, num);
        int mNum = num - nNum;
        boolean[] visited = new boolean[7];
        for (; nNum >= 0; nNum--) {
            mNum = num - nNum;
            if (mNum > 5) break;
            List<Integer> hourStr = helper(nNum, 3, visited, 0);
            List<Integer> minuteStr = helper(mNum, 5, visited, 0);
            for (Integer hour : hourStr) {
                if(hour >= hours) continue;
                for (Integer minute : minuteStr) {
                    if(minute >= minutes) continue;
                    if (minute < 10) {
                        res.add(String.valueOf(hour) + ":0" + String.valueOf(minute));
                    } else {
                        res.add(String.valueOf(hour) + ":"+ String.valueOf(minute));
                    }
                }
            }
        }
        return res;
    }

    //获取C(n,all)的全部排列对应的数字==>从all个数字中选择n个数字 1,2,4,8,16,32
    private List<Integer> helper(int n, int all, boolean[] visited, int val) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(val);
            return res;
        }
        for (int i = all; i >= 0; i--) {
            if (!visited[i]) {
                visited[i] = true;
                List<Integer> ans = helper(n - 1, i - 1, visited, val + array[i]);
                if (!ans.isEmpty()) res.addAll(ans);
                visited[i] = false;
            }
        }
        return res;
    }
}
