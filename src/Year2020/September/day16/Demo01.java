package Year2020.September.day16;

public class Demo01 {

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     * 无脑暴力写法只能通过1半
     *
     * @param array
     * @return
     */
    public int InversePairs(int[] array) {
        int n = array.length;
        int P = 1000000007;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < n) {
                if (array[i] > array[j]) {
                    dp[i]++;
                }
                j++;

            }
        }
        //对dp求和取模
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dp[i];
            sum %= P;
        }
        return sum;
    }
    //参考了题解，要使用归并排序思路

    public int InversePairs2(int[] array) {

        return MergeSort(array, 0, array.length - 1);
    }

    public int MergeSort(int[] array, int left, int right) {
        //1.递归终止条件
        if (left >= right) return 0;
        //
        int count = 0;
        int mid = left + ((right - left) >> 1);
        count += MergeSort(array, left, mid);
        count += MergeSort(array, mid + 1, right);
        //进行归并思路
        count += Merge(array, left, mid, right);
        count %= 1000000007;
        return count;
    }

    //对排好序的两个数组进行归并策略(从小到大排序)
    public int Merge(int[] array, int left, int mid, int right) {
        //开辟一个空间
        int count = 0; //增加对逆序对的计数
        int[] temp = new int[right - left + 1];
        int p = 0;
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            //
            if (array[p1] <= array[p2]) {
                //选择p1
                temp[p++] = array[p1++];
            } else {
                temp[p++] = array[p2++];
                count += (mid - p1 + 1);
                count %= 1000000007;
            }
        }
        while (p1 <= mid) {
            temp[p++] = array[p1++];
        }
        while (p2 <= right) {
            temp[p++] = array[p2++];
        }
        //把temp结果复制到原数组
        p = 0;
        for (int i = left; i <= right; i++) {
            array[i] = temp[p++];
        }
        //
        return count;
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        int[] array = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        System.out.println(demo01.InversePairs2(array));
    }
}
