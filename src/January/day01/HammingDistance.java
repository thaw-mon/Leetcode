package January.day01;


/**
 * @题目 ：461. Hamming Distance
 * @Data 20/01/02
 * @题目描述： The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/hamming-distance
 * @示例1: ######
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 *
 * @示例2: ######
 * @示例3: ###
 */


public class HammingDistance {
    //求二进制位不同位的位数（异或操作）可以直接使用库函数bitCount
    public int hammingDistance(int x, int y) {
        int res = 0;
        int temp = x ^ y;
        for(int i=0;i<32;i++){
            res += temp & 0x1; //判断最后一位是否为1
            temp >>= 1; //每次右移一位
        }
        return res;
    }
    //另一种有趣的思路：取余
//    作者：24shi-01fen-_00_01
//    链接：https://leetcode-cn.com/problems/hamming-distance/solution/liang-chong-fang-fa-qu-yu-yi-huo-by-24shi-01fen-_0/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int hammingDistance2(int x, int y) {
        int count=0;
        while(x>0||y>0){
            if(x%2!=y%2) count++;
            x /= 2;
            y /= 2;
        }
        return count;
    }


}
