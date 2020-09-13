package Year2020.March.day05;

public class Demo01 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int n = strs.length; //记录数组的长度
        if (n == 0) return "";
        boolean flag = true;
        for (int index = 0; index < strs[0].length(); index++) {
            char c = strs[0].charAt(index);
            for (int j = 1; j < n; j++) {
                if(index >= strs[j].length()) {
                    flag = false;
                    break;
                }
                char tmp = strs[j].charAt(index);
                //字符不匹配
                if(tmp != c){
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
            sb.append(c);
        }
        return sb.toString();
    }
}
