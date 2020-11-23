package Year2020.November.day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo04 {
    /**
     * 编写一个函数，传入一个int型数组，返回该数组能否分成两组，使得两组中各元素加起来的和相等，
     * 并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），
     * 能满足以上条件，返回true；不满足时返回false。
     */
    public boolean isFitArray(int[] nums) {
        int[] dp = new int[nums.length];
        int currentVal = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] % 5 == 0) {
                currentVal += nums[i];
                dp[i] = -1; //设为不可访问
            } else if (nums[i] % 3 == 0) {
                dp[i] = -1;
            }
        }
        if (Math.abs(sum) % 2 > 0) return false;
        return DFS(nums, dp, currentVal, sum / 2);
    }

    public boolean DFS(int[] nums, int[] dp, int current, int target) {
        if (current == target) return true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 0) {
                dp[i] = 1;
                if (DFS(nums, dp, current + nums[i], target)) return true;
                dp[i] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Year2020/November/day11/exp04_01"));
        Demo04 demo04 = new Demo04();
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) nums[i] = scanner.nextInt();
            boolean answer = scanner.nextBoolean();
            assert answer == demo04.isFitArray(nums);
        }
        scanner.close();
    }
}
