package July.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @题目 ：71. 简化路径
 * @题目描述： 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * @Date:19/7/3
 * @示例 1: 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 **/
public class SimplifyPath {

    public static void main(String[] argv){
        String path = "/a/./b/../../c/";
        System.out.println(new SimplifyPath().simplifyPath(path));
    }

    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();
        int n = path.length();
        int i = 0;
        while (i < n) {
            StringBuilder str = new StringBuilder();
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') {
                str.append(path.charAt(j));
                j++;
            }
            // str为非/字符
            if (str.length() != 0) {
                if (str.toString().equals("..")) {
                    if (!list.isEmpty())
                        list.remove(list.size() - 1);
                } else if (!str.toString().equals(".")) {
                    list.add(str.toString());
                }
            }
            i = j;
        }
        //把list输出
        StringBuilder res = new StringBuilder("");
        for (String str : list) {
            res.append("/").append(str);
        }
        if (list.isEmpty()) {
            res.append("/");
        }
        return res.toString();
    }
}
