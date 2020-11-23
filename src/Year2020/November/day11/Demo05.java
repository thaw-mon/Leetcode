package Year2020.November.day11;

import java.util.*;

public class Demo05 {
    Set<String> candidateNames = new HashSet<>();
    Map<String, Integer> votes = new HashMap<>();

    /**
     * 功能：设置候选人姓名
     * 输入： char* pCandidateName 候选人姓名
     * 输出：无
     * 返回：输入值非法返回0，已经添加过返回0 ，添加成功返回1
     */
    public int AddCandidate(String pCandidateName) {
        if (candidateNames.contains(pCandidateName)) return 0;
        candidateNames.add(pCandidateName);
        return 1;
    }

    /**
     * 功能：投票
     * 输入： char* pCandidateName 候选人姓名
     * 输出：无
     * 返回：无
     */
    public void Vote(String pCandidateName) {
        votes.put(pCandidateName, votes.getOrDefault(pCandidateName, 0) + 1);
    }

    /**
     * 功能：获取候选人的票数。如果传入为空指针，返回无效的票数，同时说明本次投票活动结束，释放资源
     * 输入： char* pCandidateName 候选人姓名。当输入一个空指针时，返回无效的票数
     * <p>
     * 输出：无
     * 返回：该候选人获取的票数
     */
    int GetVoteResult(String pCandidateName) {
        if (pCandidateName == null) {

        }
        return votes.get(pCandidateName);
    }

    /**
     * // 功能：清除投票结果，释放所有资源
     * // 输入：
     * // 输出：无
     * // 返回
     */
    void Clear() {
        candidateNames.clear();
        votes.clear();
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //统计人头
            int n = scan.nextInt();
            LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();
            scan.nextLine();
            String str = scan.nextLine();
            String[] array = str.split(" ");
            for(int i=0;i<array.length;i++){
                map.put(array[i],0);
            }
            map.put("Invalid",0);
            //投票计数
            int m = scan.nextInt();
            scan.nextLine();
            String strr = scan.nextLine();
            String[] arrays = strr.split(" ");
            for(String s :arrays){
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else{
                    map.put("Invalid",map.get("Invalid")+1);
                }
            }
            Set<String> set = map.keySet();
            for(String s :set){
                System.out.println(s+" : "+map.get(s));

            }
        }
    }
}
