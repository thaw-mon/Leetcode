package Year2020.November.day07;

import java.util.Scanner;
import java.util.Stack;

public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] x = new int[N];
            int[] y = new int[N];
            for (int i = 0; i < N; i++) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }
            String str = scanner.next();
            System.out.println(countCompute(x, y, str));
        }
        scanner.close();
    }

    /**
     * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
     * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
     * 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
     * 编写程序计算不同的计算顺序需要进行的乘法次数
     */
    public static int countCompute(int[] x, int[] y, String str) {
        Stack<Integer> num = new Stack<>();
        int count = 0;
        int index = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                continue;
            } else if (c == ')') {
                //TODO 正常这句是不用加的，但是牛客垃圾测试用例存在有一个用例多出来了一个)
                if (num.size() < 2) continue;
                int n2 = num.pop();
                int n1 = num.pop();
                //计算n1 * n2的计算量
                int temp = x[n1] * y[n2] * y[n1];
                count += temp;
                y[n1] = y[n2];
                num.push(n1);
            } else {
                num.push(index++);
            }
        }
        return count;
    }
}
