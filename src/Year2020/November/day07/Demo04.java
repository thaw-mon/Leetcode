package Year2020.November.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo04 {


    /**
     * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。
     * 百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int n1 = 0; // 鸡翁个数
            int n2 = 0; // 鸡母个数
            int n3 = 3; // 鸡雏个数
            for (n1 = 0; n1 < 20; n1++) {
                for (n2 = 0; n2 < 33; n2++) {
                    for (n3 = 0; n3 < 100; n3 = n3 + 3) {
                        if (n1 + n2 + n3 == 100 && 5 * n1 + 3 * n2 + n3 / 3 == 100) {
                            System.out.println(n1 + " " + n2 + " " + n3);
                        }
                    }
                }
            }
        }
        sc.close();
    }


}
