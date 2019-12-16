package September.day14;

/**
 * @题目 ： 278. First Bad Version
 * @Data 19/9/25
 * @题目描述： You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * @题目地址： 链接：https://leetcode-cn.com/problems/first-bad-version
 * @示例1: ######
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version. 
 * @示例2: ###
 * @示例3: ###
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        int n = 2126753390;
        System.out.println(new FirstBadVersion().firstBadVersion(n));
    }

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    //二分法查找第一个坏版本
    //二分法怎么会超时
    public int firstBadVersion(int n) {
        //
        int left = 1, right = n;
        int mid = 0;
        while (left < right) {
            //注意右边可能会导致溢出问题             mid = (left + right) / 2;
            mid = left + (right - left) / 2;
            //mid为 BadVersion
            if (isBadVersion(mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    boolean isBadVersion(int n) {
        return n >= 1702766719;
    }
}
