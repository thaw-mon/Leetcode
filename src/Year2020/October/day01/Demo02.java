package Year2020.October.day01;

import java.util.HashSet;
import java.util.Set;

public class Demo02 {


    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * //num1,num2分别为长度为1的数组。传出参数
     * //将num1[0],num2[0]设置为返回结果
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        //1.直接思路使用map
        //2.如果只有1个数字，可以直接使用异或操作，最后结果为唯一数字
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            res ^= num;
            set.add(num);
        }
        for (int v : set) {
            int tmp = res ^ v;
            if (set.contains(tmp)) {
                //最终结果
                num1[0] = v;
                num2[0] = tmp;
                break;
            }
        }

    }

    //优化解法，不用set
    public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        int res = 0;
        for (int num : array) {
            res ^= num;
        }
        res &=(-res); //获取第i位位1的二进制数
        num1[0] = 0;
        num2[0] = 0;
        for(int num : array){
            if((num & res)==0) num1[0] ^= num;
            else num2[0] ^= num;
        }
    }
    public static void main(String[] args){
        int[] array = {1,2,3,7,0,2,0,3};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new Demo02().FindNumsAppearOnce(array,num1,num2);

        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
