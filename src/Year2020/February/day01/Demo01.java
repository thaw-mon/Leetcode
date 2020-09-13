package Year2020.February.day01;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {
    //通过键盘判断位置
    public int calculateTime(String keyboard, String word) {
        //1. 把keyboard转换为map
        Map<Character, Integer> boardMaps = new HashMap<>();
        int index = 0;
        for (char c : keyboard.toCharArray()) {
            boardMaps.put(c, index++);
        }
        //2. 查找word不同单词的位置
        int init = 0, count = 0;//初始位置
        for (char c : word.toCharArray()) {
            int value = boardMaps.get(c);
            count += Math.abs(init - value);
            init = value;
        }
        return count;
    }
}
