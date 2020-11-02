package Year2020.November.day02;

import java.util.Scanner;

public class Demo02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo02 demo02 = new Demo02();
        while (scanner.hasNext()) {
            long num = scanner.nextLong();
            System.out.println(demo02.parse(num));
        }
    }

    /**
     * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
     * 如22：twenty two，123：one hundred and twenty three。
     * 说明：
     * <p>
     * 数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
     * <p>
     * 输出格式为twenty two；
     * <p>
     * 非法数据请返回“error”；
     * <p>
     * 关键字提示：and，billion，million，thousand，hundred。
     */

    public static String[] num1 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static String[] num2 = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static String[] num3 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    public static String[] num4 = {"hundred", "thousand", "million", "billion"};

    public String parse(long num) {
        if (num < 0) {
            return "error";
        }
        StringBuilder sb = new StringBuilder();
        long billion = num / 1000000000;    //十亿部分
        if (billion != 0) {
            sb.append(trans(billion)).append(" billion ");
        }
        num %= 1000000000;

        long million = num / 1000000;    //百万部分
        if (million != 0) {
            sb.append(trans(million)).append(" million ");
        }
        num %= 1000000;

        long thousand = num / 1000;    //千部分
        if (thousand != 0) {
            sb.append(trans(thousand)).append(" thousand ");
        }
        num %= 1000;

        if (num != 0) {
            sb.append(trans(num));
        }
        return sb.toString().trim();   //最后去除字符串后面的空格
    }

    public String trans(long num) {
        StringBuilder sb = new StringBuilder();
        long h = num / 100;  //百位处理
        if (h != 0) {
            sb.append(num1[(int) h]).append(" hundred");
        }
        num %= 100;

        long k = num / 10;    //十位处理
        if (k != 0) {
            if (h != 0) {    //若有百位，则加上“and”
                sb.append(" and ");
            }
            if (k == 1) {   //如果十位为1，那么十位与个位一起翻译，如：113
                sb.append(num2[(int) (num % 10)]);
            } else {  //否则，十位和个位分别单独翻译，如：123
                sb.append(num3[(int) (k - 2)]).append(" ");
                if (num % 10 != 0) {
                    sb.append(num1[(int) (num % 10)]);
                }
            }
        } else if (num % 10 != 0) {  //如果没有十位的部分，则直接翻译个位部分，比如：102
            if (h != 0) {
                sb.append(" and ");
            }
            sb.append(num1[(int) (num % 10)]);
        }
        return sb.toString().trim();
    }
}
