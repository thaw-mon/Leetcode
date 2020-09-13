package Year2020.July.day02;

/**
 * @Title : 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * @Date : 2020/07/05
 * @思路 ： 很简单的字符准换
 */
public class Demo01 {

    public boolean backspaceCompare(String S, String T) {
        //1.把字符转换位正常字符(没有#)
        String s1 = getString(S);
        String t1 = getString(T);

        return s1.equals(t1);
    }

    public String getString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '#' ) {
                if(sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
