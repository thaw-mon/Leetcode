package Year2020.April.day07;

import java.util.*;

public class Demo01 {

    /**
     * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
     * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
     * 返回所有不常用单词的列表。
     *
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences(String A, String B) {
        String[] arrayA = A.split(" ");
        String[] arrayB = B.split(" ");
        Map<String, Integer> mapsA = new HashMap<>();
        Map<String, Integer> mapsB = new HashMap<>();
        for (String tmp : arrayA) {
            if (!mapsA.containsKey(tmp))
                mapsA.put(tmp, 0);
            mapsA.put(tmp, mapsA.get(tmp) + 1);
        }
        for (String tmp : arrayB) {
            if (!mapsB.containsKey(tmp))
                mapsB.put(tmp, 0);
            mapsB.put(tmp, mapsB.get(tmp) + 1);
        }
        List<String> ret = new ArrayList<>();
        //1.获取mapA中出现次数为1的String
        for (String tmp : mapsA.keySet()) {
            if (mapsA.get(tmp) == 1 && !mapsB.containsKey(tmp)) ret.add(tmp);
        }
        //2.获取mapB中出现次数为1的String
        for (String tmp : mapsB.keySet()) {
            if (mapsB.get(tmp) == 1 && !mapsA.containsKey(tmp)) ret.add(tmp);
        }
        int n = ret.size();
        String[] strs = new String[n];
        ret.toArray(strs);

        return strs;
    }

    public static void main(String[] args) {
        String arrA = "this apple is sweet";
        String arrB = "this apple is sour";
        System.out.println(Arrays.toString(new Demo01().uncommonFromSentences(arrA, arrB)));
    }
}
