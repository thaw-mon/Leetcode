package Year2020.November.day03;

import java.util.Scanner;

public class Demo01 {

    /**
     * 输入一个字符串和一个整数k，截取字符串的前k个字符并输出
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            int k =scanner.nextInt();
            System.out.println(s.substring(0,k));
        }
        scanner.close();
    }
}
