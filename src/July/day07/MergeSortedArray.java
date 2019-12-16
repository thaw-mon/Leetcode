package July.day07;


/**
 * @题目 ：88. 合并两个有序数组
 * @题目描述： 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * @说明: 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * @Date: 19/7/9
 * @示例 1: 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * @示例 2: ####
 **/

public class MergeSortedArray {
    //需要O(m)的额外空间
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = 0, n2 = 0;
        int[] tmp1 = new int[m];
        for (int i = 0; i < m; i++)
            tmp1[i] = nums1[i];
        int k = 0;
        while (n1 < m && n2 < n) {
            if (tmp1[n1] < nums2[n2]) {
                nums1[k++] = tmp1[n1];
                n1++;
            } else {
                nums1[k++] = nums2[n2];
                n2++;
            }
        }
        while (n1 < m) {
            nums1[k++] = tmp1[n1++];
        }
        while (n2 < n) {
            nums1[k++] = nums2[n2++];
        }
    }

    //采用尾插法,无需额外空间
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1, n2 = n - 1;
        int k = m + n - 1;
        while (n1 >= 0 && n2 >= 0) {
            if (nums1[n1] < nums2[n2]) {
                nums1[k--] = nums2[n2--];
            } else {
                nums1[k--] = nums1[n1--];
            }
        }
        while (n2 >= 0) {
            nums1[k--] = nums1[n1--];
        }
    }
}
