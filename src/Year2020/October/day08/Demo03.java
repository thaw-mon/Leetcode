package Year2020.October.day08;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Demo03 {

    /**
     * 输入多行，先输入随机整数的个数，再输入相应个数的整数
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(scanner.nextInt());
            }
            //打印结果
            for (Integer integer : set) {
                System.out.println(integer);
            }
        }
    }
}
