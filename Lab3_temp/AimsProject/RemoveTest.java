public class RemoveTest {
    public static void main(String args[]){
        Order anOrder = new Order();
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
    	dvd1.setCategory ("Animation");
    	dvd1.setCost (19.95f);
    	dvd1.setDirector ("Roger Allers");
    	dvd1.setLength (87);
    	anOrder.addDigitalVideoDisc(dvd1);
        System.out.println("Added 1 disc, current state is ".concat(Integer.toString(anOrder.getQtyOrdered())));
    	DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
    	dvd2.setCategory ("Science Fiction");
    	dvd2.setCost (24.95f);
    	dvd2.setDirector ("George Lucas");
    	dvd2.setLength (124);
    	anOrder.addDigitalVideoDisc(dvd2);
        System.out.println("Added 1 disc, current state is ".concat(Integer.toString(anOrder.getQtyOrdered())));
    	anOrder.addDigitalVideoDisc(dvd2);
        System.out.println("Added 1 disc, current state is ".concat(Integer.toString(anOrder.getQtyOrdered())));
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Removed 2 disc, current state is ".concat(Integer.toString(anOrder.getQtyOrdered())));
        anOrder.addDigitalVideoDisc(dvd2);
        System.out.println("Added 1 disc, current state is ".concat(Integer.toString(anOrder.getQtyOrdered())));
        anOrder.addDigitalVideoDisc(dvd2);
        System.out.println("Added 1 disc, current state is ".concat(Integer.toString(anOrder.getQtyOrdered())));
        anOrder.removeDigitalVideoDisc(dvd1);
        System.out.println("Removed 1 disc, current state is ".concat(Integer.toString(anOrder.getQtyOrdered())));

    }
}
