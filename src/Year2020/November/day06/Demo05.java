package Year2020.November.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            executeCommand(command);
        }
    }

    /**
     * 有6条配置命令，它们执行的结果分别是：略
     * 多行字符串，每行字符串一条命令
     * 执行结果，每条命令输出一行
     */
    public static void executeCommand(String command) {
        String[] commands = {"reset", "reset board", "board add", "board delete", "reboot backplane", "backplane abort"};
        String[] results = {"reset what", "board fault", "where to add", "no board at all", "impossible", "install first", "unknown command"};
        String[] str = command.split(" ");
        if (str.length == 0 || str.length > 2) return;
        //匹配首字母
        if (str.length == 1) {
            if (commands[0].startsWith(str[0])) {
                System.out.println(results[0]);
            } else
                System.out.println(results[6]);
            return;
        }
        List<Integer> ret1 = new ArrayList<>();
        //第一轮字符匹配
        for (int i = 1; i < commands.length; i++) {
            String c = commands[i];
            if (c.startsWith(str[0])) {
                ret1.add(i);
            }
        }
        //第二轮字符匹配
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < ret1.size(); i++) {
            String c = commands[ret1.get(i)].split(" ")[1];
            if (c.startsWith(str[1])) {
                ret.add(results[ret1.get(i)]);
            }
        }
        if (ret.size() == 1) {
            System.out.println(ret.get(0));
        } else
            System.out.println(results[6]);

    }
}
