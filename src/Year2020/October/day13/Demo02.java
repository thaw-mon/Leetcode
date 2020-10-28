package Year2020.October.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo02 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2020/October/day13/exp02_01");
        // Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            Demo02 demo02 = new Demo02();
            //System.out.println(demo02.countBest(arr, 0, new boolean[N]));
            System.out.println(demo02.match(arr));
        }

    }

    /**
     * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，
     * 现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，
     * 能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
     */
    //暴力迭代太慢了，很容易超时，基本跑不动
    public int countBest(int[] nums, int index, boolean[] visited) {
        //1.找到每个数字的全部素数伴侣
        if (index == nums.length) return 0;
        int ret = 0;
        if (visited[index]) return countBest(nums, index + 1, visited);
        for (int i = index + 1; i < nums.length; i++) {
            //1.判定 nums[index] + nums[i]是否复合条件
            if (visited[i] || !isPrimeNumber(nums[index] + nums[i])) continue;
            visited[index] = true;
            visited[i] = true;
            ret = Math.max(ret, countBest(nums, index + 1, visited) + 1);
            visited[index] = false;
            visited[i] = false;
        }
        //当前数字无法和任何数字构成素数伴侣
        if (ret == 0) ret = countBest(nums, index + 1, visited);
        return ret;
    }

    //使用匈牙利算法进行匹配
    public int match(int[] nums) {
        //1.首先把nums分为奇数和偶数
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) even.add(num);
            else odd.add(num);
        }
        if (odd.size() == 0 || even.size() == 0) return 0;
        boolean[][] graph = new boolean[odd.size()][even.size()];
        //构建图
        for (int i = 0; i < odd.size(); i++) {
            for (int j = 0; j < even.size(); j++) {
                if (isPrimeNumber(odd.get(i) + even.get(j))) graph[i][j] = true;
            }
        }
        //建立初始匹配表
        int cnt = 0;
        int[] match_record = new int[even.size()];
        for (int i = 0; i < even.size(); i++) {
            match_record[i] = -1;
        }
        for (int i = 0; i < odd.size(); i++) {
            boolean[] visited = new boolean[even.size()];
            if (isMatch(i, graph, match_record, visited)) {
                cnt++;
            }
        }
        return cnt;
    }


    private boolean isMatch(int index, boolean[][] graph, int[] match_record, boolean[] visited) {
        for (int i = 0; i < match_record.length; i++) {
            if(!visited[i] && graph[index][i]){
                visited[i] = true;
                if (match_record[i] == -1 || isMatch(match_record[i], graph, match_record, visited))//当前偶数没有匹配或能给被抛弃的奇数找到新的偶数
                {   match_record[i] = index;//找到这个奇数
                    return true;
                }
               // visited[i] = false;
            }
        }
        return false;
    }

    //n > 2
    public boolean isPrimeNumber(int n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i < n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
