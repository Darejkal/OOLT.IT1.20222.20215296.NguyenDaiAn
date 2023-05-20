package hust.soict.it1.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    public List<String> authors= new ArrayList<String>();


    public Book(){
        super();
    }
    public Book(String title){
        super(title);
    }
    public Book(String title, String category){
        super(title, category);
        //…
    }
    public Book(String title, String category, List<String> authors){
        super(title, category);
        this.authors = authors;
    }

    public static void main(String[] args){

    }
    public void addAuthor(String authorName){
        for(String a : authors){
            if(a.equals(authorName)){
                return;
            }
        }
        authors.add(authorName);
    }
    public void removeAuthor(String authorName){
        for(int i=0;i<authors.size();i++){
            if(authors.get(i).equals(authorName)){
                authors.remove(i);
                return;
            }
        }
    }

}
