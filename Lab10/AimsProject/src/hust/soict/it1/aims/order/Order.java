package hust.soict.it1.aims.order;
import hust.soict.it1.aims.media.Media;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    public static int NEXT_ID=1;
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERS = 10;
    private static int nbOrders = 0;
    private ArrayList<Media> itemsOdered = new ArrayList<Media>();
    private LocalDate dateOrdered;
    public Order() {
        this(LocalDate.now());
    }

    public Order(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
        if (nbOrders < MAX_LIMITED_ORDERS) {
            nbOrders++;
        } else {
            throw new Error("Max numbers of order reached.");
        }
        id=NEXT_ID;
        NEXT_ID++;
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }


    public boolean addMedia(Media disc) {
        if (itemsOdered.size() >= MAX_NUMBERS_ORDERED) {
            if (itemsOdered.size() == MAX_NUMBERS_ORDERED) {
                System.out.println("The order is full");
            }
            return false;
        } else {
            itemsOdered.add(disc);
            System.out.println("The item has been added");
            if (itemsOdered.size() == MAX_NUMBERS_ORDERED) {
                System.out.println("The order is almost full");
            }
            return true;
        }
    }

    public boolean addMedia(Media[] dvdList) {
        boolean successful = true;
        int i = 0;
        for (; i < dvdList.length; i++) {
            if (!addMedia(dvdList[i])) {
                successful = false;
                break;
            }
        }
        if (i < dvdList.length) {
            System.out.println("------------------------------------------------------");
            System.out.println("Cannot add the following dvds due to order being full or other errors:");
            for (int j=i; j < dvdList.length; j++) {
                System.out.println(String.format("\t%d. %s",j-i+1, dvdList[j].getTitle()));
            }
            System.out.println("------------------------------------------------------");

        }
        return successful;
    }

    public boolean addMedia(Media dvd1, Media dvd2) {
        Media arr[] = { dvd1, dvd2 };
        return addMedia(arr);
    }

    public void removeMedia(Media disc) {
        for (var i = itemsOdered.size() - 1; i > -1; i--) {
            if (itemsOdered.get(i).getId() == disc.getId()) {
                itemsOdered.remove(i);
            }
        }
    }

    public float totalCost() {
        int cost = 0;
        for (int i = 0; i < itemsOdered.size(); i++) {
            cost += itemsOdered.get(i).getCost();
        }
        return cost;
    }

    public void printOrder() {
        System.out.println(String.format("*********************Order #%d**************** ********",this.id));
        System.out.println(String.format("Date: %s", dateOrdered.toString()));
        System.out.println("Ordered Items:");
        for(int i=0;i<itemsOdered.size();i++){
            System.out.println(String.format("%d. ID %d| Media - %s - %s : %f $",i+1,itemsOdered.get(i).getId(),itemsOdered.get(i).getTitle(),itemsOdered.get(i).getCategory(),itemsOdered.get(i).getCost()));
        }
        System.out.println(String.format("Total cost: %f",this.totalCost()));
        System.out.println("**************************************************");
    }
    public Media getALuckyItem(){
        Media r=itemsOdered.get((int)(Math.random()*itemsOdered.size()));
        r.setCost(0);
        return r;
    }
    public boolean removeMediaById(float id){
        try {
            for (var i = itemsOdered.size() - 1; i > -1; i--) {
                if (itemsOdered.get(i).getId() == id) {
                    itemsOdered.remove(i);
                }
            }
        } catch(Exception e){
            return false;
        }
        return true;
    }
}
