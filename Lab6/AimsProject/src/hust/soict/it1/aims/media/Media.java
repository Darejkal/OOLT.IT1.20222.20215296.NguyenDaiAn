package hust.soict.it1.aims.media;

public class Media extends java.lang.Object {
    public static int getNextId() {
        return NEXT_ID;
    }

    public static void setNextId(int nextId) {
        NEXT_ID = nextId;
    }

    private int id;
    public static int NEXT_ID=1;
    public Media(){
        super();
        id=NEXT_ID;
        NEXT_ID++;
    }
    public Media(String title){
        this();
        this.title = title;
    }
    public Media(String title, String category){
        this(title);
        this.category = category;
    }

    public static void main (String[] args){
    }

    private String title;
    private String category;
    private float cost;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
