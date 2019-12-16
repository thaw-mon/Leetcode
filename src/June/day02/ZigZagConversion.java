package June.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Data 19/5/30
 * @题目描述： 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   CombineTwoTables   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"
 * @示例： 1_exp
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * @示例： 2_exp
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * <p>
 * 这道题很容易发现其中的数学规律，
 * 第一行  2(row-1)*k + 1  （k=0,1,2,....,n）
 * 第二行  2(row-1)*k + 2 and 2(row-1)*k + 2 + 2(row-2)
 * 第三行  2(row-1)*k + 3 and 2(row-1)*k + 3 + 2(row-3)
 * 第row-1行 2(row-1)*k + k-1 and 2(row-1)*k + k-1 + 2(row-row+1)
 * 第row行 2(row-1)*k + row
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";

//        System.out.println(longestPalindrome(s));
        System.out.println(convert(s,100));
    }

    //数学思维 莽就完事 -_-
    public static String convert(String s, int numRows) {
        int n = s.length();
        if(numRows==1 || numRows >=n){
            return s;
        }
        char[] arrays = s.toCharArray();
        char[] newArray = new char[n];
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            int res = i;
            //第一行和最后一行只有一个数字
            if(i==0 || i ==numRows-1){
                while (res < n) {
                    newArray[index++] = arrays[res];
                    res += 2 * (numRows - 1);
                }
            } else {
                while (res < n) {
                    newArray[index++] = arrays[res];
                    int secondNum = res + 2 * (numRows-i-1);
                    if(secondNum < n ){
                        newArray[index++] = arrays[secondNum];
                    }
                    res += 2 * (numRows - 1);
                }
            }
        }
        return String.valueOf(newArray);
    }

    //标准答案 很简洁  思路：用List直接把s一个个分开
    public String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;  //false 向上  true向下

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    //按行排序，其实和我的数学方法思路差不多 写的更优美
    public String convert3(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
