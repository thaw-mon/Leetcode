package Year2020.November.day02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Demo01 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] weight = new int[n];
            int[] num = new int[n];
            for (int i = 0; i < n; i++) weight[i] = scanner.nextInt();
            for (int i = 0; i < n; i++) num[i] = scanner.nextInt();
            System.out.println(demo01.countWeight(weight, num));
        }
        scanner.close();
    }

    /**
     * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
     * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，
     * 问能称出多少种不同的重量。
     */
    public int countWeight(int[] weight, int[] num) {
        int n = weight.length;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < n; i++) {
            Iterator<Integer> iterator = set.iterator();
            Set<Integer> addNum = new HashSet<>();
            for (int j = 1; j <= num[i]; j++) {
                addNum.add(weight[i] * j);
            }

            while (iterator.hasNext()) {
                int temp = iterator.next();
                for (int j = 1; j <= num[i]; j++) {
                    addNum.add(weight[i] * j + temp);
                }
            }
            set.addAll(addNum);
        }
        return set.size();
    }
}
