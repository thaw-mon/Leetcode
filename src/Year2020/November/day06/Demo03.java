package Year2020.November.day06;

import java.util.Scanner;

public class Demo03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String op = scanner.next();
            display(n, op);
        }
    }

    public static void display(int n, String op) {
        int[] list = new int[Math.min(4, n)];
        //1.定义初始状态
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }
        int index = 0; //光标初始位置
        for (char c : op.toCharArray()) {
            switch (c) {
                case 'U':
                    if (index == 0) {
                        if (list[index] == 1) {
                            //重设index和对应的全部list
                            int temp = n;
                            for (int i = list.length - 1; i >= 0; i--) {
                                list[i] = temp--;
                            }
                            index = list.length - 1;
                        } else {
                            //重设list 每行减1
                            for (int i = 0; i < list.length; i++) {
                                list[i]--;
                            }
                        }
                    } else {
                        index--;
                    }
                    break;
                case 'D':
                    if (index == list.length - 1) {
                        if (list[index] == n) {
                            //重设index和list
                            for (int i = 0; i < list.length; i++) {
                                list[i] = i + 1;
                            }
                            index = 0;
                        } else {
                            for (int i = 0; i < list.length; i++) {
                                list[i]++;
                            }
                        }
                    } else {
                        index++;
                    }
            }
        }

        //打印结果
        for (int i = 0; i < list.length; i++) {
            if (i == list.length - 1) {
                System.out.println(list[i]);
                continue;
            }
            System.out.print(list[i] + " ");
        }
        System.out.println(list[index]);
    }
}
