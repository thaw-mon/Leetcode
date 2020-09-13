package Year2020.March.day15;

// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pokers = new int[10];
        //1. 获取输入
        for (int i = 0; i < 10; i++) {
            int temp = sc.nextInt();
            pokers[i] = temp;
        }

        //单牌 对子 顺子 和连对
        //优先顺子和连对 然后是对子 最后是 单牌
        Main main = new Main();
        int ret = main.DFS(pokers, 0);
        System.out.println(ret);
    }

    //优先连对，然后顺子，接着对子，最后使用单排
    public int DFS(int[] pokers, int index) {
        if (index == pokers.length) return 0;
        int ret = Integer.MAX_VALUE;
        if (pokers[index] == 0) return DFS(pokers, index + 1);
        //判定pokers[i]可以组成什么类型
        if (isSeqDouble(pokers, index)) {
            for (int i = index; i < index + 3; i++) {
                pokers[i] -= 2;
            }
            if (pokers[index] == 0) {
                ret = Math.min(1 + DFS(pokers, index + 1), ret);
            } else
                ret = Math.min(1 + DFS(pokers, index), ret);
            //复原
            for (int i = index; i < index + 3; i++) {
                pokers[i] += 2;
            }
        }
        if (isSeqNum(pokers, index)) {
            for (int i = index; i < index + 5; i++) {
                pokers[i] -= 1;
            }
            if (pokers[index] == 0) {
                ret = Math.min(1 + DFS(pokers, index + 1), ret);
            } else
                ret = Math.min(1 + DFS(pokers, index), ret);
            //复原
            for (int i = index; i < index + 5; i++) {
                pokers[i] += 1;
            }
        }
        if (isDouble(pokers, index)) {
            pokers[index] -= 2;
            if (pokers[index] == 0) {
                ret = Math.min(1 + DFS(pokers, index + 1), ret);
            } else
                ret = Math.min(1 + DFS(pokers, index), ret);
            pokers[index] += 2;
        }
        pokers[index] -= 1;
        if (pokers[index] == 0) {
            ret = Math.min(1 + DFS(pokers, index + 1), ret);
        } else
            ret = Math.min(1 + DFS(pokers, index), ret);
        pokers[index] += 1;

        return ret;
    }

    public boolean isDouble(int[] pokers, int index) {
        return pokers[index] >= 2;
    }

    //判定是否可以组成连对
    public boolean isSeqDouble(int[] pokers, int index) {
        //无法组成连对
        if (index + 3 > pokers.length) return false;
        for (int i = index; i < index + 3; i++) {
            if (pokers[i] < 2) {
                return false;
            }
        }
        return true;
    }

    //判定是否可以组成顺子
    public boolean isSeqNum(int[] pokers, int index) {
        if (index + 5 > pokers.length) return false;
        for (int i = index; i < index + 5; i++) {
            if (pokers[i] < 1) {
                return false;
            }
        }
        return true;
    }

}