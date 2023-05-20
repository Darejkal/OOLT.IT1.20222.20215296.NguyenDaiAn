package hust.soict.it1.aims.media;

import hust.soict.it1.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title){
        setTitle(title);
    }
    public DigitalVideoDisc(String title,String category){
        super();
        setTitle(title);
        setCategory(category);

    }
    public DigitalVideoDisc(String title,String category,String director){
        super();
        setTitle(title);
        setTitle(category);
        setDirector(director);
    }
    public DigitalVideoDisc(String title,String category,String director,int length,float cost){
        super();
        setTitle(title);
        setTitle(category);
        setDirector(director);
        setLength(length);
        setCost(cost);
    }
    public boolean search(String title){
        Boolean r=true;
        for (String key : title.split(" "))
	        r= r&& getTitle().contains(key);
        return r;
    }
    @Override
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}