package Year2020.July.day03;

import java.util.Arrays;

/**
 * @Title : 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
 * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 * @Date : 2020/07/13
 * @思路 ：
 */
public class Demo01 {

    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A); //从小到大排序
        boolean[] visited = new boolean[A.length];
        //00-23 : 00-59
        StringBuilder sb = new StringBuilder();
        DP(A, visited, sb);

        if (sb.length() > 0) {
            sb.insert(2, ":");
        }
        return sb.toString();
    }

    public String DP(int[] arr, boolean[] visited, StringBuilder sb) {
        if (sb.length() == 2) {
            int num = Integer.parseInt(sb.toString());
            if (num >= 24) {
                return "";
            }
        }
        if (sb.length() == 4) {
            int num = Integer.parseInt(sb.toString().substring(2));
            if (num >= 60) {
                return "";
            }
            return sb.toString();
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (visited[i]) continue;
            sb.append(arr[i]);
            visited[i] = true;
            String ret = DP(arr, visited, sb);
            if (ret.length() == 0) {
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            } else
                return ret;
        }
        return "";
    }

    public static void main(String[] args) {
        int[] A = {8, 2, 2, 6};
        Demo01 demo = new Demo01();
        System.out.println(demo.largestTimeFromDigits(A));
    }
}
