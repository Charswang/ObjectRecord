package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-7-5
 * 每日一题
 */
public class P729 {

}

class MyCalendar {

    List<int[]> books;

    public MyCalendar() {
        books = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] book : books) {
            int a = book[0];
            int b = book[1];
            if (a < end && b > start) {
                return false;
            }
        }
        books.add(new int[]{start, end});
        return true;
    }
}