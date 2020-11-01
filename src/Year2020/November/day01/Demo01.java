package Year2020.November.day01;

import java.util.Scanner;

public class Demo01 {

    public static void main(String[] args){
        Demo01 demo01 = new Demo01();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            demo01.randomDown(n);
        }
        scanner.close();
    }
    /**
     * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下,
     * 求它在第5次落地时，共经历多少米?第5次反弹多高？
     * 最后的误差判断是小数点6位
     */
    public void randomDown(int n) {
        double len = n;
        double sum = 0.0;
        for (int i = 0; i < 5; i++) {
            //第i+1次落地后经历的距离
            sum += len;
            if (i > 0) { //除了第一次其他距离都为两倍
                sum += len;
            }
            len /= 2; //下一次落地的初始距离
        }
        System.out.println(sum);
        System.out.println(len);
    }
}
