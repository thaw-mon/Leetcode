package Year2020.November.day07;

import java.util.Scanner;

public class Demo05 {
    /**
     * 根据输入的日期，计算是这一年的第几天。。
     * 测试用例有多组，注意循环输入
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            System.out.println(countDate(year, month, day));
        }
        sc.close();
    }

    public static int countDate(int year, int month, int day) {

        //1.判断当年是否是闰年
        boolean flag = false;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            flag = true;
        }
        //2.对月份计数
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (flag) days[2]++;
        if (year <= 0 || month <= 0 || month > 12 || day <= 0 || day > days[month])
            return -1;

        int ret = day;
        for (int i = 0; i < month; i++) {
            ret += days[i];
        }
        return ret;
    }
}
