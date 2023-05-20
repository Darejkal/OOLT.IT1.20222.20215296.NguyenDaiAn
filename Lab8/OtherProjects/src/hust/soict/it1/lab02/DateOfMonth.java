package hust.soict.it1.lab02;
// Exercise 5
import javax.swing.JOptionPane;
public class DateOfMonth {
    final static int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 29 };
    public static void main(String[] args){
        boolean flag=false;
        int month=1,year=1;
        while(true){
            try{
            month=Integer.parseInt(JOptionPane.showInputDialog(null, (flag?"Input error\n":"")+"Input the number representation of the month"+(flag?" again ":"")+":\n(For example: January = 1)"));
            if(month>12||month<1){
                flag=true;
            } else {
                break;
            }
            } catch(Exception e){
                flag=true;
            }
        }
        flag=false;
        while(true){
            try{
            year=Integer.parseInt(JOptionPane.showInputDialog(null, (flag?"Input error\n":"")+"Input the year"+(flag?" again ":"")+":"));
            if(year<0){
                flag=true;
            } else {
                break;
            }
            } catch(Exception e){
                flag=true;
            }
        }
        int result=days[month-1];
        if(month==2&&year%4==0){
            result=29;
        }
        JOptionPane.showMessageDialog(null, String.format("The number of days of the inputed month is %d.", result), "Result", JOptionPane.INFORMATION_MESSAGE);

    }
}
