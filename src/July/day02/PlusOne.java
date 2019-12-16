package July.day02;

/**
 * @题目 ：66. 加一
 * @题目描述： 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头
 * @Date:19/7/2
 * @示例 1: 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * @示例 2: 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 **/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
//        int[] res = new int[n+1];
        int carryFlag = 1;
        while (n > 0) {
            digits[n - 1] += carryFlag;
            carryFlag = 0;
            if (digits[n - 1] == 10) {
                digits[n - 1] = 0;
                carryFlag = 1;
            }
            n--;
            if (carryFlag == 0) {
                break;
            }
        }
        if(carryFlag==0){
            return digits;
        }else {
           int[] res = new int[digits.length+1];
           res[0] = 1;
           System.arraycopy(digits,0,res,1,digits.length);
           return res;
        }
    }

    //思路一样，但是大佬就是很简洁

//    作者：yhhzw
//    链接：https://leetcode-cn.com/problems/two-sum/solution/java-shu-xue-jie-ti-by-yhhzw/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
