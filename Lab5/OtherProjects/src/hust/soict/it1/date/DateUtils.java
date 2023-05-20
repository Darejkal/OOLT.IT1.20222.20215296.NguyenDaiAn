package hust.soict.it1.date;
import java.util.Arrays;

public class DateUtils {
    static boolean isLater(MyDate a,MyDate b){
        return a.getYear()>b.getYear()||(a.getYear()==b.getYear()&&a.getMonth()>b.getMonth())||(a.getYear()==b.getYear()&&a.getMonth()==b.getMonth()&&a.getDay()>b.getDay());
    }
    static boolean isEqual(MyDate a,MyDate b){
        return a.getYear()==b.getYear()&&a.getMonth()==b.getMonth()&&a.getDay()==b.getDay();
    }
    static void sortDate(MyDate arr[]){
        Arrays.sort(arr, 0, arr.length, (a,b)->{return DateUtils.isLater(a, b)?1:0;});
    }
}
