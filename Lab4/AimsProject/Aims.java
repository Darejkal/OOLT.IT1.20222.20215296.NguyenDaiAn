import java.time.LocalDate;

class Aims{
    
    public static void main(String[] args) {
    	Order o1 = new Order(LocalDate.now());
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
    	dvd1.setCategory ("Animation");
    	dvd1.setCost (19.95f);
    	dvd1.setDirector ("Roger Allers");
    	dvd1.setLength (87);
    	o1.addDigitalVideoDisc(dvd1);
    	Order o2 = new Order(LocalDate.now());
    	DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
    	dvd2.setCategory ("Science Fiction");
    	dvd2.setCost (24.95f);
    	dvd2.setDirector ("George Lucas");
    	dvd2.setLength (124);
    	o2.addDigitalVideoDisc(dvd2);

    	DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
    	dvd3.setCategory ("Animation");
    	dvd3.setCost (18.99f);
    	dvd3.setDirector ("John Musker");
    	dvd3.setLength (90);

    	o2.addDigitalVideoDisc(dvd3);
        o1.print();
        o2.print();

    }
}