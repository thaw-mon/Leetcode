package Year2020.September.day05;

public class Demo02 {

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param str
     * @return
     */
    //优化策略:两轮遍历，第一轮获取空格数目并计算总长度，第二轮一次性resize并插入数据
    public String replaceSpace(StringBuffer str) {
        int n = str.length();
        String repStr = "%20";
        for (int i = 0; i < n; i++) {
            //开始替换
            if (str.charAt(i) == ' ') {
                str.deleteCharAt(i);
                str.insert(i, repStr);
                i += 2;
                n += 2;
            }
        }
        return str.toString();
    }
}
