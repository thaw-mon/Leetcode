package Year2020.October.day14;

import java.util.Scanner;

public class Demo02 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Demo02 demo02 = new Demo02();
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            System.out.println(demo02.invertString(s));
        }
    }
    /**
     * 对字符串中的所有单词进行倒排。
     * <p>
     * 说明：
     * 1、构成单词的字符只有26个大写或小写英文字母；
     * 2、非构成单词的字符均视为单词间隔符；
     * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
     * 4、每个单词最长20个字母；
     */
    public String invertString(String str) {
        String[] arr = str.split("[^(A-Z|a-z)]+");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }
       /* //删除多余空格
        if (arr.length > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }*/
        return sb.toString().trim(); //删除多余空格
    }
}
