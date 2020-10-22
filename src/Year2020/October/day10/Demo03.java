package Year2020.October.day10;

import java.util.Scanner;

public class Demo03 {

    public static void main(String[] args){
        Demo03 demo03 = new Demo03();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(demo03.getReverseStr(num));

    }

    /**
     * 输入一个整数，将这个整数以字符串的形式逆序输出
     * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
     */

    public String getReverseStr(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        return sb.reverse().toString();
      /*  if (num == 0) return "0"; //特殊情形
        while (num > 0) {
            int currentNum = num % 10;
            num /= 10;
            sb.append(currentNum);
        }*/
        //return sb.toString();

    }
}
