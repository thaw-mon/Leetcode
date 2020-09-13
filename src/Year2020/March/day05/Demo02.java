package Year2020.March.day05;

public class Demo02 {

    /**
     * 在未排序的数组中找到第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
     * @param nums
     * @param k
     * @return 第 k 个最大的元素。(从1开始计数)
     */
    public int findKthLargest(int[] nums, int k) {
        //思路采取快排的思路 从大到小排序
        int l = 0,r = nums.length -1 ;
        k--; //因为是从1开始计数
        while (l < r){
            int place = spilt(nums,l,r);
            if(place < k){
                l = place + 1;
            }else if(place > k){
                r = place-1;
            }else {
                l = r = place;
            }
        }
        return nums[l];
    }

    public int spilt(int[] nums, int l,int r){
        //判断num[l]所在的位置
        int value = nums[l];
        while (l < r){
            //1.从右往左找第一个大于value的数组
            while (l < r && nums[r] <= value){
                r--;
            }
            if(l < r){
                nums[l++] = nums[r];
            }
            while (l < r &&  nums[l] > value) {// 向右寻找第一个小于index的数
                l++;
            }
            if(l < r){
                nums[r--] = nums[l];
            }
        }
        nums[l] = value;
        return l;
    }
}
