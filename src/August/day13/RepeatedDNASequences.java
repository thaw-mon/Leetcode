package August.day13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @题目 ：187. Repeated DNA Sequences
 * @Data 19/8/21
 * @题目描述： All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * @题目地址： 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * @示例1: ######
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * @示例2: ###
 * @示例3: ###
 */


public class RepeatedDNASequences {

    public static void main(String[] args){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences(s));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= n; i++) {
            int value = map.getOrDefault(s.substring(i, i + 10), 0);
            map.put(s.substring(i, i + 10), value + 1);
        }
        List<String> res = new ArrayList<>();
        for (String str : map.keySet()) {
            if (map.get(str) > 1)
                res.add(str);
        }
        return res;
    }
}
