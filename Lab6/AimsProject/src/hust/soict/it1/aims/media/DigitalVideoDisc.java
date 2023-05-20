package hust.soict.it1.aims.media;

import hust.soict.it1.aims.media.Media;

public class DigitalVideoDisc   {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String director;

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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int length;
    public float cost;
    private String title;
    private String category;

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
}