package Year2020.November.day12;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Demo01 {
    /**
     * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
     * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）
     * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（40分）
     */
    //1234567
    public static String getMoney(double money) {
        String[] num = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] type = {"元", "拾", "佰", "仟", "万", "亿", "角", "分"};
        int num1 = (int) money;
        money = money - (double) num1  + 0.001; //获取小数部分出问题了,预期获取0.15实际变成了0.14999
        StringBuilder sb = new StringBuilder("人民币");
        Stack<String> stack = new Stack<>();
        int keyIndex = 0;
        while (num1 > 0) {
            int bitNum = num1 % 10;
            num1 /= 10;
            if (bitNum == 0) {
                if (!stack.peek().equals(num[bitNum]))
                    stack.push(num[bitNum]);
                keyIndex++;
                continue;
            }
            if (keyIndex % 4 == 0) {
                if (keyIndex == 0) {
                    stack.push(num[bitNum] + type[0]);
                } else {
                    int k1 = keyIndex / 8; //表示前面有多少个亿,
                    int k2 = (keyIndex / 4) % 2; //表示前面有0-1个万
                    stack.push(num[bitNum] +  String.join("", Collections.nCopies(k2, type[4])) + String.join("", Collections.nCopies(k1, type[5])));
                }
            } else {
                stack.push(num[bitNum] + type[keyIndex % 4]);
            }
            keyIndex++;
        }
        while (!stack.isEmpty()) {
            String tmp = stack.pop();
            if(sb.toString().equals("人民币") && tmp.equals("壹拾")){
                tmp = "拾";
            }
            sb.append(tmp);
        }
        //判断是否存在小数
        StringBuilder decimal = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            money *= 10;
            if ((int) money > 0) {
                decimal.append(num[(int) money]).append(type[6 + i]);
            }
            money -= (int) (money);
        }
        if (decimal.length() == 0) {
            sb.append("整");
        } else
            sb.append(decimal);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double value = scanner.nextDouble();
            System.out.println(getMoney(value));
        }
        scanner.close();
    }
}
