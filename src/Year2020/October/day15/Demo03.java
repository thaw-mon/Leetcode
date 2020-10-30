package Year2020.October.day15;

import java.util.Scanner;

public class Demo03 {

    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String key = sc.next();
            String word = sc.next();
            System.out.println(demo03.encryption(key,word));
        }
    }
    /**
     * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
     * <p>
     * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
     * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
     * <p>
     * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
     * 请实现下述接口，通过指定的密匙和明文得到密文。
     */

    public String encryption(String key, String word) {
        char[] pwd = new char[26];
        boolean[] visited = new boolean[26];
        int index = 0;
        for (char c : key.toUpperCase().toCharArray()) {
            if (!visited[c - 'A']) {
                pwd[index++] = c;
                visited[c - 'A'] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                pwd[index] = 'A';
                pwd[index] += i;
                index++;
            }
        }
        //把word转换为ret
        StringBuilder ret = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                c = pwd[c - 'a'];
                c += 32;
            } else {
                c = pwd[c - 'A'];
            }
            ret.append(c);
        }
        return ret.toString();
    }
}
