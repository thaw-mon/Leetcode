package Year2020.September.day07;

public class Demo01 {

    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0) {
            int x1 = x & 0x01;
            int y1 = y & 0x01;
            if ((x1 ^ y1) == 1) count++;
            x >>>= 1;
            y >>>= 1;
        }
        return count;
    }
}
