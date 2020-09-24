package Year2020.September.day15;

import java.util.*;

public class Demo01 {

    //未通过全部测试用例？？
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String baseStr = in.next();
        int len = baseStr.length();
        int minLen = len * 4 / 5;
        //小数据直接返回
        if (str.length() < minLen) {
            System.out.println(str);
            return;
        }
        StringBuilder sb = new StringBuilder();
        Map<Character, List<Integer>> wordMap = new HashMap<>();
        //特例测试
        if (minLen == 0) {
            for (int i = 0; i < str.length(); i++) {
                sb.append("*");
            }
            System.out.println(sb.toString());
            return;
        }
        //要符合敏感词匹配 len * 0.8
        //1.首先把把敏感词放入map中 [c, index_list]
        for (int i = 0; i + minLen <= len; i++) {
            char c = baseStr.charAt(i);
            if (!wordMap.containsKey(c)) wordMap.put(c, new ArrayList<>());
            wordMap.get(c).add(i);
        }
        //2.开始进行匹配工作,首先不一定要从首字母开始匹配
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!wordMap.containsKey(c)) {
                sb.append(c);
                continue;
            }
            //1.判定完全匹配后的剩余长度是否达到了0.8的标准
            if (str.length() - i < minLen) {
                sb.append(str.substring(i));
                break; //剩余长度够不到敏感词的最低约束
            }
            //进行匹配测试
            List<Integer> indexList = wordMap.get(c); //获取当前字符匹配敏感词的索引

            boolean flag = false; //未匹配成功
            for (int index : indexList) {
                // if ((len - index) < minLen) break; 判定前移了
                //候选敏感词匹配
                int result = isFitWord(str, i, baseStr, index, minLen);
                if (result == -1) continue;
                //成功匹配敏感词
                for (int j = i; j < result; j++) {
                    sb.append('*');
                }
                //修改i值
                i = result - 1; //为什么要减1,因为循环会加1
                flag = true;
                break;
            }
            //如果是循环后依然不符合条件
            if (!flag) sb.append(c);
        }
        System.out.println(sb.toString());
    }

    //暴力匹配法
    private static int isFitWord(String str, int index, String base, int start, int minLen) {
        boolean flag = true; //只是间隔的，还是计数？
        //int count = 0;
        int end = start, strFitIndex = index;
        for (; strFitIndex < str.length(); strFitIndex++) {
            if (end == base.length()) break; //敏感词匹配完成;
            if (str.charAt(strFitIndex) == base.charAt(end)) {
                flag = true;
                end++;
            } else {
              //  count++;
                if (!flag) break; //连续两次字符不匹配则退出
                flag = false;
               // if(count > 1) break;
            }
        }
        //此时比较匹配长度是否符合条件
        return (end - start) < minLen ? -1 : strFitIndex; //符合条件的下一个指针
    }

}
