package Year2020.September.day14;

import java.util.Arrays;
import java.util.Comparator;

public class Demo01 {

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     *
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int[] numbers) {
        //思路: 首先比较首位数字,数字相同比较下一位数字，没有数字就是默认和首数字相同,每缺失一个向后移动一位
        //1.先把numbers变为String类型
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        //2.使用自定义比较函数
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int n = Math.min(o1.length(), o2.length());
                for (int i = 0; i < n; i++) {
                    if (o1.charAt(i) == o2.charAt(i)) continue;
                    return o1.charAt(i) - o2.charAt(i);
                }
                //此时前面n长度字符都是相同的，比较o1或o2多出来的部分
                int j = 0;
                while (n < o1.length()) {
                    if (o1.charAt(n) == o1.charAt(j)) {
                        n++;
                        j++;
                        continue;
                    }
                    return o1.charAt(n) - o1.charAt(j);
                }
                while (n < o2.length()) {
                    if (o2.charAt(n) == o2.charAt(j)) {
                        n++;
                        j++;
                        continue;
                    }
                    return o2.charAt(j) - o2.charAt(n);
                }
                return 0; //到这里说明二者顺序不影响最终结果
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }


}
