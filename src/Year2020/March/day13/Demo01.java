package Year2020.March.day13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo01 {

    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     * 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();

        Map<Character, Character> strMap = new HashMap<>();
        Set<Character> set = new HashSet<>();  //记录映射的字母，防止重复映射
        //a-a b-a false
        for (int i = 0; i < n; i++) {
            char tmpS = s.charAt(i);
            char tmpT = t.charAt(i);
            if (!strMap.containsKey(tmpS)) {
                //重复映射的情形
                if (set.contains(tmpT))
                    return false;
                strMap.put(tmpS, tmpT);
                set.add(tmpT);
            }
            if (strMap.get(tmpS) != tmpT) {
                return false;
            }
        }
        return true;

    }
}
