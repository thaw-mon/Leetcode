package Year2020.March.day07;

import java.util.*;

public class Demo01 {

    /**
     * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
     */
    class MyCalendar {

        class Data {
            public int start;
            public int end;

            public Data(int _start, int _end) {
                start = _start;
                end = _end;
            }

        }

        ;
        int minStart, maxEnd;
        Set<Data> CalendarSet;

        //初始化
        public MyCalendar() {
            minStart = Integer.MAX_VALUE;
            maxEnd = Integer.MIN_VALUE;
            CalendarSet = new TreeSet<>(new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return o1.start - o2.start;
                }
            });
        }

        public boolean book(int start, int end) {
            //最左或最右的情形
            if (end <= minStart || start >= maxEnd) {
                minStart = Math.min(start,minStart);
                maxEnd = Math.max(end,maxEnd);
                CalendarSet.add(new Data(start, end));
                return true;
            }

            int preEnd = Integer.MIN_VALUE;
            boolean flag = false;
            for (Data data : CalendarSet) {
                //没有判断最后一个的情形(在前面增加了判定)
                if (start >= preEnd && end <= data.start) {
                    flag = true;
                    break;
                } else if (end <= data.start) {
                    //提前终止条件
                    break;
                }
                preEnd = data.end;
            }
            if(flag)
                CalendarSet.add(new Data(start, end));
            return flag;
        }
    }
}
