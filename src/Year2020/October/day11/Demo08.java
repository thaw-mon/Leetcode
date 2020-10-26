package Year2020.October.day11;

import java.util.Arrays;
import java.util.Scanner;

public class Demo08 {

    public static void main(String[] args){
        Demo08 demo08 = new Demo08();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            System.out.println(demo08.transportPasswd(s));
        }
    }
    /**
     * 大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
     * 就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
     * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，
     * 如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
     */
    public String transportPasswd(String str) {
        //1.record 默认规则
        char[] word = new char[26];
        int index = 0;
        for (int j = 0; j < 3; j++) word[index++] = '2';
        for (int j = 0; j < 3; j++) word[index++] = '3';
        for (int j = 0; j < 3; j++) word[index++] = '4';
        for (int j = 0; j < 3; j++) word[index++] = '5';
        for (int j = 0; j < 3; j++) word[index++] = '6';
        for (int j = 0; j < 4; j++) word[index++] = '7';
        for (int j = 0; j < 3; j++) word[index++] = '8';
        for (int j = 0; j < 4; j++) word[index++] = '9';
        assert index == 26;
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'a' && array[i] <= 'z') {
                array[i] = word[array[i] - 'a'];
            } else if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] += 32;
                if (array[i] == 'z') {
                    array[i] = 'a';
                } else
                    array[i] += 1;
            }
        }
        return new String(array);
    }
}
