package Year2020.April.day01;

import java.util.*;

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

        Deque<Integer> right = new LinkedList<>(); //记录向右移动的行星
        List<Integer> res = new ArrayList<>(); //记录碰撞后存活的行星
        //遍历行星
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                right.addLast(asteroid);
            } else {
                if (right.isEmpty()) {
                    res.add(asteroid);
                } else {
                    //发生碰撞
                    boolean flag = true;
                    while (!right.isEmpty()) {
                        int top = right.pollLast(); //获取向右行星
                        if (top >= Math.abs(asteroid)) {
                            //asteroid碰碎了或同归于尽
                            if (top > Math.abs(asteroid))
                                right.addLast(top);
                            flag = false;
                            break;
                        }
                        //top碰碎了 继续碰撞
                    }
                    //asteroid没有碰碎
                    if (flag) {
                        res.add(asteroid);
                    }
                }
            }
        }
        while (!right.isEmpty()){
            res.add(right.pollFirst());
        }
        //把res转换位数组
        int[] arrays = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arrays[i] = res.get(i);
        }
        return arrays;
    }
}
