package Year2020.October.day01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Demo03 {

    /**
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
     * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     * Attention : 一个数字不属于序列
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //连续和为sum的连续正数序列
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int begin = 1, end = 1;
        int currentSum = 1;
        while (begin <= end) {
            while (currentSum < sum) {
                end++;
                currentSum += end;
            }
            //符合条件
            if (currentSum == sum) {
                if (begin == end) {
                    currentSum -= begin;
                    begin++;
                    continue;
                }
                ArrayList<Integer> sequence = new ArrayList<>();
                for (int i = begin; i <= end; i++) {
                    sequence.add(i);
                }
                result.add(sequence);
                //序列前移
                currentSum -= begin;
                begin++;
            }
            while (currentSum > sum) {
                currentSum -= begin;
                begin++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Demo03().FindContinuousSequence(10));
    }
}
