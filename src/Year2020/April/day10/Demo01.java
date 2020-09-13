package Year2020.April.day10;

public class Demo01 {

    /**
     * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，
     * 并将其余的元素向右平移。
     *
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        //1.记录需要复写0元素的数目
        int n = arr.length, index = 0; //记录复写0后元素的位置
        int i = 0;
        for (; index < n; i++, index++) {
            if (arr[index] == 0) {
                i++;
            }
            if (i >= n - 1) {
                break;
            }
        }

        // i可能为 n(最后元素为0)  或 n-1
        if (i == n) {
            i--;  //前移一位
            arr[i--] = arr[index--];
        }
        //2.把index以后包括index元素都清零了,从后往前复写
        for (; i >= 0; i--, index--) {
            arr[i] = arr[index];
            if (arr[index] == 0) {
                i--;
                arr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 0, 0, 0, 0, 7};
        new Demo01().duplicateZeros(arr);
    }
}
