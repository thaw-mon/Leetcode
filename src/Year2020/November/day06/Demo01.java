package Year2020.November.day06;

import java.util.Scanner;

public class Demo01 {

    /**
     * 输入一个正整数，计算它在二进制下的1的个数。
     */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int k = scanner.nextInt();
            System.out.println(countOne(k));
        }
    }
    public static int countOne(int num) {
        int ret = 0;
        while (num > 0) {
            if ((num & 0x01) == 1) ret++;
            num >>= 1;
        }
        return ret;
    }
}
