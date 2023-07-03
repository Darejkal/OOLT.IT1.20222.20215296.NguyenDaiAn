package hust.soict.it1.aims.media;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Collections;

public class Book extends Media implements Comparable {
    private String content;
    private List<String> contentTokens = new ArrayList<String>();
    private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
    private List<String> authors = new ArrayList<String>();
    public Book() {
	super("Unknown");
    }
    public Book(String title) {
	super(title);
    }
    public Book(String title, String category) {
	super(title, category);
    }
    public Book(String title, String category, List<String> authors) {
	super(title, category);
	this.authors = authors;
    }
    public List<String> getAuthors() {
	return authors;
    }
    public void setAuthors(List<String> authors) {
	this.authors = authors;
    }
    public void addAuthor(String authorName) {
	this.authors.add(authorName);
    }
    public void removeAuthor(String authorName) {
	this.authors.removeIf((entry)->entry.equals(authorName));
    }
    public int compareTo(Object obj) {
	if (!(obj instanceof Book)) {
	}
	Book target = (Book)obj;
	return this.getTitle().compareTo(target.getTitle());
    }
    public String getContent() {
	return content;
    }
    public void setContent(String content) {
	this.content = content;
	processContent();
    }
    private void processContent() {
    	final String punctRegex = "\\p{Space}|\\p{Punct}";
    	List<String> tokens = new ArrayList<String>();
	Collections.addAll(tokens, content.split(punctRegex));
    	tokens.sort(null);
    	tokens.removeIf((token)->token.equals(""));
    	contentTokens = tokens;
    	Iterator<String> it = tokens.iterator();
    	while (it.hasNext()) {
    	    String token = it.next();
    	    if (wordFrequency.containsKey(token)) {
	    	wordFrequency.put(token, wordFrequency.get(token).intValue()+1);
	    } else
	    	wordFrequency.put(token, 1);
	}
    }
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	builder.append("Title: ");
    	builder.append(this.getTitle());
	builder.append("\nCategory: ");
    	builder.append(this.getCategory());
	builder.append("\nAuthors: ");
    	builder.append(this.getAuthors());
	builder.append("\nNumber of tokens: ");
    	builder.append(this.contentTokens.size());
	builder.append("\nTokens list:\n");
    	builder.append(this.wordFrequency);
    	/*
    	Iterator<String> it = wordFrequency.keySet().iterator();
    	while (it.hasNext()) {
	    String token = it.next();
	    builder.append(token);
	    builder.append(" = ");
	    builder.append(wordFrequency.get(token));
	    builder.append('\n');
	}
	*/
	return builder.toString();
    }
}
