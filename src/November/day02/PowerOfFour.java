package November.day02;

/**
 * @题目 ： 342. Power of Four
 * @Data 19/11/09
 * @题目描述： Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/power-of-four
 * @示例1: ######
 * Input: 16
 * Output: true
 * @示例2: ######
 * Input: 5
 * Output: false
 * @示例3: ###
 */
public class PowerOfFour {
    //直接的简单粗暴方法
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        while (num > 1){
            if(num % 4==0){
                num /= 4;
                continue;
            }
            return false;
        }
        return true;
    }

    //优化方法:考虑比特位方法
    //TODO 更优方法 ： 判断是否2幂指数后 & 0X55555555 判断结果是否为本身
    public boolean isPowerOfFour2(int num) {
        //先把负数排除
        if(num < 0) return false;
        //首先是2的幂指数
        if((num & (num-1)) == 0){
            //判断0是否为偶数
            int count = 0;
            while (num > 0){
                num = num >> 1;
                count++;
            }
            return (count - 1) % 2 == 0;
        }
        return false;
    }
}
