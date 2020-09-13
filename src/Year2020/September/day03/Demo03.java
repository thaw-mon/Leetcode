package Year2020.September.day03;

public class Demo03 {

    /**
     * 给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
     * <p>
     * 由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
     *
     * @param arr
     * @return
     */
    //结果超时了,不能使用两轮循环
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int count = 0;
        int baseMod = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < n; i++) {
            boolean isOdd = false; //默认为偶数
            for (int j = i; j < n; j++) {
                if (arr[j] % 2 == 0) { //当前为偶数
                    if (isOdd) count++;
                } else {
                    if (!isOdd) { //之前为偶数
                        count++;
                        isOdd = true;
                    } else {
                        isOdd = false;
                    }
                }
            }
            if (count > baseMod) count %= baseMod;
        }
        return count % baseMod;
    }

    public int numOfSubarrays2(int[] arr) {
        int n = arr.length;
        int count = 0, allCount = 0;
        int baseMod = (int) Math.pow(10, 9) + 7;
        boolean isOdd = false; //默认为偶数
        //1.获取一轮的结果
        for (int value : arr) {
            if (value % 2 == 0) { //当前为偶数
                if (isOdd) count++;
            } else {
                if (!isOdd) { //之前为偶数
                    count++;
                    isOdd = true;
                } else {
                    isOdd = false;
                }
            }
        }
        allCount += count;
        for (int j = 0; j < n; j++) {
            //根据上一轮的count获取该轮的count值
            //1.上一轮起始为奇数 这一轮奇数偶数互换 ,偶数顺延
            if (arr[j] % 2 > 0) {
                count = n - j - count;
            }
            allCount += count;
            allCount %= baseMod;
        }
        //
        return allCount % baseMod;
    }

    public static void main(String[] args) {
        int[] arr = {64, 69, 7, 78, 31, 83, 47, 84, 47, 6, 67};
        System.out.println(new Demo03().numOfSubarrays(arr));
    }
}
