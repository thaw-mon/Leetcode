package Year2020.March.day14;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Demo03 {

    /**
     * 给定一个化学式formula（作为字符串），返回每种原子的数量。
     *
     * @param formula
     * @return
     */
    public String countOfAtoms(String formula) {
        //计算化学方程式中的原子数目
        Map<String, Integer> map = new TreeMap<>();
        int N = formula.length();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>(); //用来处理包括括号的情形

        int num = 0;
        while (index < N) {
            char temp = formula.charAt(index);
            //
            if (temp >= 'A' && temp <= 'Z') {
                if (sb.length() == 0)
                    sb.append(temp);
                else {
                    //
                    String str = sb.toString();
                    if (num == 0) num = 1;  //没有数字输入情形
                    map.put(str, num += map.getOrDefault(str, 0));
                    sb = new StringBuilder().append(temp);
                    num = 0;
                }
            } else if (temp >= 'a' && temp <= 'z') {
                sb.append(temp);
            } else if (temp >= '0' && temp <= '9') {
                num *= 10;
                num += temp - '0';

            } else if (temp == '(') {
                //带括号如何处理呢？？
            } else if (temp == ')') {

            }
            index++;
        }
        return  null;
    }
}
