package Year2020.April.day06;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {

    /**
     * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
     * 更正式地，检查是否存在两个下标 i 和 j 满足：
     * i != j
     * 0 <= i, j < arr.length
     * arr[i] == 2 * arr[j]
     *
     * @param arr
     * @return
     */
    public boolean checkIfExist(int[] arr) {
        //思路1：使用Map存取数组
        Map<Integer, Integer> maps = new HashMap<>();
        for (int num : arr) {
            if (maps.containsKey(num * 2) || (num % 2 == 0 && maps.containsKey(num / 2))) {
                return true;
            }
            maps.put(num, 1);
        }
        return false;
    }
}
