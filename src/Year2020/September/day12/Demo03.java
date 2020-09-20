package Year2020.September.day12;

public class Demo03 {

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
     * 如果不存在则输出0。
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return 0;
        //两轮循环
        int candidate = array[0];
        int count = 0;
        for (int num : array) {
            if (candidate == num) count++;
            else {
                count--;
                if (count < 0) {
                    candidate = num;
                    count = 1;
                }
            }
        }
        //判定当前候选集是否满足添加
        count = 0;
        for (int num : array) {
            if (candidate == num) count++;
        }
        if (2 * count > array.length) {
            return candidate;
        } else
            return 0;
    }
}
