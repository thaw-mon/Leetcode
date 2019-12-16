package November.day01;

/**
 * @题目 ： 336. Palindrome Pairs
 * @Data 19/11/06
 * @题目描述： Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * @题目链接： 链接：https://leetcode-cn.com/problems/counting-bits
 * @示例1: ######
 * Input: 2
 * Output: [0,1,1]
 * @示例2: ######
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * @示例3: ###
 */
public class CountingBits {
    //1.暴力法：每个数字算一遍
    //2. 感觉存在数学规律 ok 每个2的指数都为1,其余的是其最近的2的指数+num
    //3.有效位思路 ：ans[i] = ans[i & (i - 1)] + 1;
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int preNum = 0;//指向上一个2的指数指针
        for (int i = 1; i <= num; i++) {
            // i为2的指数
            if((i & (i-1)) == 0){
                res[i] = 1;
                preNum = i;
                continue;
            }
            //res[i] = res[2^k] + res[i-2^k];
            res[i] = res[preNum] + res[i-preNum];
        }
        return res;
    }
}
