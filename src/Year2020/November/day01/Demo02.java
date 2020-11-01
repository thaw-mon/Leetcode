package Year2020.November.day01;

import java.util.Scanner;

public class Demo02 {

    public static void main(String[] args){
        Demo02 demo02 = new Demo02();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
           String mask = scanner.next();
           String ip1 = scanner.next();
           String ip2 = scanner.next();
            System.out.println(demo02.checkNetSegment(mask,ip1,ip2));
        }
        scanner.close();
    }
    /**
     * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
     * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。
     * 利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
     */

    public int checkNetSegment(String mask, String ip1, String ip2) {
        //ip和mask有效性判定
        if (!isValidMask(mask) || !isValidIp(ip1) || !isValidIp(ip2)) {
            return 1;
        }
        String[] maskArray = mask.split("\\.");
        String[] ip1Array = ip1.split("\\.");
        String[] ip2Array = ip2.split("\\.");
        //ADD 首先要判定IP和mask格式是否正确

        for (int i = 0; i < 4; i++) {
            int m = Integer.parseInt(maskArray[i]);
            int num1 = Integer.parseInt(ip1Array[i]);
            int num2 = Integer.parseInt(ip2Array[i]);
            if ((num1 & m) == (num2 & m)) {
                continue;
            }
            return 2;
        }
        return 0;
    }


    private boolean isValidIp(String ip) {
        String[] array = ip.split("\\.");
        if (!ip.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) return false;
        //判定每个数字是否在[0-255]
        for (String s : array) {
            if (Integer.parseInt(s) > 255) return false;
        }
        return true;
    }

    //注意二进制下全是1或者全是0均为非法 去掉
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
            while (value > 0 && isOne) {
                if ((value & 0x01) == 0)
                    isOne = false;
                else
                    countOne++;
                value >>>= 1;
            }
            if (countOne % 8 > 0) isOne = false; // 00011111类型退出了
            if (value > 0) {
                flag = false;
                break;
            }

        }
        //
        //  if (flag && (countOne == 0 || countOne == 32)) flag = false;
        return flag;
    }
}
