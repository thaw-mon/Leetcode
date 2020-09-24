package Year2020.September.day15;

import java.util.*;

public class Demo02 {

    //1.创建一个节点树
    class Node {
        public String val;
        public List<Node> next;
        public Map<String, Node> map;

        public Node(String val) {
            this.val = val;
            next = new ArrayList<>();
            map = new TreeMap<>(); //因为要按照字典序打印
        }
    }

    public static void main(String[] args) {
        Demo02 demo02 = new Demo02();
        demo02.fileSystem();
    }

    public void fileSystem() {
        Scanner in = new Scanner(System.in);
        String[] ops = {"mkdir", "rm", "mv", "ls", "exit"};
        //创建一个头节点
        Node head = new Node(""); //头节点默认值为/
        boolean flag = false;
        while (true) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String op = in.next();
            switch (op) {
                case "mkdir":
                    String file = in.next();
                    mkdir(head, file);
                    break;
                case "rm":
                    String file2 = in.next();
                    rm(head, file2);
                    break;
                case "mv":
                    String src = in.next();
                    String dst = in.next();
                    mv(head, src, dst);
                    break;
                case "ls":
                    ls(head);
                case "exit":
                    flag = true;
                    break;
            }
            if (flag) break;
            //
            //String
        }
    }

    //add file op
    public void mkdir(Node head, String file) {
        //1.分割file
        String[] strs = file.split("/"); // 按照/分割字符 注意首字符为""
        Node p = head;
        for (int i = 1; i < strs.length; i++) {
            if (p.map.containsKey(strs[i])) {
                p = p.map.get(strs[i]);
            } else {
                //创建新的节点加入
                Node node = new Node(strs[i]);
                p.next.add(node);
                p.map.put(strs[i], node);
                p = node;
            }
        }
    }

    //删除操作
    public void rm(Node head, String file) {
        //1.分割file
        String[] strs = file.split("/"); // 按照/分割字符 注意首字符为""
        Node p = head, parent = null;
        for (int i = 1; i < strs.length; i++) {
            if (p.map.containsKey(strs[i])) {
                parent = p;
                p = p.map.get(strs[i]);
            } else {
                //删除不存在的文件路径
                //do nothing
                p = null;//p指向null指示节点不存在
                break;
            }
        }
        //p指向了要删除的节点
        if (p != null && parent != null) {
            //通过parent节点进行删除
            int len = parent.next.size();
            for (int i = 0; i < len; i++) {
                if (parent.next.get(i) == p) {
                    parent.map.remove(p.val);
                    parent.next.remove(p);
                }
            }
        }

    }


    public void mv(Node head, String file1, String file2) {
        //0.分割file
        String[] str1s = file1.split("/"); // 按照/分割字符 注意首字符为""
        String[] str2s = file2.split("/"); // 按照/分割字符 注意首字符为""
        Node p1 = head, p2 = head;
        boolean flag1 = true, flag2 = true;
        //1.判定源地址是否存在
        for (int i = 1; i < str1s.length - 1; i++) {
            if (p1.map.containsKey(str1s[i])) {
                p1 = p1.map.get(str1s[i]);
            } else {
                flag1 = false;
                break;
            }
        }
        if (!flag1) return; //源地址父目录不存在
        if (!p1.map.containsKey(str1s[str1s.length - 1])) return; //源文件不存在

        //2.判定目的地址是否存在,不存在则直接返回
        for (int i = 1; i < str2s.length - 1; i++) {
            if (p2.map.containsKey(str2s[i])) {
                p2 = p2.map.get(str2s[i]);
            } else {
                flag2 = false;
                break;
            }
        }
        if (!flag2) return; //目标地址父目录不存在
        //判定目的最后文件是否存在
        if (p2.map.containsKey(str2s[str2s.length - 1])) return;

        //判定是否互为祖先或者就是本身
        // p1 is parent p2 or self
        if (isParentNode(p1.map.get(str1s[str1s.length - 1]), p2)) {
            return;
        }
        //最后移动节点
        Node node = p1.map.get(str1s[str1s.length - 1]);
        p1.next.remove(node);
        p1.map.remove(str1s[str1s.length - 1]);
        node.val = str2s[str2s.length - 1];
        p2.next.add(node);
        p2.map.put(str2s[str2s.length - 1], node);
    }

    //判定parent是否为son的祖先节点(包括parent或本身)
    public boolean isParentNode(Node parent, Node son) {
        if (parent == son || parent.next.contains(son)) return true;
        for (Node p : parent.next) {
            if (isParentNode(p, son)) return true;
        }
        return false;
    }


    //按字典序打印路径,DFS
    public void ls(Node node) {
        //1.打印当前节点
        StringBuilder sb = new StringBuilder();
        print(node, sb);
    }

    //为了保存前面的路径
    private void print(Node root, StringBuilder path) {
        if (root.val.isEmpty()) {
            System.out.println("/");
        } else System.out.println(path + root.val);
        int oldLen = path.length();
        path.append(root.val).append('/');
        for (String s : root.map.keySet()) {
            print(root.map.get(s), path);
        }
        path.delete(oldLen, path.length());

    }
}
