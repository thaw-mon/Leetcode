package Year2020.March.day07;

import java.util.*;

public class Demo03 {

    /**
     * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，
     * 我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
     * 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
     * @param A
     * @param B
     * @return
     */
    // 作者：LeetCode
    //    链接：https://leetcode-cn.com/problems/k-similar-strings/solution/xiang-si-du-wei-k-de-zi-fu-chuan-by-leetcode/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f"};
    Map<String, Integer> memo;
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        int N = A.length();
        memo = new HashMap();
        int ans = 0;

        //计数器,计数不同类型不相同字符的数目
        int[] count = new int[alphabet.length * alphabet.length];

        for (int i = 0; i < N; ++i)
            if (A.charAt(i) != B.charAt(i)) {
                count[alphabet.length * (A.charAt(i) - 'a') + (B.charAt(i) - 'a')]++;
                ans++;
            }

        List<int[]> possibles = new ArrayList();
        // Enumerate over every cycle
        for (int size = 2; size <= alphabet.length; ++size)
            search: for (String cycle: permutations(alphabet, 0, size)) {
                // Check if cycle is canonical
                for (int i = 1; i < size; ++i)
                    if (cycle.charAt(i) < cycle.charAt(0))
                        continue search;

                // Add count to possibles
                int[] row = new int[count.length];
                for (int i = 0; i < size; ++i) {
                    int u = cycle.charAt(i) - 'a';
                    int v = cycle.charAt((i+1) % size) - 'a';
                    row[alphabet.length * u + v]++;
                }
                possibles.add(row);
            }

        int[] ZERO = new int[count.length];
        memo.put(Arrays.toString(ZERO), 0);
        return ans - numCycles(possibles, count);
    }

    public int numCycles(List<int[]> possibles, int[] count) {
        String countS = Arrays.toString(count);
        if (memo.containsKey(countS)) return memo.get(countS);

        int ans = Integer.MIN_VALUE;
        search: for (int[] row: possibles) {
            int[] count2 = count.clone();
            for (int i = 0; i < row.length; ++i) {
                if (count2[i] >= row[i])
                    count2[i] -= row[i];
                else
                    continue search;
            }
            ans = Math.max(ans, 1 + numCycles(possibles, count2));
        }

        memo.put(countS, ans);
        return ans;
    }

    public List<String> permutations(String[] alphabet, int used, int size) {
        List<String> ans = new ArrayList();
        if (size == 0) {
            ans.add(new String(""));
            return ans;
        }

        for (int b = 0; b < alphabet.length; ++b)
            if (((used >> b) & 1) == 0)
                for (String rest: permutations(alphabet, used | (1 << b), size - 1))
                    ans.add(alphabet[b] + rest);
        return ans;
    }


}
