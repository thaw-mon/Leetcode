package Year2020.March.day06;

public class Demo01 {

    /**
     * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
     * @param nums 未经排序的整数数组
     * @return 最长且连续的的递增序列
     */
    public int findLengthOfLCIS(int[] nums) {
        int ret = 0;
        int tmp = 0,preNum = Integer.MIN_VALUE;
        for(int num : nums){
            //判断是否是递增序列
            if(num > preNum){
                tmp++;
            }else {
                ret = Math.max(ret,tmp);
                tmp = 1;
            }
            preNum = num;
        }
        ret = Math.max(ret,tmp);
        return ret;
    }
}
