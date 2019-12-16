package November.day10;

/**
 * @题目 ： 389. Find the Difference
 * @Data 19/11/29
 * @题目描述： Given two strings s and t which consist of only lowercase letters.
 *
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 *
 * Find the letter that was added in t.
 *
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/find-the-difference
 * @示例1: ######
 * Input:
 * s = "abcd"
 * t = "abcde"
 *
 * Output:
 * e
 *
 * Explanation:
 * 'e' is the letter that was added.
 *
 * @示例2: ######
 * @示例3: ###
 */

public class FindDifference {
    // t = s + letter :找到letter
    public char findTheDifference(String s, String t) {
        int[] letters = new int[26];
        for(char c : s.toCharArray()){
            letters[c-'a']++;
        }
        for(char c : t.toCharArray()){
            letters[c- 'a']--;
            if(letters[c-'a'] < 0)
                return c;
        }
        return ' ';
    }
    //优化策略：，只要将所有的字符异或起来得到的就是出现一次的那个字符了
//      作者：sui-pufeng
//    链接：https://leetcode-cn.com/problems/find-the-difference/solution/javawei-yun-suan-by-sui-pufeng/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public char findTheDifference2(String s, String t) {
        char a =0;
        for(int i = 0 ; i < s.length() ; i++){
            a^=s.charAt(i);
        }
        for(int i = 0 ; i < t.length() ; i++){
            a^=t.charAt(i);
        }
        return a;

    }


}
