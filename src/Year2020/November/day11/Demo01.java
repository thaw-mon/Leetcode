package Year2020.November.day11;

import java.util.Scanner;

public class Demo01 {

    /**
     * 现在IPV4下用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此不需要用正号出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
     * <p>
     * 现在需要你用程序来判断IP是否合法。
     */

    public static boolean isValidIP(String ip) {
        if (!ip.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) return false;

        String[] array = ip.split("\\.");
        for (int i = 0; i < array.length; i++) {
            int value = Integer.parseInt(array[i]);
            if (value < 0 || value > 255) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ip = scanner.next();
            System.out.println(isValidIP(ip) ? "YES" : "NO");
        }
        scanner.close();
    }
}
