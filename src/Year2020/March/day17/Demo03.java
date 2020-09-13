package Year2020.March.day17;

public class Demo03 {

    /**
     * 比较两个版本号 version1 和 version2。
     * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        //比较两个 版本号大小
        //1.分割
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int ret = 0;
        int n = Math.max(arr1.length, arr2.length);
        //进行比较
        for (int i = 0; i < n; i++) {
            int n1 = i < arr1.length ? Integer.parseInt(arr1[i]) : 0;
            int n2 = i < arr2.length ? Integer.parseInt(arr2[i]) : 0;
            if (n1 != n2) {
                ret = n1 > n2 ? 1 : -1;
                break;
            }
        }
        return ret;
    }

    public  static void main(String[] args){
        String s1 = "0.1";
        String s2 = "1.1";
        System.out.println(new Demo03().compareVersion(s1,s2));
    }
}
