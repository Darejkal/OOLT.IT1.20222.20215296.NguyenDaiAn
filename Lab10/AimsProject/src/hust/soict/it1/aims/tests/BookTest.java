package hust.soict.it1.aims.tests;
import hust.soict.it1.aims.media.Book;

import java.util.ArrayList;
public class BookTest {
    public static void main(String[] args) {
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("Ich");
        authors.add("kann");
        authors.add("nicht mehr");
        Book a = new Book("Lab08", "Program", authors);
        a.setContent("Write the BookTest class to test all above methods and display information of Book.");
        System.out.println(a);
    }
}
