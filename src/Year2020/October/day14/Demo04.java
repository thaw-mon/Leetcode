package Year2020.October.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo04 {


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Demo04 demo04 = new Demo04();
        while (scanner.hasNext()) {
            String ip = scanner.next();
            long num = scanner.nextLong();
            System.out.println(demo04.convertIPToNum(ip));
            System.out.println(demo04.numberCovertToIp(num));
        }
    }

    /**
     * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，
     * 然后把这个二进制数转变成一个长整数
     */
    public long convertIPToNum(String ip) {
        String[] arr = ip.split("\\.");
        long ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret *= 256;
            ret += Integer.parseInt(arr[i]);
        }
        return ret;
    }

    public String numberCovertToIp(long num) {
        long[] ip = new long[4];
        for (int i = 0; i < 4; i++) {
            long temp =  num % 256;
            num >>>= 8;
            ip[i] = temp;
        }
        //把IP转换为String
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            sb.append(ip[i]).append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
