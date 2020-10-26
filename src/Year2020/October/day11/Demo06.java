package Year2020.October.day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Demo06 {

    //垃圾题目：循环意思是重复出现的记录，顺序为第一次出现的顺序
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        //szxcdhlaytgj 636 1
        //arefkiz 645 1
        //jmfdahkeffyjjsf 648 2
        //jmfdahkeffyjjsf 645 1
        //qekvaxypemktyurn 633 1
        //maahmq 646 1
        //jmfdahkeffyjjsf 636 1
        //szxcdhlaytgj 642 1
        File file = new File("src/Year2020/October/day11/exp06_02");
        // System.out.println(file.getCanonicalPath());
        Scanner scanner = new Scanner(file);
        Demo06 demo6 = new Demo06();
        List<String> fileStr = new ArrayList<>();
        List<Integer> lineNum = new ArrayList<>();
        while (scanner.hasNext()) {
            fileStr.add(scanner.next());
            lineNum.add(scanner.nextInt());
        }
        //1.首先对fileStr进行重写获取文件名
        List<String> nameStr = demo6.getFileName(fileStr);
        //2.调用函数
        demo6.recordError(nameStr, lineNum);
    }

    public List<String> getFileName(List<String> fileStr) {
        List<String> ret = new ArrayList<>();
        for (String str : fileStr) {
            String[] arr = str.split("\\\\");
            String end = arr[arr.length - 1];
            if (end.length() > 16) {
                end = end.substring(end.length() - 16);
            }
            ret.add(end);
        }
        return ret;
    }

    /**
     * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
     * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。
     * 最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是”相同“的错误记录。
     * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
     * 3、 输入的文件可能带路径，记录文件名称不能带路径。
     */

    public void recordError(List<String> errorFile, List<Integer> errorLine) {
        Record preHead = new Record("", 0);
        Record tail = preHead;
        Map<String, Record> recordMap = new HashMap<>();
        //Map<Record,Record> preMap = new HashMap<>(); //记录节点的前驱节点
        int N = errorFile.size();
        for (int i = 0; i < N; i++) {
            Record result = recordMap.getOrDefault(errorFile.get(i) + errorLine.get(i), null);
            if (result == null) { //add new record;
                Record record = new Record(errorFile.get(i), errorLine.get(i));
                if (recordMap.size() == 8) {
                    //先删除头部元素
                    Record deleteRecord = preHead.next;
                    preHead.next = deleteRecord.next;
                    recordMap.remove(deleteRecord.getMap());
                }
                //把元素添加到末尾
                recordMap.put(record.getMap(), record);
                tail.next = record;
                tail = tail.next;
            } else {
                //对已有元素进行count ++
                result.count++;
                //元素移动到末尾
                if (result == tail) { //自身为尾部元素
                    continue;
                }
                //1.获取元素的前驱节点
                Record pre = preHead;
                while (pre.next != result) {
                    pre = pre.next;
                }
                //2.把元素移动到末尾
                pre.next = result.next;
                result.next = null;
                tail.next = result;
                tail = tail.next;
            }
        }

        //最后打印结果
        Record p = preHead.next;
        while (p != null) {
            System.out.println(p.toString());
            p = p.next;
        }

    }

    public void recordError2(List<String> errorFile, List<Integer> errorLine) {
        //直接使用linkedHashMap保持数据
        int N = errorFile.size();
        Map<String, Record> recordMap = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            Record result = recordMap.getOrDefault(errorFile.get(i) + errorLine.get(i), null);
            if (result == null) {
                Record record = new Record(errorFile.get(i), errorLine.get(i));
                recordMap.put(errorFile.get(i) + errorLine.get(i), record);
            } else {
                result.count++;
            }
        }
        //遍历
        int cnt = 0;
        for (Map.Entry<String, Record> it : recordMap.entrySet()) {
            if (recordMap.size() - cnt <= 8)
                System.out.println(it.getValue().toString());
            cnt++;
        }
    }

    class Record {
        private String file;
        private int lineNum;
        public int count;
        public Record next;

        public Record(String file, int num) {
            this.file = file;
            lineNum = num;
            count = 1; //默认为1
            next = null;
        }

        public String getMap() {
            return file + lineNum;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public int getLineNum() {
            return lineNum;
        }

        public void setLineNum(int lineNum) {
            this.lineNum = lineNum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Record record = (Record) o;

            if (lineNum != record.lineNum) return false;
            return file != null ? file.equals(record.file) : record.file == null;
        }

        @Override
        public int hashCode() {
            int result = file != null ? file.hashCode() : 0;
            result = 31 * result + lineNum;
            return result;
        }

        @Override
        public String toString() {
            return file + " " + lineNum + " " + count;
        }
    }
}
