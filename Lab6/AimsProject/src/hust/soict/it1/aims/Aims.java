package hust.soict.it1.aims;
import java.util.Scanner;

import hust.soict.it1.aims.media.*;
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
	private static void createOrder() {
		if (order != null) {
			System.out.println("Order exists. Discard? (y/n)");
			String a=stdin.nextLine().toLowerCase();
			if (a.startsWith("n"))
				return;
			else if (a.toLowerCase().startsWith("y")){
				try {
					order = new Order();
				} catch (Exception e) {
					return;
				}
				System.out.println("Order has been created!");
			} else {
				System.out.println("Invalid response! Try again:");
				createOrder();
			}
		}
		try {
			order = new Order();
		} catch (Exception e) {
			return;
		}
		System.out.println("Order has been created!");

	}
	private static void addItems() {
		if (order == null) {
			System.out.println("Order does not exist. Create? (y/n)");
			if (stdin.nextLine().toLowerCase().startsWith("n"))
				return;
			createOrder();
		}
		String title, category;
		float cost;
		System.out.print("Item name? ");
		title = stdin.nextLine();
		System.out.print("Item category? ");
		category = stdin.nextLine();
		System.out.print("Item cost? ");
		cost = stdin.nextFloat();
		Media item = new Media(title, category);
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
		order.print();
	}
	public static void main(String[] args) {
		while (running) {
			showMenu();
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
		}
	}
}
