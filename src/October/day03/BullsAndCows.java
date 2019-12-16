package October.day03;

import java.util.Map;

/**
 * @题目 ： 299. Bulls and Cows
 * @Data 19/10/06
 * @题目描述： You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * <p>
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * @题目地址： 链接：https://leetcode-cn.com/problems/bulls-and-cows
 * @示例1: ######
 * Input: secret = "1807", guess = "7810"
 * <p>
 * Output: "1A3B"
 * <p>
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * @示例2: ###
 * Input: secret = "1123", guess = "0111"
 * <p>
 * Output: "1A1B"
 * <p>
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * <p>
 * @示例3: ###
 */

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] bucket = new int[10];
        int bull = 0;
        int cow = 0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)== guess.charAt(i)){
                bull++;
                continue;
            }
            bucket[secret.charAt(i) - '0'] += 1;
            bucket[guess.charAt(i) - '0'] -= 1;

        }
        //计算bucket中正值的个数
        for(int i=0;i<10;i++){
            if(bucket[i] > 0)
                cow+= bucket[i];
        }

        cow = secret.length() - cow - bull;
        String res = bull + "A" + cow + "B";
        return res;
    }
}
