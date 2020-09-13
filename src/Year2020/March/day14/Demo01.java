package Year2020.March.day14;

import java.util.Stack;

public class Demo01 {

    /**
     * 给定一个整数数组 asteroids，表示在同一行的行星。
     * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
     * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
     *
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        int N = asteroids.length;
        //一定要是正负才能发生碰撞
        Stack<Integer> stack = new Stack<>(); //记录可以发生碰撞的行星(+)
        int count = 0;  //记录碰碎的行星数目
        for (int i = 0; i < N; i++) {
            if (asteroids[i] > 0) {
                stack.push(i);
            } else if (asteroids[i] < 0) {
                int temp = Math.abs(asteroids[i]);
                while (!stack.isEmpty()) {
                    int p = stack.pop();
                    //p 和 temp 发生碰撞
                    if (asteroids[p] >= temp) {
                        asteroids[i] = 0; //i号行星碰碎
                        count++;
                        if (asteroids[p] == temp) {  //两个行星都碰碎了
                            count++;
                            asteroids[p] = 0;  //p号行星碰碎
                        }else {
                            stack.push(p);  // p号行星保留
                        }
                        break;
                    }
                    asteroids[p] = 0; //p号行星碰碎
                    count++;
                }
            }
        }
        int[] ret = new int[N - count];
        int index = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                ret[index++] = asteroid;
            }
        }
        return ret;

    }
    public static void main(String[] args){
        int[] arr = new int[]{-2,1,-1,-2};
        int[] ans = new Demo01().asteroidCollision(arr);
        for(int a : ans)
            System.out.println(a);
    }
}
