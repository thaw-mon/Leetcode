package June.day15;


public class NewPower {
    //暴力法：超时
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double ans = 1.0;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                ans *= x;
            }
        } else {
            for (int i = n; i < 0; i++) {
                ans = ans / x;
            }
        }
        return ans;
    }

    //    快速幂算法（递归）
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/powx-n-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow02(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }


    //    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/powx-n-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //二进制非递归算法
    public double myPow3(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }


}
