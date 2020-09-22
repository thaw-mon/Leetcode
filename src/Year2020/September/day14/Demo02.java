package Year2020.September.day14;

import java.util.PriorityQueue;

public class Demo02 {


    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
     * 注意要使用Long类型，因为部分大数据可能会溢出导致负数的存在
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        //显然不能使用暴力破解法
        //思路: 2 3 5 进行组合生成结果
        PriorityQueue<Long> queue = new PriorityQueue<>();
        long preNum = 0;
        queue.add(1L);
        int p = 0;
        while (p < index) {
            long temp = queue.poll();
            if (temp == preNum) continue; //重复的数字
            p++;
            preNum = temp;
            queue.add(temp * 2);
            queue.add(temp * 3);
            queue.add(temp * 5);
        }
        return (int)preNum;
    }


    public static void main(String[] args){
        Demo02 demo02 = new Demo02();
        int ret = demo02.GetUglyNumber_Solution(1500);
        System.out.println(ret);
        System.out.println(Integer.MAX_VALUE);
        //System.out.println('a' - 'A');
    }
}
