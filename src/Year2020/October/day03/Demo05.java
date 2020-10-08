package Year2020.October.day03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Demo05 {

    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     */
    //1.queue保存顺序保存全部字符，且首字符为出现1次的字符
    Queue<Character> queue = new LinkedList<>();
    //2.map保存全部字符出现频次
    Map<Character, Integer> mapCount = new HashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        //已经出现的字符不再插入队列，只对计数器+1
        if (mapCount.containsKey(ch)) {
            mapCount.put(ch, mapCount.get(ch) + 1);
        } else {
            mapCount.put(ch, 1);
            queue.add(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char ret = '#';
        while (!queue.isEmpty()) {
            char temp = queue.peek();
            if (mapCount.get(temp) == 1) {
                ret = temp;
                break;
            }
            queue.poll();
        }
        return ret;
    }
}
