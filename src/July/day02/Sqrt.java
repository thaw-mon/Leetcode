package July.day02;

/**
 * @题目 ：69. x 的平方根
 * @题目描述： 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * @Date:19/7/2
 * @示例 1: 输入: 4
 * 输出: 2
 * @示例 2: 输入: 8
 * 输出: 2
 **/

public class Sqrt {

    public static void main(String[] args) {
        int x = 423432;
        System.out.println(new Sqrt().mySqrt2(x));
    }

    //二分法求平方根
    public int mySqrt(int x) {
        int left = 0, rigth = x, mid;
        while (left <= rigth) {
            mid = (left + rigth) / 2;
            if (mid == 0) {
                if (x == 0) {
                    return 0;
                } else {
                    left = mid + 1;
                    continue;
                }
            }
            //直接使用mid * mid 可能会产生溢出问题
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                rigth = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return rigth;
    }

    //有趣的牛顿迭代法
    //中心思想:曲线的切线逼近
//        作者：LOAFER
//    链接：https://leetcode-cn.com/problems/two-sum/solution/niu-dun-die-dai-fa-by-loafer/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int s;

    public int mySqrt2(int x) {
        s = x;
        if (x == 0) return 0;
        return ((int) (sqrts(x)));
    }

    public double sqrts(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res);
        }
    }

}
