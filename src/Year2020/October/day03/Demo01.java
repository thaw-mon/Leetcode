package Year2020.October.day03;

public class Demo01 {

    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     *
     * @param numbers     ： an array of integers
     * @param length      ： the length of array numbers
     * @param duplication ： (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
     * @return
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        //使用负数指代数字是否重复了
        boolean ret = false; //返回结果，指示是否重复
        //如果数字为0，修改为n
        for (int i = 0; i < length; i++) {
            int index = Math.abs(numbers[i]) % length;
            if (numbers[index] < 0) {
                duplication[0] = index;
                ret = true;
                break;
            } else if (numbers[index] == 0) {
                numbers[index] = -length;
            } else {
                numbers[index] = -numbers[index];
            }

        }
        return ret;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,0,2,5,3};
        int[] duplication = new int[1];
        System.out.println(new Demo01().duplicate(nums,nums.length,duplication));
        System.out.println(duplication[0]);
    }
}
