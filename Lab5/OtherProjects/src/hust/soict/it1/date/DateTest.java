package hust.soict.it1.date;
public class DateTest {
    public static void main(String[] args) {
        System.out.println("Testing: date constructor");
        System.out.println("Default constructor");
        MyDate currentDate = new MyDate();
        currentDate.print();
        System.out.println("Three paramater constructors");
        MyDate customDate1 = new MyDate(2023, 4, 15);
        customDate1.print();
        System.out.println("String paramater constructor");
        MyDate customDate2 = new MyDate("February 2nd 1999");
        customDate2.print();
        System.out.println("Testing: date getter/setter");
        System.out.println("Set date to 21 Mar 2021 from numeric value");
        customDate1.setDay(21);
        customDate1.setMonth(3);
        customDate1.setYear(2021);
        customDate1.print();
        System.out.println("Set date to 27 April 2021 from string");
        customDate1.setDay("twenty seventh");
        customDate1.setMonth("April");
        customDate1.setYear("twenty twenty one");
        customDate1.print();
        try{
            System.out.println("Testing: invalid date");
            System.out.println("set day to 31 (31 Apr 2022)");
            customDate2.setDay(31);
            customDate2.print();
        } catch(Throwable e){
            if(e.getMessage()!=null){
                System.out.println(e.getMessage());
            } else {
                System.out.println("Error received without message");
            }
        }
        try{
            System.out.println("Set month to Feb (29 Feb 2022)");
            customDate2.setMonth(2);
            customDate2.print();
        } catch(Throwable e){
            if(e.getMessage()!=null){
                System.out.println(e.getMessage());
            } else {
                System.out.println("Error received without message");
            }
        }

        System.out.println("Testing: user input date (skipped)");
        // System.out.println("please input a date in yyyy-MM-dd or dd-MM-yyyy
        // format.");
        // customDate1.accept();
        // customDate1.print();
        System.out.println("Testing: print date custom format (yyyy-MM-dd)");
        customDate1.print("yyyy-MM-dd");
        System.out.println("Testing: dateutil compare 27 april 2021 and 21 march 2022");
        customDate2.setDay(21);
        customDate2.setMonth(3);
        customDate2.setYear(2022);
        if (DateUtils.isLater(customDate1, customDate2)) {
            System.out.println("date1 isLater than date2 => incorrect answer");

        } else if (DateUtils.isEqual(customDate1, customDate2)) {
            System.out.println("date1 isEqual than date2 => incorrect answer");
        } else {
            System.out.println("date1 isEarlier than date2 => correct answer");

        }
        MyDate toSort[] = new MyDate[10];
        for (int i = 0; i < 10; ++i) {
            toSort[i] = new MyDate(2022, i % 4 + 3,i + 10 );
        }
        System.out.println("sorting:");
        for (int i = 0; i < 10; ++i) {
            toSort[i].print();
        }

        DateUtils.sortDate(toSort);
        System.out.println("sorted:");
        for (int i = 0; i < 10; ++i) {
            toSort[i].print();
        }
    }
}
