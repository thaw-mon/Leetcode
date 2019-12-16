package June.day15;

import java.util.*;

/**
 * @题目 ：49. 字母异位词分组
 * @题目描述： 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * @Date:19/6/27
 * @说明： 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * @示例 1: 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 */
public class GroupAnagrams {


    //思路,把str转换为char[] -->用排序后的char[]作为键 equal的str作为value,参考如下链接
    //    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> myMap = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if (!myMap.containsKey(key)) {
                myMap.put(key, new ArrayList<>());
            }
            myMap.get(key).add(str);
        }
        return new ArrayList<>(myMap.values());
    }

    //大佬的素数法：CombineTwoTables++版本

//    vector<vector<string>> vAns;
//    unordered_map<double, vector<string>>hmAll;
//    map<char, int> hmNum = {
//            {'a',2},{ 'b',3 },{ 'c',5 },{ 'd',7 },{ 'e',11},{ 'f',13 },{ 'g',17 },{ 'h',19 },{ 'i',23 },{ 'j',29 },{ 'k',31 },
//            { 'l',37 },{ 'm',41 },{ 'n',43 },{ 'o',47 },{ 'p',53 },{ 'q',59 },{ 'r',61 },{ 's',67 },{ 't',71 },{ 'u',73 },{ 'v',79 },
//            { 'w',83 },{ 'x',89 },{ 'y',97 },{ 'z',101 }
//    };
//for (int i = 0; i < strs.size(); i++) {
//        double sum = 1;
//        for (int j = 0; j < strs.at(i).size(); j++) {
//            sum *= hmNum[strs.at(i).at(j)];
//        }
//        hmAll[sum].push_back(strs.at(i));
//    }
//for (auto iter = hmAll.begin(); iter != hmAll.end(); iter++) {
//        vAns.push_back(iter->second);
//    }
//return vAns;
//
//    作者：greenpill
//    链接：https://leetcode-cn.com/problems/two-sum/solution/pai-xu-fa-su-shu-fa-by-greenpill/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}
