package Year2020.March.day16;

public class Demo02 {
    /**
     * 给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。
     * （这里需要澄清的是，长为 L 的子数组可以出现在长为 M 的子数组之前或之后。）
     *
     * @param A
     * @param L
     * @param M
     * @return
     */
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int N = A.length;
        int[] sum = new int[N + Math.max(L, M)];
        //sum[0] = 0 sum[i] = A[i-1] + sum[i-1]
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        //
        int[] right = new int[N + 1];  //从右开始的[i,N-1] M子串的最大值
        // nums[N-1-M] -- nums[N-1]
        for (int i = N - M; i >= 0; i--) {
            right[i] = Math.max(sum[i + M] - sum[i], right[i + 1]);
        }
        //求最大值
        int ret = 0;
        int l, m1 = 0, m2 = 0;
        for (int i = 0; i < N; i++) {
            // L子串 nums[i] 到 nums[i+L-1];
            l = sum[i + L] - sum[i];
            //获取M子串的最大值:要和L子串不重叠
            //1.判定L左侧是否存在子串M
            if (i  < M) m1 = 0;
            else
                m1 = Math.max(m1, sum[i] - sum[i - M]); // nums[i-M-1] -- nums[i-1]
            //2.判定L右侧是否存在子串M
            if (i + L + M > N) m2 = 0;  //nums[i+L] -- nums[i+L+M-1]
            else
                m2 = right[i + L];
            if (m1 == 0 && m2 == 0) continue;
            ret = Math.max(ret, l + Math.max(m1, m2));
        }
        return ret;
    }

    public static void main(String[] args){
        int[] arr = {87,42,40,86,93,4,18,28,59,30,6,51,99,46,40,24,19,98,40,41};
        System.out.println(new Demo02().maxSumTwoNoOverlap(arr,1,10));
        //ANS = 586
    }
}
