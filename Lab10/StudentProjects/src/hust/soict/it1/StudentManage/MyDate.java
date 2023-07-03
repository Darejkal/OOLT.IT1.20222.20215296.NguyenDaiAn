package hust.soict.it1.StudentManage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class MyDate {
    private int day = 1;
    private int month = 1;
    private int year = 1970;
    private boolean isSet = false;

    private static boolean isLeapYear(int year) {
    	return ((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0));
    }
    private static int getLastDay(int month, int year) {
	final int daysOfMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 29 };
	if (isLeapYear(year) && month == 2)
	    month = 13;
	return daysOfMonth[month-1];
    }
    private static boolean isValidDay(int day, int month, int year) {
	if (day > getLastDay(month, year))
	    return false;
	return true;
    }
    private void setDefaultDate() {
	LocalDate currentDate = LocalDate.now();
	setYear(currentDate.getYear());
	setMonth(currentDate.getMonthValue());
	setDay(currentDate.getDayOfMonth());
	isSet = true;
    }
    public MyDate() {
    	setDefaultDate();
    }
    public MyDate(int day, int month, int year) {
	setDay(day);
	setMonth(month);
	setYear(year);
	isSet = true;
    }
    public MyDate(String strDate) {
    	setDateFromString(strDate);
    }
    public void print() {
    	if (isSet)
	    System.out.println("Date is: " + day + "/" + month + "/" + year);
	else
	    System.out.println("Date is not set");
    }
    public void setDateFromString(String input) {
    	final String formats[] = {
	    "yyyy,L,dd",
	    "yyyy-L-dd",
	    "yyyy/L/dd", 
	    "dd,L,yyyy",
	    "dd,L,yy",
	    "dd-L-yyyy",
	    "dd-L-yy",
	    "dd/L/yyyy", 
	    "dd/L/yy", 
	};
    	String strDate = input.replaceAll(" ", "");
    	LocalDate date = null;
    	for (String format : formats) {
    	    try {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		date = LocalDate.parse(strDate, formatter);
		break;
	    } catch (Exception e) {
	    	continue;
	    }
	}
	if (date != null) {
	    setDay(date.getDayOfMonth());
	    setMonth(date.getMonthValue());
	    setYear(date.getYear());
	    isSet = true;
	} else 
	    System.out.println("Not a valid date string");
    }
    public int getDay() {
    	return day;
    }
    public void setDay(int day) {
    	if (day < 1 || day > 31) {
	    System.out.println("Day " + day + " not valid day"); 
	    return;
	}
    	if (isValidDay(day, month, year))
	    this.day = day;
	else
	    System.out.println("Month " + month + " of year " + year + " not have day " + day + ", not setting day");
    }
    public int getMonth() {
    	return month;
    }
    public void setMonth(int month) {
    	if (month < 1 || month > 12) {
	    System.out.println("Month " + day + " not valid month"); 
	    return;
	}
	this.month = month;
	isSet = true;
	if (!isValidDay(day, month, year)) {
	    int newday = getLastDay(month, year);
	    this.day = newday;
	    System.out.println("Month " + month + " of year " + year + " not have day " + day + ", setting day to " + newday);
	}
    } 
    public int getYear() {
    	return year;
    }
    public void setYear(int year) {
	this.year = year;
	isSet = true;
    	if (!isValidDay(day, month, year)) {
	    int newday = getLastDay(month, year);
	    this.day = newday;
	    System.out.println("Month " + month + " of year " + year + " not have day " + day + ", setting day to " + newday);
	}
    }
    public boolean isValid() { return isSet; }
}
