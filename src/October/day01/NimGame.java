package October.day01;

/**
 * @题目 ： 292. Nim Game
 * @Data 19/10/01
 * @题目描述： You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 *
 * @题目地址： 链接：https://leetcode-cn.com/problems/nim-game
 * @示例1: ######
 * Input: 4
 * Output: false
 * Explanation: If there are 4 stones in the heap, then you will never win the game;
 *              No matter 1, 2, or 3 stones you remove, the last stone will always be
 *              removed by your friend.
 *
 * @示例2: ###
 * @示例3: ###
 */

public class NimGame {

    //反向求解: 定义 dp[i] =  dp[i-1~3]==0 ? 1 : 0
    //0表示输 1表示赢
    //数学规律法 : 4 ,8 12 ,  4*n 为输
    //更快的写法 ： return n & 3;
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
