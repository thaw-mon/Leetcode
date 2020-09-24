package Year2020.September.day16;

public class Demo03 {

    /**
     * 统计一个数字在升序数组中出现的次数。
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        //有序数组要用二分排序
        return binarySearch(array, 0, array.length - 1, k);
    }

    private int binarySearch(int[] array, int left, int right, int k) {
        if (left > right) return 0;
        if (array[left] > k || array[right] < k) return 0;
        int count = 0, mid = left + ((right - left) >> 1);
        if (array[mid] == k) {
            count++;
            count += binarySearch(array, left, mid - 1, k);
            count += binarySearch(array, mid + 1, right, k);
        } else if (array[mid] < k) {
            count += binarySearch(array, mid + 1, right, k);
        } else {
            count += binarySearch(array, left, mid - 1, k);
        }
        return count;
    }
}
