package hust.soict.it1.aims.media;

import hust.soict.it1.aims.PlayerException;

public class Track implements Playable, Comparable {
    private String title;
    private int length;
    public String getTitle() {
    	return this.title;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    public int getLength() {
    	return this.length;
    }
    public void setLength(int length) {
    	this.length = length;
    }
    public void play() throws PlayerException {
    	if (this.getLength() <= 0) {
    	    System.err.println("ERROR: Track length is 0");
    	    throw new PlayerException();
    	}
    	System.out.println("Playing track: " + this.getTitle());
    	System.out.println("Track length: " + this.getLength());
    }
    public int compareTo(Object obj) {
    	if (!(obj instanceof Track)) { }
    	Track target = (Track)obj;
    	return this.getTitle().compareTo(target.getTitle());
    }
}
