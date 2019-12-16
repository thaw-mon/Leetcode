package August.day14;

/**
 * @题目 ：192. Word Frequency
 * @Data 19/8/29
 * @题目描述： Write a bash script to calculate the frequency of each word in a text file words.txt.
 * For simplicity sake, you may assume:
 * words.txt contains only lowercase characters and space ' ' characters.
 * Each word must consist of lowercase characters only.
 * Words are separated by one or more whitespace characters.
 * @题目地址： 链接：https://leetcode-cn.com/problems/word-frequency
 */

//TODO 由于是采用脚本语言 直接粘贴答案
//    cat words.txt | xargs -n 1 | sort | uniq -c | sort -nr | awk '{print $2" "$1}'
//    xargs 分割字符串 -n 1表示每行输出一个 可以加-d指定分割符
//    要使用uniq统计词频需要被统计文本相同字符前后在一起，所以先排序 uniq -c 表示同时输出出现次数
//    sort -nr 其中-n表示把数字当做真正的数字处理(当数字被当做字符串处理，会出现11比2小的情况)
//作者：laotoutou
//链接：https://leetcode-cn.com/problems/word-frequency/solution/shelltong-ji-ci-pin-by-laotoutou/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class WordFrequency {
}
