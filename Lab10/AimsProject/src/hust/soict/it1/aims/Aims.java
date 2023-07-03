package hust.soict.it1.aims;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.it1.aims.media.CompactDisc;
import hust.soict.it1.aims.media.DigitalVideoDisc;
import hust.soict.it1.aims.media.Media;
import hust.soict.it1.aims.media.MemoryDaemon;
import hust.soict.it1.aims.order.Order;
public class Aims {
	static Order order;
	static boolean running = true;
	static Scanner stdin = new Scanner(System.in);
	private static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	private static void createOrder() throws Exception {
		if (order != null) {
			System.out.println("Order exists. Discard? (y/n)");
			if (stdin.nextLine().toLowerCase().startsWith("n"))
				return;
		}
		order = new Order();
		System.out.println("Order has been created!");
	}
	private static void addItems() throws Exception {
		if (order == null) {
			System.out.println("Order does not exist. Create? (y/n)");
			if (stdin.nextLine().toLowerCase().startsWith("n"))
				return;
			createOrder();
		}
		Media item;
		String type, title = "unknown", category = "unknown";
		float cost = 0.0f;
		System.out.print("Item type (DVD, CD)? ");
		type = stdin.nextLine();
		if (type.equalsIgnoreCase("DVD"))
			item = new DigitalVideoDisc(title, category);
		else if (type.equalsIgnoreCase("CD"))
			item = new CompactDisc(title, category);
		else {
		    System.out.println("Unknown item type: " + type);
		    return;
		}
		System.out.print("Item name? ");
		title = stdin.nextLine();
		System.out.print("Item category? ");
		category = stdin.nextLine();
		System.out.print("Item cost? ");
		cost = stdin.nextFloat();
		item.setCost(cost);
		order.addMedia(item);
	}
	private static void removeItems() {
		if (order == null) {
			System.out.println("Order does not exist.");
			return;
		}
		System.out.print("Which item? ");
		int index = stdin.nextInt();
		order.removeMediaById(index);
	}
	private static void printItems() {
		if (order == null) {
			System.out.println("Order does not exist.");
			return;
		}
		order.printOrder();
	}
    public static void main(String[] args) {
    	MemoryDaemon memoryWatcher = new MemoryDaemon();
    	Thread memoryWatcherThread = new Thread(memoryWatcher);
    	memoryWatcherThread.setDaemon(true);
    	memoryWatcherThread.start();
    	running = false;
    	while (running) {
    		showMenu();
    		try {
		    String opt = stdin.nextLine();
		    if (opt.startsWith("0"))
			    running = false;
		    else if (opt.startsWith("1"))
			    createOrder();
		    else if (opt.startsWith("2"))
			addItems();
		    else if (opt.startsWith("3"))
			removeItems();
		    else if (opt.startsWith("4"))
			printItems();
		} catch (Exception e) {
		    return;
		}
    	}
    	Collection<DigitalVideoDisc> collection = new ArrayList<DigitalVideoDisc>();
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
	DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
	DigitalVideoDisc dvd3 = new DigitalVideoDisc("AF_INET");
	DigitalVideoDisc dvd4 = new DigitalVideoDisc("Invalid disc");
    	dvd1.setCategory ("Animation");
    	dvd1.setCost (19.95f);
	dvd1.setDirector ("Roger Allers");
    	dvd1.setLength (87);
    	dvd2.setCategory ("Science Fiction");
    	dvd2.setCost (24.95f);
    	dvd2.setLength (124);
    	dvd3.setLength (123);
    	dvd4.setLength (-1);
	collection.add(dvd2);
    	collection.add(dvd1);
    	collection.add(dvd3);
    	collection.add(dvd4);
    	Iterator iterator = collection.iterator();
	System.out.println("------------------------------------");
	System.out.println("The DVDs currently in the order are:");
	while (iterator.hasNext()) {
	    System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
	}
	Collections.sort((List<DigitalVideoDisc>)collection);
    	iterator = collection.iterator();
	System.out.println("------------------------------------");
	System.out.println("The DVDs in sorted order are:");
	while (iterator.hasNext()) {
	    System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
	}
	System.out.println("------------------------------------");
    	iterator = collection.iterator();
	while (iterator.hasNext()) {
	    try {
		((DigitalVideoDisc)iterator.next()).play();
	    } catch (PlayerException e) {
	    	System.err.println(e.getMessage());
	    	System.err.println(e.toString());
	    	e.printStackTrace();
	    }
	}
    }
}
