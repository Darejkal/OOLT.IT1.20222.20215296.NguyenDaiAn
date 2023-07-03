package hust.soict.it1.aims.media;
import hust.soict.it1.aims.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable, Comparable {
    private String artist;
    private int length;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    public CompactDisc() {
    	super("Unknown");
    }
    public CompactDisc(String title) {
    	super(title);
    }
    public CompactDisc(String title, String category) {
    	super(title, category);
    }
    public CompactDisc(String title, String category, String director) {
    	super(title, category);
    }
    public CompactDisc(String title, String category, String director, int length, float cost) {
    	super(title, category, director);
    }
    public String getArtist() { 
    	return this.artist;
    }
    public void setArtist(String artist) {
    	this.artist = artist;
    }
    public void addTrack(Track track) {
    	if (tracks.contains(track)) {
    	    System.out.println("Track already exists");
    	    return;
    	}
    	tracks.add(track);
    }
    public void removeTrack(Track track) {
    	if (!tracks.remove(track))
    	    System.out.println("Track does not exist");
    }
    public int getLength() {
      	return tracks.stream()
    			.map((track)->track.getLength())
    			.reduce(0,Integer::sum);
    }
    public void play() throws PlayerException {
    	if (this.getLength() <= 0) {
    	    System.err.println("ERROR: CD length is 0");
    	    throw new PlayerException();
    	}
	for (int i = 0; i < tracks.size(); ++i) {
	    System.out.println("Playing track #" + (i+1));
	    try {
		tracks.get(i).play();
	    } catch (PlayerException e) {
	    	e.printStackTrace();
	    	throw new PlayerException();
	    }
	}
    }
    public int compareTo(Object obj) {
    	if (!(obj instanceof CompactDisc)) {
	}
    	CompactDisc target = (CompactDisc)obj;
    	return this.getTitle().compareTo(target.getTitle());
    }
}
