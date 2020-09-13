package Year2020.January.Test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //分别保存正负数数组
        List<String> nums1 = new ArrayList<>();
        List<String> nums2 = new ArrayList<>();
        //读取输入
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String temp =  in.next();
            if (temp.charAt(0) == '-') {
                nums2.add(temp);
            } else
                nums1.add(temp);
        }
        //先正后负
        int m1 = nums1.size(), m2 = nums2.size();
        int m = Math.min(m1, m2);
        for (int i = 0; i < m; i++) {
            if (i == m - 1 && m1 == m2) {
                System.out.print(nums1.get(i) + " ");
                System.out.println(nums2.get(i));
                continue;
            }
            System.out.print(nums1.get(i) + " ");
            System.out.print(nums2.get(i) + " ");
        }
        if (m1 > m) {
            for (int j = m; j < m1 - 1; j++)
                System.out.print(nums1.get(j) + " ");
            System.out.println(nums1.get(m1-1));
        }
        if (m2 > m) {
            for (int j = m; j < m2 - 1; j++)
                System.out.print(nums2.get(j) + " ");
            System.out.println(nums2.get(m2-1));
        }

    }
}
