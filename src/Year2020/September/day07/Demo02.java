package Year2020.September.day07;

public class Demo02 {

    /**
     * 如果数组是单调递增或单调递减的，那么它是单调的。
     * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
     * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
     *
     * @param A
     * @return
     */
    public boolean isMonotonic(int[] A) {
        //判定是否为单调数组
        int n = A.length;
        if (n <= 2) return true;
        int monotonicType = 0; //单调类型 0 未定义 1 单调递增 -1 单调递减
        monotonicType = Integer.compare(A[1] - A[0], 0);
        for (int i = 2; i < n; i++) {
            int type = A[i] - A[i - 1];
            if (type > 0) {
                if (monotonicType < 0) {
                    return false;
                }
                if (monotonicType == 0) monotonicType = 1;
            } else if (type < 0) {
                if (monotonicType > 0)
                    return false;
                if (monotonicType == 0) monotonicType = -1;
            }
        }

        return true;
    }
}
