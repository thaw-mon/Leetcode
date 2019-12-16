package July.day08;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：89. 格雷编码
 * @题目描述： 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * @Date: 19/7/10
 * @示例 1: 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * @示例 2: 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 *      给定编码总位数为 n 的格雷编码序列，其长度为 2^n。当 n = 0 时，长度为 2^0 = 1。
 *      因此，当 n = 0 时，其格雷编码序列为 [0]。
 **/

public class GrayCode {
    public static void main(String[] args) {
        new GrayCode().grayCode(3);
    }

    //格雷码的原理即最高位保留，其它位是当前位和它的高一位进行异或操作。
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++){
            gray.add(i ^ i >> 1);
        }
        return gray;
    }

    //递归思路
//     作者：windliang
//        链接：https://leetcode-cn.com/problems/two-sum/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--12/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<Integer> grayCode2(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        gray.add(0); //初始化 n = 0 的解
        for (int i = 0; i < n; i++) {
            int add = 1 << i; //要加的数
            //倒序遍历，并且加上一个值添加到结果中
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }
}
