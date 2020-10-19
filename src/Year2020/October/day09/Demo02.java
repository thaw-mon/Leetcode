package Year2020.October.day09;

import java.util.Scanner;

public class Demo02 {

    public static void main(String[] args){
        Demo02 demo02 = new Demo02();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            System.out.println(demo02.hexConvertToDecimal(str));
        }
    }

    /**
     * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
     */

    public int hexConvertToDecimal(String hex) {
        //return Integer.parseInt(hex,16); //直接调用系统函数写法
        int n = hex.length();
        int answer = 0;
        for (int i = 2; i < n; i++) {
            char c = hex.charAt(i);
            int value = 0;
            if (c < 'A') {
                value = c - '0';
            } else {
                value = 10 + (c - 'A');
            }
            //answer *= 16; //
            answer <<= 4;
            answer += value;
        }
        return answer;
    }

}
