package October.day11;

import java.util.*;

/**
 * @题目 ： 332. Reconstruct Itinerary
 * @Data 19/10/24
 * @题目描述： Given a list of airline tickets represented by pairs of departure and arrival airports {from, to}, reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary {"JFK", "LGA"} has a smaller lexical order than {"JFK", "LGB"}.
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * @题目链接： 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * @示例1: ######
 * Input: {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}
 * Output: {"JFK", "MUC", "LHR", "SFO", "SJC"}
 * @示例2: ######
 * Input: {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}}
 * Output: {"JFK","ATL","JFK","SFO","ATL","SFO"}
 * Explanation: Another possible reconstruction is {"JFK","SFO","ATL","JFK","ATL","SFO"}.
 *              But it is larger in lexical order.
 * @示例3: ###
 */


public class ReconstructItinerary {

    public static void main(String[] args) {


        List<List<String>> tickets = new ArrayList<>();
        // = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        String[][] cc = {{"EZE", "AXA"}, {"TIA", "ANU"}, {"ANU", "JFK"}, {"JFK", "ANU"}, {"ANU", "EZE"}, {"TIA", "ANU"}, {"AXA", "TIA"}, {"TIA", "JFK"}, {"ANU", "TIA"}, {"JFK", "TIA"}};
        for (int i = 0; i < cc.length; i++)
            tickets.add(Arrays.asList(cc[i]));

        System.out.println(new ReconstructItinerary().findItinerary(tickets));
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        //注意：这里不能使用set,因为会有重复的字段
        Map<String, List<String>> iMap = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            if (!iMap.containsKey(tickets.get(i).get(0))) {
                iMap.put(tickets.get(i).get(0), new LinkedList<>());
            }
            iMap.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }

        //对iMap的value排个序
        for (String key : iMap.keySet()) {
            Collections.sort(iMap.get(key));
        }
        //从JFK开始
        List<String> res = new ArrayList<>();
        //不能直接向前遍历（可能陷入死循环），需要进行DFS
        DFS(iMap,"JFK", res);
        return res;
    }

    //DFS + 回溯 -->关键在于线找不到的路径放在最后面
    // 逆序插入
    private void DFS(Map<String, List<String>> iMap,String src, List<String> res) {
        while (iMap.containsKey(src) && iMap.get(src).size() > 0){
            String value = iMap.get(src).get(0);
            iMap.get(src).remove(0);
            DFS(iMap,value,res);
        }
        res.add(0,src);
    }


    //大佬的迭代写法 + 优先队列
//    作者：pwrliang
//    链接：https://leetcode-cn.com/problems/reconstruct-itinerary/solution/javadfsjie-fa-by-pwrliang/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<String> findItinerary2(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();

        if (tickets == null || tickets.size() == 0)
            return ans;

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            PriorityQueue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            nbr.add(pair.get(1));
        }

        // 按目的顶点排序

        visit(graph, "JFK", ans);

        return ans;
    }

    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {

        Stack<String> stack = new Stack<>();

        stack.push(src);

        while (!stack.isEmpty()) {
            PriorityQueue<String> nbr;

            while ((nbr = graph.get(stack.peek())) != null &&
                    nbr.size() > 0) {
                stack.push(nbr.poll());
            }
            ans.add(0, stack.pop());
        }
    }


}
