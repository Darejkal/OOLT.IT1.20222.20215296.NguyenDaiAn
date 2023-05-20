package hust.soict.it1.aims.test;

import hust.soict.it1.aims.DigitalVideoDisc;
import hust.soict.it1.aims.order.Order;

import java.time.LocalDate;

public class DiskTest {
    public static void main(String args[]){
        Order anOrder = new Order(LocalDate.now());
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
    	dvd1.setCategory ("Animation");
    	dvd1.setCost (19.95f);
    	dvd1.setDirector ("Roger Allers");
    	dvd1.setLength (87);
        System.out.println("Testing if the title (The Lion King) contains (King The Lion):");
        System.out.println(dvd1.search("King The Lion"));
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
    	dvd2.setCategory ("Science Fiction");
    	dvd2.setCost (24.95f);
    	dvd2.setDirector ("George Lucas");
    	dvd2.setLength (124);
        DigitalVideoDisc arr[]={dvd1,dvd2};
        anOrder.addDigitalVideoDisc(arr);
        anOrder.print();
        anOrder.getALuckyItem();
        anOrder.print();
    }
}
