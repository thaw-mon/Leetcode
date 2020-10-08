package Year2020.October.day03;

public class Demo03 {

    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        return match(str, pattern, 0, 0);
    }

    public boolean match(char[] str, char[] pattern, int index1, int index2) {

        int n1 = str.length, n2 = pattern.length;
        while (index1 < n1 && index2 < n2) {
            int p = pattern[index2];
            if (p == str[index1]) {
                //判断下一个字符是否为*
                if (index2 + 1 < n2 && pattern[index2 + 1] == '*') {
                    //进行递归判断
                    boolean flag = false;
                    flag = match(str, pattern, index1, index2 + 2);
                    if (flag) return true;
                    for (int i = index1; i < n1; i++) {
                        if (p == str[i])
                            flag = match(str, pattern, i + 1, index2 + 2);
                        else break;
                        if (flag) break;
                    }
                    return flag;
                }
                //常规匹配没有递归
                index1++;
                index2++;
            } else if (p == '.') {
                //还有 .*类型数据
                if (index2 + 1 < n2 && pattern[index2 + 1] == '*') {
                    //进行递归判断
                    boolean flag = false;
                    flag = match(str, pattern, index1, index2 + 2);
                    if (flag) return true;
                    for (int i = index1; i <= n1; i++) {
                        flag = match(str, pattern, i, index2 + 2);
                        if (flag) break;
                    }
                    return flag;
                }

                index1++;
                index2++;
            } else {
                // p != str[index1]
                if (index2 + 1 < n2 && pattern[index2 + 1] == '*')
                    index2 += 2;
                else
                    break;
            }
        }
        if (index1 == n1) {
            //判断index2剩余是否为 .*格式
            while (index2 < n2) {
                if (index2 + 1 < n2 && pattern[index2 + 1] == '*') {
                    index2 += 2;
                } else
                    break;
            }
        }
        return index1 == n1 && index2 == n2;
    }

    public static void main(String[] args) {
        System.out.println(new Demo03().match("a".toCharArray(), ".*".toCharArray()));
    }
}
