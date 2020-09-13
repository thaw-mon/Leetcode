package Year2020.April.day08;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    class NumArray {

        List<Integer> ret = new ArrayList<>();
        public NumArray(int[] nums) {
            ret.add(0);
            int temp = 0;
            for (int num : nums) {
                temp += num;
                ret.add(temp);
            }
        }

        public int sumRange(int i, int j) {
            return ret.get(j + 1) - ret.get(i);
        }
    }
}
