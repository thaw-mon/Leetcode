package October.day08;

/**
 * 这题目就是前一道题目，解答为其他人的正确解答思路
 ***做题思路 **:
 * 最终取出 K 个数，等价于从第一个数组中取出 i {i ->(0, Math.min(len1, K))} 个数，从第二个数组中取出 K - i (K - i <= len2)个数;
 * 可以拆分成以下子问题
 *
 * 子问题1 :如何从一个数组中选择 k 个数组成的数最大 -> maxNum(int[] nums, int k)
 * 子问题2 :如何将两个数组组成一个数组使得组成的数最大 -> mergeNum(int[] num1, int[] num2) || 采用双指针归并，衍生问题是如果两个位置的数相同则需要进一步的处置 -> getNextStep(int[] num1, int[] num2, int l, int r)
 * 子问题3 :如何判断两个相同长度数组组成的数的大小 -> compareTo(int[] nums1, int[] nums2)
 *
 * 作者：zhuguohai
 * 链接：https://leetcode-cn.com/problems/create-maximum-number/solution/zuo-ti-si-lu-by-zhuguohai/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CreateMaximumNumberII {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        if(nums1.length + nums2.length < k){
            return res;
        }
        if(nums1.length > nums2.length){
            return maxNumber(nums2, nums1, k);
        }
        int len = Math.min(nums1.length, k);
        for(int i = 0 ; i <= len ; i ++){
            int len2 = k - i;
            if(len2 > nums2.length){
                continue;
            }
            int[] maxNum1 = maxNum(nums1, i);
            int[] maxNum2 = maxNum(nums2, len2);
            //TODO 这里使用了两次mergeNum 可以优化的）
            res = compareTo(mergeNum(maxNum1, maxNum2), res) ? mergeNum(maxNum1, maxNum2) : res;
        }
        return res;
    }
    public boolean compareTo(int[] nums1, int[] nums2){
        for(int i = 0 ; i < nums1.length ; i ++){
            if(nums1[i] > nums2[i]){
                return true;
            }
            else if(nums1[i] < nums2[i]){
                return false;
            }
        }
        return true;
    }
    public int[] mergeNum(int[] num1, int[] num2){
        int[] res = new int[num1.length + num2.length];
        int k = 0 , l = 0 , r = 0;
        while(l < num1.length && r < num2.length){
            if(num1[l] < num2[r]){
                res[k ++] = num2[r ++];
            }
            else if(num1[l] > num2[r]){
                res[k ++] = num1[l ++];
            }
            else{
                if(getNextStep(num1, num2, l, r)){
                    res[k ++] = num1[l ++];
                }
                else{
                    res[k ++] = num2[r ++];
                }
            }
        }
        while(l < num1.length){
            res[k ++] = num1[l ++];
        }
        while(r < num2.length){
            res[k ++] = num2[r ++];
        }
        return res;
    }
    public boolean getNextStep(int[] num1, int[] num2, int l, int r){
        if(l >= num1.length && r >= num2.length){
            return true;
        }
        if(r >= num2.length){
            return true;
        }
        if(l >= num1.length){
            return false;
        }
        if(num1[l] == num2[r]){
            return getNextStep(num1, num2, l + 1, r + 1);
        }
        else if(num1[l] > num2[r]){
            return true;
        }
        else{
            return false;
        }

    }
    public int[] maxNum(int[] nums, int k){
        int[] res = new int[k];
        int l = 0, r = nums.length - k;
        for(int i = 0 ; i < k ; i ++){
            int[] max = getMaxNum(nums, l, r);
            res[i] = max[0];
            l = max[1] + 1;
            r = r + 1;
        }
        return res;
    }
    public int[] getMaxNum(int[] nums, int l, int r){
        int[] res = new int[2];
        int k = l;
        int max = -1;
        while(k <= r){
            if(nums[k] > max){
                max = nums[k];
                res[0] = max;
                res[1] = k;
                if(max == 9){
                    return res;
                }
            }
            k ++;
        }
        return res;
    }

}
