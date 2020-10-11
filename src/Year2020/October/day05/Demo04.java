package Year2020.October.day05;

import java.util.ArrayList;
import java.util.List;

public class Demo04 {


    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     */

    List<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
        //对当前值进行冒泡排序
        int index = list.size() - 2;
        while (index >= 0 && list.get(index) > num) {
            list.set(index + 1, list.get(index));
            index--;
        }
        list.set(index + 1, num);
    }

    public Double GetMedian() {
        int n = list.size();
        if (n == 0) return 0.0;
        double ret = list.get(n / 2);
        if (n % 2 == 0) {
            ret += list.get(n / 2 - 1);
            ret /= 2;
        }
        return ret;
    }

    //TODO 优化策略：使用两个堆动态维护 left 为大根堆， right 为小根堆，保持二者大小差距为1以内
}
