package Year2020.April.day03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //表示商品的数量
        int[] price = new int[N]; //表示商品的价格
        for (int i = 0; i < N; i++) {
            price[i] = in.nextInt();
        }

        //1.对price进行排序(由小到大)
        Arrays.sort(price);
        //2.每三个去除一个最低价
        long ans = 0, index = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (index % 3 == 2) {
                index++;
                continue;
            }
            ans += price[i];
            index++;
        }
        System.out.println(ans);
    }
}
