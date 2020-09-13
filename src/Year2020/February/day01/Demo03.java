package Year2020.February.day01;

public class Demo03 {

    //只包含QWER四个字母的字符串，替换一个子串使其变成平衡字符串，求子串最短长度
    //只能替换子串
    public int balancedString(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[26];
        // 记录QWER各个字母的数量
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }
        int len = s.length();
        int left = 0, right = 0;
        int average = len / 4;// 字符的平均数量
        int ret = len;

        while (right < len) {// 窗口右边未出界
            --count[arr[right] - 'A'];// 字符从右边进入窗口，外面字符数量减1
            boolean flag = true;// 是否能向右移动窗口左边界即缩小窗口
            for (int i = 0; i < 26; ++i) {
                if (count[i] > average) {// 外面有字符的数量超过平均值
                    flag = false;// 窗口太小，不能缩小
                    break;
                }
            }
            while (flag && left < len) {// 可以缩小，并且未出界
                ++count[arr[left] - 'A'];// 字符从左边出窗口，数量减1
                ret = Math.min(ret, right - left + 1);// 更新结果
                if (count[arr[left] - 'A'] > average) {// 窗口外面字符数量超过平均值
                    flag = false;// 不能进一步缩小
                }
                ++left;// 窗口左边界右移，窗口缩小
            }
            ++right;// 窗口右边界右移，窗口增大
        }
        return ret;
    }
}
