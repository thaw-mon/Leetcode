package Year2019.September.day16;

import java.util.*;

public class Contest {
    public static void main(String[] args) {
        int[] array = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(new Contest().removeDuplicates(s,k));
//        String t = "zjxss";
//        int maxCost = 19;
//        System.out.println(new Contest().equalSubstring(s, t, maxCost));

//        System.out.println(new Contest().uniqueOccurrences(array));
    }

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            int value = map.getOrDefault(item, 0);
            map.put(item, value + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            if (set.contains(value)) return false;
            set.add(value);
        }
        return true;
    }

    //"krrgw"
//"zjxss"
//19  -- 2 不是3
    //结果是要连续的子字符串，不能拆开来
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                values[i] = Math.abs(s.charAt(i) - t.charAt(i));
                continue;
            }
            values[i] = Math.abs(s.charAt(i) - t.charAt(i)) + values[i - 1];
        }
        //从小到达排序
//        Arrays.sort(values);
        int[] dp = new int[len];
        //dp[i]表示前i个value符合条件的最大长度
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i] = maxCost >= values[i] ? 1 : 0;
                continue;
            }
            //上一轮最大的长度
            int j = dp[i - 1];
            while (j <= i && values[i] - values[i - j] <= maxCost) {
                j++;
            }
            if (j == i + 1 && values[i] <= maxCost) {
                dp[i] = j;
            } else
                dp[i] = Math.max(j - 1, dp[i - 1]);
        }

        return dp[len - 1];
    }


    //删除k倍重复字符
    //暴力求解法
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
//        Map<Character,Set<Integer>> map = new HashMap<>();
        while (true) {
            int n = sb.length();
            boolean exit = false;
            for (int i = 0; i < n; i++) {
                //一轮循环结束
                if (i + k > n) break;
                boolean flag = false;
                for (int j = i; j < i+k; j++) {
                    //不符合条件
                    if (sb.charAt(i) != sb.charAt(j)) {
                        flag = true;
                        break;
                    }
                }
                //删除字符 i----i+k-1
                if (!flag) {
                    exit = true;
                    sb.delete(i, i + k);
                    n -= k;
                }
            }
            if(!exit)
                break;
        }
        return sb.toString();
    }

    //类似于九皇后问题

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        //int tail = 0，0 ，int head = 0，1
        // 右 head.x + 1 tail.x +1
        // 下，head.y+1 tail.y +1
        // 旋转1，head.x + 1 head.y - 1
        // 旋转2，head.x -1,head.y+1
        int[] move_head_x = {1,0,1,-1};
        int[] move_head_y ={0,1,-1,1};
        int[] move_tail_x = {1,0,0,0};
        int[] move_tail_y ={0,1,0,0};

        int[] head = {1,0};
//        int[] tail = {0,0}; 不需要管尾部


        return 0;
    }

    private void helper(int[][] grid){

    }
}
