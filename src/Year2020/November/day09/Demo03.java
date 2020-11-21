package Year2020.November.day09;

import java.util.Scanner;

public class Demo03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            String[] nums = str.split("/");
            getAlisFraction2(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        }
        scanner.close();
    }

    /**
     * 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。
     * 如：8/11 = 1/2+1/5+1/55+1/110。
     * 注：真分数指分子小于分母的分数，分子和分母有可能gcd不为1！
     * 1/2 ==> 16 / 11 = 1
     */
    public static void getAlisFraction(int numerator, int denominator) {
        int base = 2; //分母基数
        StringBuilder sb = new StringBuilder();
        while (numerator > 1) {
            int k = denominator / (numerator * base);
            if (k < 1) { //复合条件
                numerator = numerator * base - denominator;
                denominator = base * denominator;
                if (sb.length() == 0) {
                    sb.append("1/");
                } else
                    sb.append("+1/");
                sb.append(base);
            } else if (k == 1) {
                //选择合适的base
                if (denominator == numerator * base) {
                    numerator = 0;
                    if (sb.length() == 0) {
                        sb.append("1/");
                    } else
                        sb.append("+1/");
                    sb.append(base);
                    break;
                }
                base++;
            } else {
                base *= k;
            }
        }
        if (numerator == 1) {
            if (sb.length() == 0) {
                sb.append("1/");
            } else
                sb.append("+1/");
            sb.append(denominator);
        }
        System.out.println(sb);
    }

    //TODO 优化解决办法

    /**
     * 设a、b为互质正整数，a<b 分数a/b 可用以下的步骤分解成若干个单位分数之和：
     * 步骤一：用b除以a，得商数q及余数r（r=b-a*q） b = a * q + r
     * 步骤二：a/b = 1/(q+1) + (a-r)/b(q+1）
     * 步骤三：对于(a-r)/b(q+1),重复一和二，直到分解完毕
     */
    public static void getAlisFraction2(int a, int b) {
        StringBuilder res = new StringBuilder();
        while (true) {
            int c = b / a + 1;
            res.append("1/");
            res.append(c);
            a = a - b % a;
            b = b * c;
            res.append("+");
            if (a == 1) {
                res.append("1/");
                res.append(b);
                break;
            } else if (a > 1 && b % a == 0) {
                res.append("1/");
                res.append(b / a);
                break;
            }
        }
        System.out.println(res.toString());
    }

    int GCD(int a, int b) {
        int tmp = 1;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
