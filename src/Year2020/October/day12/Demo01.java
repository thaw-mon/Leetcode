package Year2020.October.day12;


import java.util.Scanner;

public class Demo01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo01 demo01 = new Demo01();
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] height = new int[N];
            for (int i = 0; i < N; i++) {
                height[i] = scanner.nextInt();
            }
            System.out.println(N - demo01.dp(height));
        }
    }

    /**
     * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
     * 说明：
     * <p>
     * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
     * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
     * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
     * 也就是说要山峰类型排列
     */
    public int dp(int[] height) {
        //1.找到顶点
        int N = height.length;
        int[] left = new int[N], right = new int[N];
        for (int i = 0; i < N; i++) {
            left[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (height[i] > height[j])
                    left[i] = Math.max(left[i], left[j] + 1);
                else if (left[j] == 1) { //提前跳出
                    break;
                }
            }
        }
        //同理获取right[i]
        for (int i = N - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = i + 1; j < N; j++) {
                if (height[i] > height[j]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                } else if (right[j] == 1) {
                    break;
                }
            }
        }
        //最后获取最长队列长度
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            maxLen = Math.max(maxLen, left[i] + right[i] - 1);
        }
        return maxLen;
    }
}
