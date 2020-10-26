package Year2020.October.day11;

import java.util.Scanner;

public class Demo09 {

    public static void main(String[] args) {
        Demo09 demo09 = new Demo09();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num == 0) break;
            System.out.println(demo09.getBottle(num));
        }
    }

    /**
     * 三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”
     */
    public int getBottle(int num) {
        int cnt = 0;
        while (num >= 3) {
            int k = num / 3;
            cnt += k;
            num -= 2 * k;
        }
        if (num == 2) cnt++;
        return cnt;
    }
}
