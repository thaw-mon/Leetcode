package Year2020.May.day02;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     */
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        dp(s, 0, new StringBuilder());
        return ret;
    }

    List<String> ret = new ArrayList<>();

    //注意 : 不能出现0.0.0.010情形
    private void dp(String s, int level, StringBuilder sb) {
        //IP分为4段
        if (level == 3) {
            if (!s.isEmpty() && s.length() <= 3 && Integer.parseInt(s) <= 255) {
                if (s.charAt(0) == '0' && s.length() > 1) {
                    return;
                }
                sb.append(s);
                ret.add(sb.toString());
            }
            return;
        }

        int num = 0, size = 0;
        for (int i = 0; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255)
                break;

            size = sb.length();
            sb.append(num).append(".");
            dp(s.substring(i + 1), level + 1, sb);
            sb.delete(size, sb.length());
            if (num == 0) {
                break;
            }
        }
    }
}
