package Year2020.April.day05;

import java.util.*;

public class Demo02 {

    /**
     * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
     * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
     *
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        //1.把数组转换为map类型 : 优化策略 改为set类型不需要记录不同种类的糖果数目
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }

        int kind = set.size(); //全部种类数目
        kind = Math.min(kind, candies.length / 2);
        return kind;
    }
}
