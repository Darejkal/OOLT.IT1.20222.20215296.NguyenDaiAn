package hust.soict.it1.aims.media;

public class Track implements Playable,Comparable<Track> {
    private int length;
    private String title;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    @Override
    public int compareTo(Track obj){
        return this.title.compareTo(obj.title);
    }
}
