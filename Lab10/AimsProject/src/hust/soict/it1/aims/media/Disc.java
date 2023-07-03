package hust.soict.it1.aims.media;

public class Disc extends Media {
    private String director;
    private int length;
    public Disc() {
    	super("Unknown");
    }
    public Disc(String title) {
    	super(title);
    }
    public Disc(String title, String category) {
    	super(title, category);
    }
    public Disc(String title, String category, String director) {
    	super(title, category);
    	setDirector(director);
    }
    public Disc(String title, String category, String director, int length, float cost) {
    	this(title, category, director);
    	setLength(length);
    	setCost(cost);
    }

    public String getDirector() {
    	return director;
    }
    public void setDirector(String director) {
    	this.director = director;
    }
    public int getLength() {
    	return length;
    }
    public void setLength(int length) {
    	this.length = length;
    }
    public boolean search(String title) {
    	for (String key : title.split(" "))
	    if (!this.getTitle().contains(key))
	    	return false;
	return true;
    }
}
