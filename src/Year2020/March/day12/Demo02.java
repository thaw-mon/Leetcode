package Year2020.March.day12;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {

    public static void main(String[] args) {
        Demo02 demo02 = new Demo02();
        System.out.println(demo02.combine(4, 2));
    }

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * @param n
     * @param k
     * @return
     */
    List<List<Integer>> combineNumber = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        //很简单的DFS
        boolean[] visited = new boolean[n];
        helper(n, k, 0,visited, new ArrayList<>());
        return combineNumber;
    }

    public void helper(int n, int k, int index, boolean[] visited, List<Integer> num) {
        if (k == 0) {
            combineNumber.add(new ArrayList<>(num));
            return;
        }
        for (int i = index; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            num.add(i + 1);
            helper(n, k - 1, i + 1, visited, num);
            num.remove(num.size() - 1);
            visited[i] = false;
        }

    }
}
