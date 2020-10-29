package Year2020.October.day14;

import java.util.Scanner;

public class Demo01 {

    /**
     * 按照指定规则对输入的字符串进行处理。
     * <p>
     * 详细描述：
     * 将输入的两个字符串合并。
     * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。
     * 这里的下标意思是字符在字符串中的位置。
     * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，
     * 则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。
     * 如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’；
     * 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo01 demo01 = new Demo01();
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            char[] result = new char[s1.length() + s2.length()];
            demo01.ProcessString(s1.toCharArray(), s2.toCharArray(), result);
            System.out.println(result);
        }
    }

    /**
     * 字符串处理
     *
     * @param str1      输入字符串,需要异常处理
     * @param str2      输入字符串,需要异常处理
     * @param strOutput 合并处理后的字符串
     */
    void ProcessString(char[] str1, char[] str2, char[] strOutput) {
        //1.合并字符串
        // strOutput = new char[str1.length + str2.length];
        int index = 0;
        for (char c : str1) {
            // if (c == '\0') break;
            strOutput[index++] = c;
        }
        for (char c : str2) {
            strOutput[index++] = c;
            //if (c == '\0') break;
        }
        //2.分别按照下标的奇偶数进行排序
        mySort(strOutput, 0, 2);
        mySort(strOutput, 1, 2);
        //3 对排序后的字符串进行操作
        transportStr(strOutput);
    }


    //简单的冒泡排序
    void mySort(char[] str, int start, int k) {
        for (int i = start; i < str.length; i += k) {
            char temp = str[i];
            int j = i - k;
            for (; j >= start; j -= k) {
                if (temp < str[j]) {
                    str[j + k] = str[j];
                    str[j] = temp;
                } else {
                    str[j + k] = temp;
                    break;
                }
            }

        }
    }

    //对排序后的字符串进行操作进制转换
    void transportStr(char[] str) {
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            int num = 0;
            if (c >= '0' && c <= '9') {
                num = c - '0';
                //获取num的2进制倒序
                //num ^= 0x0F;
            } else if (c >= 'A' && c <= 'F') {
                num = c - 'A' + 10;
                //num ^= 0x0F;
            } else if (c >= 'a' && c <= 'f') {
                num = c - 'a' + 10;
                // num ^= 0x0F;
            } else {
                continue; //不执行任何操作
            }
            int ret = 0;
            for (int j = 0; j < 4; j++) {
                int temp = num & 0x01; //二进制最后一位
                ret <<= 1;
                ret += temp;
                num >>>= 1;
            }
            num = ret;
            if (num >= 10) {
                c = 'A';
                c += (num - 10);
            } else {
                c = '0';
                c += num;
            }
            str[i] = c;
        }
    }
}
