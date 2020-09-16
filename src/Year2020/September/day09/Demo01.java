package Year2020.September.day09;

public class Demo01 {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        //结果为 2^(n-1)
        // 1 1 2 4 8 16
        return (int)Math.pow(2,target-1);
    }
}
