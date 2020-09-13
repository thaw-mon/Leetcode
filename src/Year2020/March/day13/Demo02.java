package Year2020.March.day13;

public class Demo02 {

    /**
     * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        //更换数组使得偶数在奇数前面
        int l = 0, r = A.length - 1;
        while (l < r) {
            //1.从右往左找第一个为偶数的数
            while (r >= 0 && A[r] % 2 == 1) {
                r--;
            }
            //2.从左往右找第一个为奇数的数字
            while (l < r && A[l] % 2 == 0) {
                l++;
            }
            //此时A[l]为奇数 A[r]为偶数
            //交换
            if (l < r) {
                int tmp = A[l];
                A[l] = A[r];
                A[r] = tmp;
                l++;
                r--;
            }
        }
        return A;
    }
}
