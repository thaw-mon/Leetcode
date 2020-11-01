package Year2020.October.day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo05 {


    public static void main(String[] args) throws IOException {
        Demo05 demo05 = new Demo05();
//        Scanner scanner = new Scanner(System.in);
        File file = new File("src/Year2020/October/day11/exp05_01");
        System.out.println(file.getCanonicalPath());
        Scanner scanner = new Scanner(file);
        List<String> IpList = new ArrayList<>();
        List<String> mask = new ArrayList<>();
        while (scanner.hasNext()) {
            String str = scanner.next();
            String[] arr = str.split("~");
            IpList.add(arr[0]);
            mask.add(arr[1]);
            //demo05.countIp2(IpList, mask);
        }
        //71 41 21 12 10 68 1
        demo05.countIp2(IpList, mask);
    }

    /**
     * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
     * 所有的IP地址划分为 A,B,C,D,E五类
     * <p>
     * A类地址1.0.0.0~126.255.255.255;
     * B类地址128.0.0.0~191.255.255.255;
     * C类地址192.0.0.0~223.255.255.255;
     * D类地址224.0.0.0~239.255.255.255；
     * E类地址240.0.0.0~255.255.255.255
     * 私网IP范围是：
     * <p>
     * 10.0.0.0～10.255.255.255
     * 172.16.0.0～172.31.255.255
     * 192.168.0.0～192.168.255.255
     * <p>
     * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
     */

    //统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
    //注意：10.70.44.68~255.254.255.0 只能在错误的IP或掩码加一而不是 A类IP +1,私有IP+1和错误掩码+1
    public void countIp(List<String> IpList, List<String> mask) {
        int[] count = new int[7];
        //1.首先判定IP
        for (String ip : IpList) {
            if (!isValidIp(ip)) {
                count[5]++;
                continue;
            }
            //判定Ip类型 A-E
            int type = getIpType(ip);

            if (type > 0) count[type - 1]++;
            if (isPrivateIP(ip)) count[6]++;
        }
        //然后判定Mask
        for (String m : mask) {
            if (!isValidMask(m)) count[5]++;
        }
        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                System.out.println(count[i]);
            } else
                System.out.print(count[i] + " ");
        }
    }

    public void countIp2(List<String> IpList, List<String> mask) {
        int[] count = new int[7];
        int N = IpList.size();
        //1.首先判定IP和掩码的有效性
        for (int i = 0; i < N; i++) {
            String ip = IpList.get(i);
            String m = mask.get(i);
            if (!isValidIp(ip) || !isValidMask(m)) {
                count[5]++;
                continue;
            }
            //判定Ip类型 A-E
            int type = getIpType(ip);
           /* if(type == 1){
                System.out.println(ip + "~" + m);
            }*/
            if (type > 0) count[type - 1]++;
            if (isPrivateIP(ip)) count[6]++;
        }

        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                System.out.println(count[i]);
            } else
                System.out.print(count[i] + " ");
        }

    }

    //
    private boolean isValidIp(String ip) {
        String[] array = ip.split("\\.");
        if (!ip.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) return false;
        //判定每个数字是否在[0-255]
        for (String s : array) {
            if (Integer.parseInt(s) > 255) return false;
        }
        return true;
    }

    //5类类型

    /**
     * @param ip A类地址1.0.0.0~126.255.255.255;
     *           B类地址128.0.0.0~191.255.255.255;
     *           C类地址192.0.0.0~223.255.255.255;
     *           D类地址224.0.0.0~239.255.255.255；
     *           E类地址240.0.0.0~255.255.255.255
     * @return 0-5
     */
    private int getIpType(String ip) {
        String[] array = ip.split("\\.");
        int n1 = Integer.parseInt(array[0]);
        if (n1 >= 1 && n1 <= 126) return 1;
        if (n1 >= 128 && n1 <= 191) return 2;
        if (n1 >= 192 && n1 <= 223) return 3;
        if (n1 >= 224 && n1 <= 239) return 4;
        if (n1 >= 240 && n1 <= 255) return 5;
        return 0;
    }

    //判定是否为私有IP

    /**
     * 10.0.0.0～10.255.255.255
     * 172.16.0.0～172.31.255.255
     * 192.168.0.0～192.168.255.255
     *
     * @param ip
     * @return TRUE OR FALSE
     */
    private boolean isPrivateIP(String ip) {
        String[] array = ip.split("\\.");
        int n1 = Integer.parseInt(array[0]);
        if (n1 == 10) return true;
        int n2 = Integer.parseInt(array[1]);
        if (n1 == 172 && (n2 >= 16 && n2 <= 31)) return true;
        if (n1 == 192 && n2 == 168) return true;
        return false;
    }

    //注意二进制下全是1或者全是0均为非法
    private boolean isValidMask(String mask) {
        String[] array = mask.split("\\.");
        if (!mask.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) return false;
        boolean flag = true; //前面全是1,h后面全是0
        boolean isOne = true;
        int countOne = 0;
        for (int i = 3; i >= 0; i--) {
            int value = Integer.parseInt(array[i]);
            if (value > 255) {
                flag = false;
                break;
            }
            value ^= 0xFF; //异或操作使得 11110000--> 00001111
            if (value == 0) isOne = false;
         /*   for (int j = 0; j < 8; j++) {
                if ((value & 0x01) == 0)
                    isOne = false;
                else
                    countOne++;
                value >>>= 1;
            }*/
            while (value > 0 && isOne) {
                if ((value & 0x01) == 0)
                    isOne = false;
                else
                    countOne++;
                value >>>= 1;
            }
            if(countOne % 8 > 0) isOne = false; // 00011111类型退出了
            if (value > 0) {
                flag = false;
                break;
            }

        }
        if (flag && (countOne == 0 || countOne == 32)) flag = false;
        return flag;
    }
}


