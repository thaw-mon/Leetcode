package Year2020.April.day04;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //TODO 结果超时了？？
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //表示员工数量
        int[] w = new int[N]; //表示员工技能等级
        for (int i = 0; i < N; i++) {
            w[i] = in.nextInt();
        }
        int[] t = new int[N]; //表示任务难度等级
        for (int i = 0; i < N; i++) {
            t[i] = in.nextInt();
        }
        int M = in.nextInt(); //表示模数

        //1.对数组进行排序（从小到大）
        Arrays.sort(w);
        Arrays.sort(t);

        int index = 0; //表示上一级员工可分配的最大任务等级
        int ret = 1;
        for (int i = 0; i < N; i++) {
            //判定当前员工等级可以分配的任务数目
            int j = index;
            for (; j < N; j++) {
                if (w[i] < t[j]) {
                    break;
                }
            }
            //当前员工可以完成的最大等级为w[j-1]
            ret = (ret * (j - i)) % M;
        }

        System.out.println(ret);
    }


    /**
     * 求分配任务的组合（w,t已排序）
     *
     * @param w : 员工技能等级
     * @param t ： 任务难度等级
     * @param M ： 模数
     * @return
     */
    public int assignWorkWay(int[] w, int[] t, int M) {
        int n = w.length;
        int index = 0; //表示上一级员工可分配的最大任务等级
        int ret = 1;
        for (int i = 0; i < n; i++) {
            //判定当前员工等级可以分配的任务数目
            int j = index;
            for (; j < n; j++) {
                if (w[i] < t[j]) {
                    break;
                }
            }
            //当前员工可以完成的最大等级为w[j-1]
            ret = (ret * (j - i)) % M;
        }
        return ret;
    }
}
