package hust.soict.it1.aims.media;

import hust.soict.it1.aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable, Comparable {
    public DigitalVideoDisc() {
    	super("Unknown");
    }
    public DigitalVideoDisc(String title) {
    	super(title);
    }
    public DigitalVideoDisc(String title, String category) {
    	super(title, category);
    }
    public DigitalVideoDisc(String title, String category, String director) {
    	super(title, category);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    	super(title, category, director);
    }
    public void play() throws PlayerException {
    	if (this.getLength() <= 0) {
    	    System.err.println("ERROR: DVD length is 0");
    	    throw new PlayerException();
    	}
    	System.out.println("Playing DVD: " + this.getTitle());
    	System.out.println("DVD length: " + this.getLength());
    }
    public int compareTo(Object obj) {
    	if (!(obj instanceof DigitalVideoDisc)) {
	}
    	DigitalVideoDisc target = (DigitalVideoDisc)obj;
    	return this.getTitle().compareTo(target.getTitle());
    }
}
