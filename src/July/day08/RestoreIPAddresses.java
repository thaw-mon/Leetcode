package July.day08;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：93. 复原IP地址
 * @题目描述： 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * @Date: 19/7/10
 * @示例 1: 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * @示例 2: ####
 **/
public class RestoreIPAddresses {

    //易错s  "010010"  ==>某个段为0时只能存在一个0 不能是00  01之类的
    public static void main(String[] args) {
        String s = "010010";
        List<String> ans = new RestoreIPAddresses().restoreIpAddresses(s);
        System.out.println(ans);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder ans = new StringBuilder(s);
        ipAddress(ans, 0, 0, res);
        return res;
    }

    //ans初始为s
    private void ipAddress(StringBuilder ans, int k, int l, List<String> res) {
        if (l == 3) {
            if(ans.length() - k != 1 && ans.charAt(k)=='0')
                return;
            if (ans.length() - k <= 3 && Integer.parseInt(ans.substring(k)) <= 255) {
                res.add(new String(ans.toString()));
            }
            return;
        }
        for (int i = k + 1; i < ans.length(); i++) {
            if (i - k > 3 || Integer.parseInt(ans.substring(k, i)) > 255)
                break;
            if (i - k != 1 && ans.charAt(k) == '0')
                continue;
            ans.insert(i, ".");
            ipAddress(ans, i + 1, l + 1, res);
            ans.deleteCharAt(i);
        }
    }
}
