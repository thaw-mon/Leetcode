package Year2020.March.day02;

import java.util.Arrays;
import java.util.List;

public class Demo02 {

    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * @param rowIndex : 输入的索引值
     * @return 杨辉三角的第 k 行。
     * TODO : 可以使用数学公式进行优化
     */
    public List<Integer> getRow(int rowIndex) {
        Integer [] array = new Integer[rowIndex + 1];
        for(int i=0;i<=rowIndex;i++){
            //最后一个数字为1
            array[i] = 1;
            for(int j = i-1;j>0;j--)
                array[j] += array[j-1];
        }
        return Arrays.asList(array);
    }
}
