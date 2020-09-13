package Year2020.April.day08;

import java.util.Arrays;

public class Demo03 {

    /**
     * 给定一个由 0 和 1 组成的数组 A，将数组分成 3 个非空的部分，使得所有这些部分表示相同的二进制值。
     *
     * @param A
     * @return
     */
    public int[] threeEqualParts(int[] A) {
        //TODO 方法超出内存，待优化
        int n = A.length;
        int[][] dp = new int[n][n]; //dp[i][j]表示[i,j]字符的值
        for (int k = 0; k < n; k++) { //k代表字符的间隔
            for (int i = 0; i + k < n; i++) {
                if (k == 0) dp[i][i + k] = A[i];
                else
                    dp[i][i + k] = dp[i][i + k - 1] * 2 + A[i + k];
            }

        }
        int[] ret = new int[]{-1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                if (dp[0][i] == dp[i + 1][j - 1] && dp[0][i] == dp[j][n - 1]) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }
        return ret;
    }

    //TODO 当A长度过大时无法使用int类型表示了
    public int[] threeEqualParts2(int[] A) {
        int n = A.length;
        int[] ret = {-1, -1};
        int pre = A[0], end = A[n - 1];
        int i = 0, j = n - 1;
        //1.找到左边等于最右边的i,j
        while (i + 1 < j) {
            while (i + 1 < j && pre < end) {
                i++;
                pre = (pre << 1) + A[i];
            }
            while (i + 1 < j && end < pre) {
                j--;
                end += (A[j] << (n - j - 1));
            }
            if (pre == end) {
                //计算当前[i+1,j-1]的值
                int mid = 0;
                for (int k = i + 1; k < j; k++) {
                    mid = (mid << 1) + A[k];
                }
                if (mid == pre) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                } else {
                    //选择 i+1 或者 j-1
                    //判定那个增长更小
                    int temp1 = (pre << 1) + A[i + 1];
                    int temp2 = end + (A[j - 1] << (n - j - 2));
                    if (temp1 > temp2) {
                        j--;
                        end += (A[j] << (n - j - 1));
                    } else {
                        i++;
                        pre = (pre << 1) + A[i];
                    }

                }
            }
        }
        return ret;
    }

    //在2的基础上使用字符串改进结果
    //TODO 还是超时了啊
    public int[] threeEqualParts3(int[] A) {
        int n = A.length;
        //1.把A改造成String类型
        StringBuilder str = new StringBuilder();
        for (int a : A) {
            str.append(a);
        }
        int[] ret = {-1, -1};
        int i = 0, j = n - 1;
        StringBuilder pre = new StringBuilder(), end = new StringBuilder();
        pre.append(A[i]);
        end.append(A[j]);
        while (i + 1 < j) {
            String tmp = myTrim(end);
            //TODO 优先比较长度，长度一致时在比较大小
            while (i + 1 < j && myTrim(pre).length() < tmp.length()) {
                i++;
                pre.append(A[i]);
            }
            tmp = myTrim(pre);
            while (i + 1 < j && myTrim(end).length() < tmp.length()) {
                j--;
                end.insert(0, A[j]);
            }
            //长度一致时比较大小
            if (myTrim(pre).equals(myTrim(end))) {
                String mid = str.substring(i + 1, j);
                if (myTrim(new StringBuilder(mid)).equals(myTrim(pre))) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                } else {
                    //优先增加j
                    j--;
                    end.insert(0, A[j]);
                }
            } else {
                //选择较小的str曾家长度
                if (myTrim(pre).compareTo(myTrim(end)) < 0) {
                    i++;
                    pre.append(A[i]);
                } else {
                    j--;
                    end.insert(0, A[j]);
                }
            }
        }
        return ret;
    }

    /**
     * 去除字符串s的前导0
     *
     * @param s
     * @return
     */
    private String myTrim(StringBuilder s) {
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                break;
            }
        }
        return s.substring(i);
    }

    /**
     *  作者：LeetCode
     *     链接：https://leetcode-cn.com/problems/three-equal-parts/solution/san-deng-fen-by-leetcode/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param A
     * @return
     */
    public int[] threeEqualParts4(int[] A) {
        int[] IMP = new int[]{-1, -1};
        int N = A.length;

        int S = 0;
        for (int x: A) S += x;
        if (S % 3 != 0) return IMP;
        int T = S / 3;
        if (T == 0)
            return new int[]{0, N - 1};

        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;
        int su = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] == 1) {
                su += 1;
                if (su == 1) i1 = i;
                if (su == T) j1 = i;
                if (su == T+1) i2 = i;
                if (su == 2*T) j2 = i;
                if (su == 2*T + 1) i3 = i;
                if (su == 3*T) j3 = i;
            }
        }

        // The array is in the form W [i1, j1] X [i2, j2] Y [i3, j3] Z
        // where [i1, j1] is a block of 1s, etc.
        int[] part1 = Arrays.copyOfRange(A, i1, j1+1);
        int[] part2 = Arrays.copyOfRange(A, i2, j2+1);
        int[] part3 = Arrays.copyOfRange(A, i3, j3+1);

        if (!Arrays.equals(part1, part2)) return IMP;
        if (!Arrays.equals(part1, part3)) return IMP;

        // x, y, z: the number of zeros after part 1, 2, 3
        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = A.length - j3 - 1;

        if (x < z || y < z) return IMP;
        return new int[]{j1+z, j2+z+1};
    }


    public static void main(String[] args) {
        int[] A = {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0};
        //int[] A1 = {1, 0, 1, 0, 1};
        System.out.println(Arrays.toString(new Demo03().threeEqualParts3(A)));
    }
}
