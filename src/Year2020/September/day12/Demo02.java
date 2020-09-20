package Year2020.September.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Demo02 {

    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        //1.把字符串放入set中
        int[] word = new int[52];
        for (char c : str.toCharArray()) {
            word[c - 'A']++;
        }
        int n = str.length();
        if (n == 0) return new ArrayList<>();
        //获取由set构成的全部字符串
        return dp(word, new StringBuilder(), n);
    }

    private ArrayList<String> dp(int[] word, StringBuilder sb, int n) {
        ArrayList<String> ret = new ArrayList<>();
        if (sb.length() == n) {
            ret.add(sb.toString());
            return ret;
        }
        //52个英文字母
        for (int i = 0; i < 52; i++) {
            if (word[i] == 0) continue;
            char c = 'A';
            c += i;
            sb.append(c);
            word[i]--;
            ret.addAll(dp(word, sb, n));
            //
            sb.deleteCharAt(sb.length() - 1);
            word[i]++;
        }

        return ret;
    }

    public static void main(String[] args) {
        List<String> ret = new Demo02().Permutation("");
        System.out.println(ret.size());
        System.out.println(ret);
        //System.out.println(new StringBuilder().append('A' + 1).toString());
        //  System.out.println();
    }
}
