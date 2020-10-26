package Year2020.October.day11;

import java.util.Scanner;

public class Demo04 {


    public static void main(String[] args){
        Demo04 demo04 = new Demo04();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        demo04.getPlace(s);
    }
    /**
     * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
     * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
     */

    public void getPlace(String s) {
        String[] array = s.split(";");
        int x = 0, y = 0;
        for (String str : array) {
            //1.判定字符有效性
            if (str.matches("[ADWS]\\d+")) {
                int num = Integer.parseInt(str.substring(1));
                switch (str.charAt(0)) {
                    case 'A':
                        x -= num;
                        break;
                    case 'D':
                        x += num;
                        break;
                    case 'W':
                        y += num;
                        break;
                    case 'S':
                        y -= num;
                        break;
                }
            }
        }
        System.out.println(x + "," + y);
    }
}
