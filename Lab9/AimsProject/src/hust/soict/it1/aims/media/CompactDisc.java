package hust.soict.it1.aims.media;

import java.util.ArrayList;

public class CompactDisc implements Playable,Comparable<CompactDisc> {
    private String artist;
    private ArrayList<Track> tracks=new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void addTrack(Track track) {
        for(Track a: tracks){
            if(a.getTitle()==track.getTitle()){
                return;
            }
        }
        tracks.add(track);
    }
    public void removeTrack(Track track) {
        for(int i=0;i<tracks.size();i++){
            if(tracks.get(i).getTitle()==track.getTitle()){
                tracks.remove(i);
            }
        }
    }
    public int getLength(){
        int r=0;
        for(Track a: tracks){
            r+=a.getLength();
        }
        return r;
    }

    public CompactDisc(){
        super();
    }
    public CompactDisc(String artist){
        this();
        this.artist=artist;
    }
    @Override
    public void play() {
        for(Track a: tracks){
            System.out.println("Playing DVD: " + a.getTitle());
            System.out.println("DVD length: " + a.getLength());
        }
    }
    @Override
    public int compareTo(CompactDisc obj){
        int r=0;
        for(int i=0;i<Math.min(this.tracks.size(),obj.tracks.size());i++){
            r=this.tracks.get(i).compareTo(obj.tracks.get(i));
            if(r!=0) return r;
        }
        return r;
    }
}
