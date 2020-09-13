package Year2019.October.day02;

import java.util.*;


/**
 * @题目 ： 295. Find Median from Data Stream
 * @Data 19/10/03
 * @题目描述： Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * For example,
 * [2,3,4], the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * @题目地址： 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * @示例1: ######
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * @示例2: ###
 * @示例3: ###
 */


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class MedianFinder {

    /**
     * initialize your data structure here.
     */
    private PriorityQueue<Integer> minHeap;//小根堆
    private PriorityQueue<Integer> maxHeap;//大根堆

    private int lenMin;
    private int lenMax;
    private int minValue;
    private int maxValue;


    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        lenMin = 0;
        lenMax = 0;
        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;
    }

    //大根堆存储前(n+1)/2 个数字 小根堆存储后n/2个数字
    //同时要保证大根堆的数字小于等于小根堆的数字
    public void addNum(int num) {
        if (lenMin >= lenMax) {
            lenMax++;
            maxHeap.add(num);
            maxValue = maxHeap.peek();
        } else {
            lenMin++;
            minHeap.add(num);
            minValue = minHeap.peek();
        }

        while (maxValue > minValue) {
            //heap top数字交换
            maxHeap.poll();
            maxHeap.add(minValue);
            minHeap.poll();
            minHeap.add(maxValue);
            //再次获取值
            maxValue = maxHeap.peek();
            minValue = minHeap.peek();
        }


    }

    public double findMedian() {

        if (lenMax == lenMin) {
            return (maxValue + minValue) / 2.0;
        }
        return maxValue;
    }


}
