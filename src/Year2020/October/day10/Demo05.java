package Year2020.October.day10;

import java.util.Scanner;

public class Demo05 {

    public static void main(String[] args){
        Demo05 demo03 = new Demo05();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(demo03.reverse(s));

    }
    /**
     * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
     * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
     */
    public String reverse(String sentence) {
        String[] word = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = word.length - 1; i >= 0; i--) sb.append(word[i]).append(" ");
        if (word.length > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
