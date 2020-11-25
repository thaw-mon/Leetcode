package Year2020.November.day13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Demo04 {
    /**
     * 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
     * <p>
     * 本题有多组输入，请使用while(cin>>)处理
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = scanner.nextInt();
            int sortType = scanner.nextInt();
            sort(arr, sortType);

        }
        scanner.close();
    }

    public static void sort(int[] nums, int type) {
        Arrays.sort(nums);

        switch (type) {
            case 0: //默认升序
                for (int i = 0; i < nums.length; i++) {
                    if (i == nums.length - 1) {
                        System.out.println(nums[i]);
                    } else
                        System.out.print(nums[i] + " ");
                }
                break;
            case 1:
                for (int i = nums.length - 1; i >= 0; i--) {
                    if (i == 0) {
                        System.out.println(nums[i]);
                    } else
                        System.out.print(nums[i] + " ");
                }
                break;
        }
    }
}
