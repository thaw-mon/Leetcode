package Year2019.November.day02;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @题目 ： 341. Flatten Nested List Iterator
 * @Data 19/11/09
 * @题目描述： Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * @示例1: ######
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,1,2,1,1].
 *
 * @示例2: ######
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,4,6].
 *
 * @示例3: ###
 */

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
public class NestedIterator implements Iterator<Integer> {
    //TODO 可以优化为队列之类的就不需要index作为索引
    private List<Integer> list;
    private int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>(getList(nestedList));
        index = 0;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return list.get(index++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    private List<Integer> getList(List<NestedInteger> nestedList){
        List<Integer> res = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                res.add(nestedInteger.getInteger());
            } else {
                //进入迭代
                res.addAll(getList(nestedInteger.getList()));
            }
        }
        return res;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */