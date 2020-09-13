package Year2020.February.day01;

public class Demo02 {

    //判断是否是字母异位词
    public boolean isAnagram(String s, String t) {
        //长度不相等
        if (s.length() != t.length()) return false;
        //由于只有小写字母，可以使用数组
        int[] words = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            words[s.charAt(i) - 'a']++;
            words[t.charAt(i) - 'a']--;
        }
        //判断数组是否全部为0
        for (int i = 0; i < 26; i++) {
            if (words[i] != 0) return false;
        }
        return true;
    }
}
