package Year2020.April.day11;

import java.util.Scanner;

public class Demo05 {

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Demo05 demo05 = new Demo05();
        for (int i = 0; i < N; i++) {
            long x = in.nextLong(); //使用Long足够了
            int k = in.nextInt();
            //查询x在第k层的祖先节点
            System.out.println(demo05.getKparent(x, k));
        }
    }

    public long getKparent(long x, int k) {
        //1.获取第k层数据范围
        long k2 = ((long) 1 << k) - 1;
        if (x <= k2) return -1;
        while (x > k2) {
            x /= 2;
        }
        return x;
    }
}
