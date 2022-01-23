package leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class P1185_U {
    public static void main(String[] args) {
        // 这个方法是不行的，因为在day/month是个位数的时候是没有办法使用simpleDateFormat的；
        System.out.println(dayOfTheWeek(26, 12, 2021));
    }
    public String dayOfTheWeekSucces(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year,month,day);
        String [] ss = {null, "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
        return ss[localDate.getDayOfWeek().getValue()];
    }
    public static String dayOfTheWeek(int day, int month, int year) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String str = year + "" + month + "" + day;
        Calendar c = Calendar.getInstance();
        String[] weeks = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Date parse = null;
        try {
            parse = sdf.parse(str);
            c.setTime(parse);
            System.out.println(parse.toString());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = c.get(Calendar.DAY_OF_WEEK) - 1;
        /*if (w<0){
            w=0;
        }*/
        return weeks[w];
    }
}
