package Year2020.July.day04;

import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }*/
        int n = 6, m = 2;
        int[] arr = {1, 2, 1, 2, 3, 3};
        //当m==1相当于全排列了
        if (m == 1) {
            //1.n求和
            int current = 0;
            for (int i = 1; i <= n; i++) {
                current += i;
            }
            System.out.println(current);
            return;
        }
        Map<Integer, Integer> countMap = new HashMap<>(); //重复数字计数
        //如何判断重复数字到达了m的临界？
        List<Integer> fitNumber = new ArrayList<>();
        int index = 0; //窗口左值
        int count = 0;
        //使用滑动窗口计数
        for (int i = 0; i < n; i++) {
            if (!countMap.containsKey(arr[i])) {
                countMap.put(arr[i], 1);
            } else {
                int v = countMap.get(arr[i]);
                countMap.put(arr[i], v + 1);
                if (v + 1 >= m) {
                    //当前窗口复合条件
                    fitNumber.add(arr[i]);
                }
                while (fitNumber.size() > 0) {
                    count += n - i;
                    //削减滑动窗口直到 fitNumber size == 0;
                    int leftValue = countMap.get(arr[index]);
                    countMap.put(arr[index], leftValue - 1);
                    if (arr[index] == fitNumber.get(0)) {
                        fitNumber.remove(0);
                    }
                    index++;
                }
            }
        }

        System.out.println(count);
    }
}
