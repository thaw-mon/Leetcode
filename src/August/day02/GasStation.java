package August.day02;

/**
 * @题目 ：134. 加油站
 * @Data: 19/8/06
 * @题目描述： 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * @题目地址： https://leetcode-cn.com/problems/gas-station/
 * @说明: ###
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * @示例1: ######
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 输出: 3
 * @示例2: ###
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * 输出: -1
 **/

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4};
        int[] tank = gas;
        tank[0] = -1;
        System.out.println(gas[0]);
        System.out.println(tank[0]);
    }

    //简单的方法就是遍历一遍，O(n^2)
    //思路简单，但特别耗时
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] tank = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (tank[j] >= 0) {
                    int r = (i + j) % n;
                    tank[j] += (gas[r] - cost[r]);
                }

        }
        int res = -1;
        for (int i = 0; i < n; i++)
            if (tank[i] >= 0)
                res = i;
        return res;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/jia-you-zhan-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //优化的O(N)写法-->关键在于一个数学原理： if(sum[i,j]<0) then assume k in [i,j] result  sum[k,j]<0
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            // If one couldn't get here,
            if (curr_tank < 0) {
                // Pick up the next station as the starting one.
                starting_station = i + 1;
                // Start with an empty tank.
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }

}
