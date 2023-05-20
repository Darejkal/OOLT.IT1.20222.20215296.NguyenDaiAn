package hust.soict.it1.aims.media;

import java.text.Collator;
import java.util.*;

public class Book extends Media {

    public List<String> authors= new ArrayList<String>();
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        processContent();
    }

    public List<String> contentTokens;
    public Map<String,Integer> wordFrequency;
    public void processContent(){
        contentTokens= Arrays.asList(content.split("(\\p{Punct}| )+"));
        Collections.sort(contentTokens, Collator.getInstance());
        wordFrequency=new HashMap<String,Integer>();
        for(String x:contentTokens){
            if(!wordFrequency.containsKey(x)) wordFrequency.put(x,1);
            else wordFrequency.put(x,wordFrequency.get(x)+1);
        }
    }
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
    public Book(String title, String category, List<String> authors,String content){
        super(title, category);
        this.authors = authors;
        setContent(content);
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
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Title: ");
        builder.append(this.getTitle());
        builder.append("\nCategory: ");
        builder.append(this.getCategory());
        builder.append("\nAuthors: ");
        builder.append(this.authors);
        builder.append("\nNumber of tokens: ");
        builder.append(this.contentTokens.size());
        builder.append("\nTokens list:\n");
        builder.append(this.wordFrequency);
        return builder.toString();
    }

}
