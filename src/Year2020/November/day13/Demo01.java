package Year2020.November.day13;

import java.io.*;
import java.util.*;

public class Demo01 {
    public Map<Integer, Integer> moneyMap;
    public Map<String, Integer> goodMap;
    public Map<String, Integer> goodPriceMap;
    public final int[] moneyType = {1, 2, 5, 10};
    public int currentMoney;

    public Demo01() {
        goodPriceMap = new HashMap<>();
        goodPriceMap.put("A1", 2);
        goodPriceMap.put("A2", 3);
        goodPriceMap.put("A3", 4);
        goodPriceMap.put("A4", 5);
        goodPriceMap.put("A5", 8);
        goodPriceMap.put("A6", 6);
        moneyMap = new HashMap<>();
        goodMap = new HashMap<>();
        currentMoney = 0;
    }

    /**
     * 1 总体说明
     * 考生需要模拟实现一个简单的自动售货系统，实现投币、购买商品、退币、查询库存商品及存钱盒信息的功能。
     * 系统初始化时自动售货机中商品为6种商品,商品的单价参见1.1规格说明，存钱盒内放置1元、2元、5元、10元钱币，商品数量和钱币张数通过初始化命令设置，参见2.1 系统初始化。
     */
    //TODO 坑1 测试集E010和E009后面没有回车
    // 坑2 ：投币余额没有限制
    // 坑3 ： 查询功能需要考虑到格式，如果存在空格导致格式不对，当error处理
    public static void main(String[] args) throws FileNotFoundException {
        Demo01 demo01 = new Demo01();
        Scanner scanner = new Scanner(new File("src/Year2020/November/day13/exp01_1"));
        System.setOut(new PrintStream(
                new FileOutputStream("src/Year2020/November/day13/exp01_01_test", false)
        ));

        while (scanner.hasNext()) {
            String str = scanner.nextLine(); //获取命令
            String[] command = str.split(";");
            for (String c : command) demo01.executeCommand(c);
        }
        scanner.close();
        //结果对比测试
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        Scanner scanner1 = new Scanner(new File("src/Year2020/November/day13/exp01_1_result"));
        Scanner scanner2 = new Scanner(new File("src/Year2020/November/day13/exp01_01_test"));
        int line = 1;
        while (scanner1.hasNext() && scanner2.hasNext()) {
            String result = scanner1.nextLine();
            String test = scanner2.nextLine();
            if (!result.equals(test)) {
                System.out.println("line" + line + "result = " + result + "; test = " + test);
            }
            line++;
        }

    }

    public void executeCommand(String command) {
        //1.判断首字母
        assert command.length() > 0;
        char c = command.charAt(0);
        switch (c) {
            case 'r': { //初始化
                //r 6-5-4-3-2-1 4-3-2-1
                String[] str = command.split("\\s");
                assert str.length == 3;
                int[] good = toIntegerArray(str[1]);
                int[] moneys = toIntegerArray(str[2]);
                initSaleSystem(good, moneys);
                break;
            }
            case 'p': {
                //p 10;
                String[] str = command.split("\\s");
                assert str.length == 2;
                int coin = Integer.parseInt(str[1]);
                insertCoin(coin);
                break;
            }
            case 'b': {
                String[] str = command.split("\\s");
                assert str.length == 2;
                buyGoods(str[1]);
                break;
            }
            case 'c': {
                backMoney();
                break;
            }
            case 'q': {
                String[] str = command.split("\\s");
                if (str.length == 2) {
                    query(Integer.parseInt(str[1]));
                } else {
                    System.out.print("E010:Parameter error");
                }
                break;
            }
            default:
                System.out.println("error command");

        }
    }

    private int[] toIntegerArray(String str) {
        String[] arr = str.split("-");
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = Integer.parseInt(arr[i]);
        }
        return ret;
    }

    //5. 查询
    //(0) 类别 : 0  查询商品信息  1    查询存钱盒信息
    //(1) 查询自动售货机中商品信息，包含商品名称、单价、数量。
    // 根据商品数量从大到小进行排序；商品数量相同时，按照商品名称的先后顺序进行排序 。
    // （2） 查询存钱盒信息，包含各种面额钱币的张数；
    public void query(int type) {
        switch (type) {
            case 0:
                printGoodInfo();
                break;
            case 1:
                printMoneyBoxInfo();
                break;
            default:
                System.out.print("E010:Parameter error");
                break;
        }
    }

    private void printGoodInfo() {
        Map<Integer, List<String>> sortMap = new TreeMap<>();
        for (String key : goodMap.keySet()) {
            int value = goodMap.get(key);
            if (!sortMap.containsKey(value)) sortMap.put(value, new ArrayList<>());
            sortMap.get(value).add(key);
        }
        //打印结果
        for (int key : sortMap.keySet()) {
            List<String> values = sortMap.get(key);
            for (String value : values) {
                System.out.println(value + " " + goodPriceMap.get(value) + " " + key);
            }
        }
    }

    private void printMoneyBoxInfo() {
        for (int i = 0; i < moneyType.length; i++) {
            //1 yuan coin number=4
            System.out.printf("%d yuan coin number=%d\n", moneyType[i], moneyMap.get(moneyType[i]));
        }
    }

    //1 系统初始化
    public void initSaleSystem(int[] goods, int[] moneys) {
        moneyMap.clear();
        assert moneyType.length == moneys.length;
        //初始化moneyMap数量
        for (int i = 0; i < moneyType.length; i++) {
            moneyMap.put(moneyType[i], moneys[i]);
        }
        //初始化goodMap
        goodMap.clear();
        assert goods.length == 6;
        for (int i = 1; i <= goods.length; i++) {
            goodMap.put("A" + i, goods[i - 1]);
        }
        System.out.println("S001:Initialization is successful");
        currentMoney = 0;
    }

    //2 投币
    public int insertCoin(int coin) {
        if (!isValidCoin(coin)) {
            System.out.println("E002:Denomination error");
            return -1;
        }
        // 如果存钱盒中1元和2元面额钱币总额小于本次投入的钱币面额
        if (!containChange(coin)) {
            System.out.println("E003:Change is not enough, pay fail");
            return -2;
        }
        //如果自动售货机中商品全部销售完毕，投币失败
        if (!containGoods()) {
            System.out.println("E005:All the goods sold out");
            return -3;
        }
        currentMoney += coin;
        //把前加入Map中
        moneyMap.put(coin,moneyMap.get(coin) + 1);
        System.out.println("S002:Pay success,balance=" + currentMoney);
        return 0;
    }

    //3 购买商品
    public int buyGoods(String good) {
        if (!goodMap.containsKey(good)) {
            System.out.println("E006:Goods does not exist");
            return -1;
        }
        if (goodMap.get(good) == 0) {
            System.out.println("E007:The goods sold out");
            return -2;
        }
        if (goodPriceMap.get(good) > currentMoney) {
            System.out.println("E008:Lack of balance");
            return -3;
        }
        currentMoney -= goodPriceMap.get(good);
        goodMap.put(good, goodMap.get(good) - 1);
        System.out.println("S003:Buy success,balance=" + currentMoney);
        return 0;
    }

    //4 退币
    public int backMoney() {
        if (currentMoney <= 0) {
            System.out.print("E009:Work failure");
            return -1;
        }
        //退币原则 ：
        //1) 根据系统存钱盒内钱币的 信息 ，按钱币总张数最少的原则进行退币。
        //2) 如果因零钱不足导致不能退币，则尽最大可能退币，以减少用户损失。
        leftCoin = currentMoney;
        dp(currentMoney, new int[moneyType.length], moneyType.length - 1);
        for (int i = 0; i < backCoin.length; i++) {
            if (backCoin[i] > 0)
                moneyMap.put(moneyType[i], moneyMap.get(moneyType[i]) - backCoin[i]);
            System.out.printf("%d yuan coin number=%d\n", moneyType[i], backCoin[i]);
        }
        currentMoney = 0;
        //打印信息
        return 0;
    }

    int[] backCoin = new int[moneyType.length];
    int leftCoin;

    //eg 2*4 + 5*1  back 8 ==> 2*4 not 2+5
    private boolean dp(int money, int[] moneyNum, int index) {
        if (money == 0) { //完全退款情形
            for (int i = 0; i < moneyNum.length; i++) backCoin[i] = moneyNum[i];
            return true;
        }
        if (index < 0) {
            //如果因零钱不足导致不能退币，则尽最大可能退币，以减少用户损失。
            if (currentMoney < leftCoin) {
                leftCoin = currentMoney;
                for (int i = 0; i < moneyNum.length; i++) backCoin[i] = moneyNum[i];
            }
            return false;
        }
        for (int i = index; i >= 0; i--) {
            if (moneyMap.get(moneyType[i]) == 0 || money < moneyType[i]) continue;
            int k = Math.min(money / moneyType[i], moneyMap.get(moneyType[i]));
            money -= k * moneyType[i];
            moneyNum[i] += k;
            if (dp(money, moneyNum, index - 1)) return true;
            moneyNum[i] -= k;
        }
        //判断当前
        if (currentMoney < leftCoin) {
            leftCoin = currentMoney;
            for (int i = 0; i < moneyNum.length; i++) backCoin[i] = moneyNum[i];
        }
        return false;
    }


    private boolean isValidCoin(int coin) {
        boolean flag = false;
        for (int type : moneyType) {
            if (coin == type) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private boolean containChange(int coin) {
        if (coin == 1 || coin == 2) return true;
        int currentChange = moneyMap.get(1) + 2 * moneyMap.get(2);
        return currentChange >= coin;
    }

    private boolean containGoods() {
        boolean flag = false;
        for (String good : goodMap.keySet()) {
            if (goodMap.get(good) > 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
