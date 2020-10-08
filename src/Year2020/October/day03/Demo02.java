package Year2020.October.day03;

public class Demo02 {
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     *
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        //1.暴力遍历法
        for (int i = 0; i < n; i++) {
            B[i] = 1;
            for (int j = 0; j < i; j++) {
                B[i] *= A[j];
            }
            for (int j = i + 1; j < n; j++) {
                B[i] *= A[j];
            }
        }
        return B;
    }

    //add 优化思路 B[i] = left[i] * right[i]
    public int[] multiply2(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        //首先使用B[i]代替left[i]
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                B[i] = 1;
                continue;
            }
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1; //使用temp代替right
        for (int i = n - 1; i >= 0; i--) {
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }
}
