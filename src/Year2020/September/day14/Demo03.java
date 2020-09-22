package Year2020.September.day14;

public class Demo03 {

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
     * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        // int[] largeWordCount = new int[26]; //大写字母计数
        // int[] smallWordCount = new int[26]; //小写字母计数
        //不需要计算，当出现频率大于1把索引置为负数
        int[] largeWordIndex = new int[26]; //大写字母索引
        int[] smallWordIndex = new int[26]; //小写字母索引
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > 'Z') { //小写字母
                if (smallWordIndex[c - 'a'] == -1) continue; //已经出现超过一次了
                //从未出现过，记录索引 i+1 原因是索引是从0开始计数的,为了方便使用初始0判定释放第一次出现 ,因此记录索引+1
                if (smallWordIndex[c - 'a'] == 0) smallWordIndex[c - 'a'] = (i + 1);
                else smallWordIndex[c - 'a'] = -1;
            } else {
                //大写字母
                if (largeWordIndex[c - 'A'] == -1) continue;
                if (largeWordIndex[c - 'A'] == 0) largeWordIndex[c - 'A'] = (i + 1);
                else largeWordIndex[c - 'A'] = -1;
            }
        }
        //最后遍历一遍数据
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (smallWordIndex[i] > 0) {
                //注意这里要有减1操作才是真正的index
                index = Math.min(index, smallWordIndex[i] - 1);
            }
            if (largeWordIndex[i] > 0) {
                index = Math.min(index, largeWordIndex[i] - 1);
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
