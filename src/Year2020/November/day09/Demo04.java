package Year2020.November.day09;

import java.util.Scanner;

public class Demo04 {
    /**
     * 有一个大小的数据表，你会依次进行以下5种操作：
     * 1.输入m和n，初始化m*n大小的表格。
     * 2.输入(x1,y1) (x2,y2) 交换(x1,y1) 和(x2,y2)
     * 3.输入x，在第x行左边添加一行。
     * 4.输入y，在第y列上方添加一列。
     * 5.输入x,y、，查找坐标为(x,y)的单元格的值。
     * 请编写程序，判断对表格的各种操作是否合法。
     * 1.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误。
     * 2.对于插入操作，如果插入后行数或列数超过9了则应返回错误。如果插入成功了则将数据表恢复至初始化的大小，多出的数据则应舍弃。
     * 3.所有输入坐标操作，对大小的表格，行号坐标只允许0~m-1，列号坐标只允许0~n-
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt(), n = scanner.nextInt();
            if (m <= 0 || m > 9 || n <= 0 || n > 9) System.out.println(-1);
            else System.out.println(0);
            int x1 = scanner.nextInt(), y1 = scanner.nextInt(), x2 = scanner.nextInt(), y2 = scanner.nextInt();
            if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || x2 < 0 || x2 > m || y2 < 0 || y2 > n) System.out.println(-1);
            else System.out.println(0);
            int x = scanner.nextInt();
            if (x < 0 || x >= m || m + 1 > 9) System.out.println(-1);
            else System.out.println(0);
            int y = scanner.nextInt();
            if (y < 0 || y >= n || n + 1 > 9) System.out.println(-1);
            else System.out.println(0);
            int x3 = scanner.nextInt(), y3 = scanner.nextInt();

            if (x3 < 0 || x3 >= m || y3 < 0 || y3 >= n) System.out.println(-1);
            else System.out.println(0);
        }
        scanner.close();
    }
}
