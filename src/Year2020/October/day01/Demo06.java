package Year2020.October.day01;

public class Demo06 {


    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
     * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     *
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        String[] array = str.split(" ");
        StringBuilder sb = new StringBuilder();
        int n = array.length - 1;
        if(n <= 0) return str;
        while (n >= 0) {
            sb.append(array[n--]).append(" ");
        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1); //删除多余的" ";
        return sb.toString();
    }
}
