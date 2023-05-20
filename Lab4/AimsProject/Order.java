import java.time.LocalDate;

public class Order {
    public static void main(String args[]){
        Order anOrder = new Order(LocalDate.now());
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
    	dvd1.setCategory ("Animation");
    	dvd1.setCost (19.95f);
    	dvd1.setDirector ("Roger Allers");
    	dvd1.setLength (87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
    	dvd2.setCategory ("Science Fiction");
    	dvd2.setCost (24.95f);
    	dvd2.setDirector ("George Lucas");
    	dvd2.setLength (124);
        //Test: adding to order an array & print
        DigitalVideoDisc arr[]={dvd1,dvd1,dvd1};
    	anOrder.addDigitalVideoDisc(arr);
        anOrder.print();
        //Test: adding to order 2 parameter & print
        anOrder.addDigitalVideoDisc(dvd2, dvd2);
        anOrder.print();
        //Test: adding too many discs.
        DigitalVideoDisc arr2[]={dvd1,dvd2,dvd1,dvd2,dvd1,dvd2,dvd1};
        anOrder.addDigitalVideoDisc(arr2);
        //Test: max number of orders.
        try {
            while(true){
                new Order(LocalDate.now());
            }    
        } catch(Throwable e){
            System.out.println(e.getMessage());
        }

        
    }
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERS = 10;
    private static int nbOrders = 0;
    private int qtyOrdered = 0;

    private DigitalVideoDisc itemsOdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private LocalDate dateOrdered;

    Order(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
        if (nbOrders < MAX_LIMITED_ORDERS) {
            nbOrders++;
        } else {
            throw new Error("Max numbers of order reached.");
        }
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The order is full");
            }
            return false;
        } else {
            itemsOdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The order is almost full");
            }
            return true;
        }
    }

    public boolean addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        boolean successful = true;
        int i = 0;
        for (; i < dvdList.length; i++) {
            if (!addDigitalVideoDisc(dvdList[i])) {
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

    // public boolean addDigitalVideoDisc(DigitalVideoDisc... dvdList){
    // boolean successful=true;
    // int i=0;
    // for(;i<dvdList.length;i++){
    // if(!addDigitalVideoDisc(dvdList[i])){
    // successful=false;
    // break;
    // }
    // }
    // if(i<dvdList.length){
    // System.out.println("Cannot add the following dvds due to order being full or
    // other errors:");
    // for(;i<dvdList.length;i++){
    // System.out.println(dvdList[i].getTitle());
    // }
    // }
    // return successful;
    // }
    public boolean addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        DigitalVideoDisc arr[] = { dvd1, dvd2 };
        return addDigitalVideoDisc(arr);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (var i = qtyOrdered - 1; i > -1; i--) {
            if (itemsOdered[i] == disc) {
                qtyOrdered--;
                for (var j = i; j < qtyOrdered; j++) {
                    itemsOdered[j] = itemsOdered[j + 1];
                }
            }
        }
    }

    public float totalCost() {
        int cost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            cost += itemsOdered[i].getCost();
        }
        return cost;
    }

    public void print() {
        System.out.println("*********************Order**************** ********");
        System.out.println(String.format("Date: %s", dateOrdered.toString()));
        System.out.println("Ordered Items:");
        for(int i=0;i<qtyOrdered;i++){
            System.out.println(String.format("%d. DVD - %s - %s - %s - %d: %f $",i+1,itemsOdered[i].getTitle(),itemsOdered[i].getCategory(),itemsOdered[i].getDirector(),itemsOdered[i].getLength(),itemsOdered[i].getCost()));
        }
        System.out.println(String.format("Total cost: %f",this.totalCost()));
        System.out.println("**************************************************");
    }
}
