package October.day07;

/**
 * @题目 ： 319. Bulb Switcher
 * @Data 19/10/14
 * @题目描述： There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the i-th round, you toggle every i bulb. For the n-th round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 *
 * 题目地址： 链接：https://leetcode-cn.com/problems/bulb-switcher
 * @示例1: ######
 * Input: 3
 * Output: 1
 * Explanation:
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 *
 * So you should return 1, because there is only one bulb is on.
 *
 * @示例2: ######
 * @示例3: ###
 */

public class BulbSwitcher {

    public static void main(String[] args){
        for(int i=1;i<100;i+=10){
            System.out.println(new BulbSwitcher().bulbSwitch(i));
        }
    }

    //直接思路法 O（N^2)--> 超时
    public int bulbSwitch(int n) {
        boolean[] bulb = new boolean[n];
        for(int i=1;i<=n;i++){
            for(int j=i-1;j<n;j+=i){
                bulb[j] = !bulb[j];
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(bulb[i]) count++;
        }
        return count;
    }

    //只要找到该位置的所有因数个数，我们就知道该位置翻转了多少次。
    public int bulbSwitch2(int n) {
        return (int)Math.sqrt(n);
    }
}
