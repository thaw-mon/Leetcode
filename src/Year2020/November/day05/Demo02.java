package Year2020.November.day05;

import java.util.Scanner;

public class Demo02 {
    /**
     * 输入两个用字符串表示的整数，求它们所表示的数之和。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String A = scanner.next();
            String B = scanner.next();
            System.out.println(add(A,B));
        }
        scanner.close();
    }

    public static String add(String A, String B) {
        int N1 = A.length() - 1, N2 = B.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (N1 >= 0 && N2 >= 0) {
            int current = (A.charAt(N1) - '0') + (B.charAt(N2) - '0') + carry;
            carry = current >= 10 ? 1 : 0;
            current %= 10;
            sb.append(current);
            N1--;
            N2--;
        }
        while (N1 >= 0) {
            int current = (A.charAt(N1) - '0') + carry;
            carry = current >= 10 ? 1 : 0;
            current %= 10;
            sb.append(current);
            N1--;
        }
        while (N2 >= 0) {
            int current = (B.charAt(N2) - '0') + carry;
            carry = current >= 10 ? 1 : 0;
            current %= 10;
            sb.append(current);
            N2--;
        }
        if (carry > 0) sb.append(carry);

        return sb.reverse().toString();
    }
}
