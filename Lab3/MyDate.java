import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

public class MyDate {
    public static void main(String args[]){
        MyDate a=new MyDate();
        a.print();
        a=new MyDate(2023,4,17);
        a.print();
        a=new MyDate("April 17th 2023");
        a.print();
        a.setDate("April 16th 2023");
        a.print();
        System.out.println("Input a date: (January 1st 2023)");
        a.accept();
        System.out.println("The date inputed is: ");
        a.print();
    }
    private final static String MONTHS[]={"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day >= 0 && day <= YearMonth.of(year, month).lengthOfMonth()) {
            this.day=day;
            return;
        }
        System.out.println("Invalid day inserted. Please remember to update the year before in the case of leap year.");
        throw new Error();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month=month;
            return;
        }
        System.out.println("Invalid month inserted.");
        throw new Error();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year<1970){
            System.out.println("Sorry, cannot support year before the standard base time (1970).");
            throw new Error();
        }
        this.year=year;
    }

    MyDate() {
        LocalDate date = (new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        setYear(date.getYear());
        setMonth(date.getMonthValue());
        setDay(date.getDayOfMonth()+1);
    }

    MyDate(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);

    }
    void setDate(String dateString){
        String dS[]=dateString.split(" ");
        try{
            if(dS.length!=3){
                throw new Exception();
            }
            dS[1]=dS[1].substring(0, dS[1].length() - 2);
            dS[0]=dS[0].toLowerCase();
            setYear(Integer.valueOf(dS[2]));

            this.month=-1;
            for(int i=0;i<12;i++){
                if(MONTHS[i].equals(dS[0])){
                    setMonth(i+1);
                    break;
                }
            }
            if(this.month==-1){
                throw new Exception();
            }
            setDay(Integer.valueOf(dS[1]));
        } catch(Exception e){
            System.out.println("Invalid dateString");
            throw new Error();
        }
    }
    
    MyDate(String dateString) {
        setDate(dateString);
    }
    void accept(){
        try{
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in)); 
            String dateString=obj.readLine();
            setDate(dateString);
        } catch(Exception e){
            System.out.println("Invalid input");
            throw new Error();
        }
    }
    void print(){
        System.out.println((LocalDate.of(year, month, day)).toString());
    }
}
