package Year2020.September.day11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo07 {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
     * 请对此链表进行深拷贝，并返回拷贝后的头结点。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null) return null;
        //使用map记录新建的node
        Map<Integer, RandomListNode> nodeMap = new HashMap<>();
        RandomListNode p = pHead;
        RandomListNode head = new RandomListNode(p.label);
        nodeMap.put(p.label, head);
        RandomListNode h = head;
        while (p != null) {
            //链接next节点和random节点
            if (p.next != null) {
                if (nodeMap.containsKey(p.next.label)) {
                    h.next = nodeMap.get(p.next.label);
                } else {
                    h.next = new RandomListNode(p.next.label);
                    nodeMap.put(p.next.label, h.next);
                }
            }
            if (p.random != null) {
                if (nodeMap.containsKey(p.random.label)) {
                    h.random = nodeMap.get(p.random.label);
                } else {
                    h.random = new RandomListNode(p.random.label);
                    nodeMap.put(p.random.label, h.random);
                }
            }
            p = p.next;
            h = h.next;
        }
        return head;
    }
}
