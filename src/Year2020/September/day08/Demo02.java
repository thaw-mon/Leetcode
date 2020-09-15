package Year2020.September.day08;

public class Demo02 {


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        int n = array.length;
        if (n == 0) return 0;
        //结果 a 前面为递减后面为递增
        int ret = array[0];
        int preNumber = array[0];
        //1.直接遍历法
        for (int i = 1; i < n; i++) {
            if (array[i] >= preNumber) {
                preNumber = array[i];
            } else {
                ret = array[i];
                break;
            }
        }

        return ret;
    }

    //TODO 思路2 使用二分查找法
    public int minNumberInRotateArray2(int[] array) {
        int n = array.length;
        if (n == 0) return 0;
        int left = 0, right = n - 1;
        //旋转右端点作为target
        while (left < right) {
            if (array[left] < array[right]) {
                return array[left];
            }
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else
                right--;

        }
        return array[left];
    }
}
