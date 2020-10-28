package Year2020.October.day13;

import java.util.*;

public class Demo01 {

    /**
     * 查找兄弟单词
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo01 demo01 = new Demo01();
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            Map<String, List<String>> map = new HashMap<>(); //不能使用set,因为存在重复单词
            for (int i = 0; i < N; i++) {
                String word = scanner.next();
                //
                String key = demo01.getLeastStr(word);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(word);


            }
            String word1 = scanner.next();
            String key1 = demo01.getLeastStr(word1);
            List<String> brother = map.getOrDefault(key1, new ArrayList<>());
            //去除brother中== word的单词
            List<String> relBrother = new ArrayList<>();
            for (String s : brother) {
                if (!s.equals(word1)) {
                    relBrother.add(s);
                }
            }
            relBrother.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            System.out.println(relBrother.size());
            int no = scanner.nextInt();
            if (relBrother.size() >= no) {
                System.out.println(relBrother.get(no - 1));
            }
        }
    }

    //如何获取一个单词的最小排列
    public String getLeastStr(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
