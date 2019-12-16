package November.day10;

import java.util.Stack;

/**
 * @题目 ： 388. Longest Absolute File Path
 * @Data 19/11/29
 * @题目描述： 略
 * @题目链接： 链接：https://leetcode-cn.com/problems/longest-absolute-file-path/
 * @示例1: ######
 * @示例2: ######
 * @示例3: ###
 */

public class LongestAbsoluteFilePath {

    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(new LongestAbsoluteFilePath().lengthLongestPath(s));
    }

    //寻找文件系统中文件的最长 (按字符的数量统计) 绝对路径。
    //很明显的树形结构：注意空目录不算文件
    //\n是上一级的兄弟节点
    //\n(\t)* 表示是几级目录
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) == '\n') {
                //计算当前为几级目录：计算下面\t的数量
                int j = i;
                int count = 0;
                while (j < input.length() && (input.charAt(j) == '\n' || input.charAt(j) == '\t')) {
                    count++;
                    j++;
                }
                while (count < stack.size()) {
                    stack.pop();
                }
                i = j;  //指向字符

            } else {
                //当前为路径字符:找到路径的终点
                boolean flag = false;  //判断最后是路径还是文件
                int j = i;
                //最后j指向下一个 \
                while (j < input.length() && input.charAt(j) != '\n') {
                    if (input.charAt(j) == '.')
                        flag = true;
                    j++;
                }
                //如果是文件：计算总长度
                if (flag) {
                    int len = j - i + stack.peek();
                    res = Math.max(len, res);
                } else {
                    //如果是目录(+1是计算目录中的\)
                    int len = j - i + 1;
                    len += stack.peek();
                    stack.push(len);
                }
                i = j;
            }
        }
        System.out.println(input.length());
        System.out.println(res);
        return res;
    }
}
