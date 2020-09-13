package Year2020.March.day03;

import java.util.Deque;
import java.util.LinkedList;

public class Demo03 {

    public static void main(String[] args){
        String str = "/a/./b/../../c/";
        System.out.println(new Demo03().simplifyPath(str));
    }
    /**
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
     * @param path
     * @return
     */
    public String simplifyPath(String path) {

        Deque<String> pathQueue = new LinkedList<>();
        String[] paths = path.split("/");
        for(String tmp : paths){

            if(tmp.equals("..")){
                if(!pathQueue.isEmpty())
                    pathQueue.pollLast();
            }else if(!tmp.equals(".") && !tmp.isEmpty()){
                pathQueue.addLast(tmp);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pathQueue.isEmpty()){
            String tmp = pathQueue.getFirst();
            sb.append("/").append(tmp);
            pathQueue.pollFirst();
        }
        String ret = sb.toString();
        if(ret.isEmpty()) sb.append("/");
        ret = sb.toString();
        return ret;
    }
}
