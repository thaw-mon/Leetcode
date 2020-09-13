package Year2020.February.day02;

public class Demo03 {

    /**
     * @title :
     * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，
     * 我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
     * 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
     * 思路是使用BFS
     * @param A
     * @param B
     * @return A 和 B 的相似度 K 的最小值。
     */
    public int kSimilarity(String A, String B) {
        int ret = 0;
        int n = A.length();
        char[] arr = A.toCharArray();
        //TODO 需要BFS获取最优解，否则返回的结果不一定是最优解的
        for(int i=0;i<n;i++){
            char tmp = B.charAt(i);
            //判断B当前位置字符是否和A相同
            if(tmp != arr[i]){
                //找到和tmp相同的字符的位置并进行交换
                int j=i;
                for(;j<n;j++){
                    if(arr[j]==tmp && arr[j] != B.charAt(j)) break;
                }
                // i 和 j 进行交换
                arr[j] = arr[i];
                arr[i] = tmp;
                ret++;
            }
        }
        return ret;
    }
}
