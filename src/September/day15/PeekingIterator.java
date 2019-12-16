package September.day15;

import java.util.*;

/**
 * @题目 ： 284. Expression Add Operators
 * @Data 19/9/28
 * @题目描述： Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * @题目地址： 链接：https://leetcode-cn.com/problems/peeking-iterator
 * @示例1: ######
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 * <p>
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 * @示例2: ###
 * @示例3: ###
 */

public class PeekingIterator implements Iterator<Integer> {

    private Queue<Integer> nums;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        nums = new ArrayDeque<>();
        while (iterator.hasNext()) {
            nums.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nums.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return nums.poll();
    }

    @Override
    public boolean hasNext() {
        return !nums.isEmpty();
    }
}
