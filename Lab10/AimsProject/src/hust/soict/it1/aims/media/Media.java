package hust.soict.it1.aims.media;

public abstract class Media implements Comparable {
    private String title;
    private String category;
    private float cost;
    private int id;
    private static int numItemsCreated = 0;
    public int getId() {
	return id;
    }
    public Media() { 
	this.id = numItemsCreated++;
    }
    public Media(String title) {
	this();
	setTitle(title);
    }
    public Media(String title, String category) {
	this(title);
	setCategory(category);
    }
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
    @Override
    public boolean equals(Object o) {
    	if (o == null)
    	    return false;
	if (o instanceof Media)
	    return getTitle().equals(((Media)o).getTitle())
		&& Math.abs(getCost() - ((Media)o).getCost()) < 0.1f;
	return false;
    }
    @Override
    public int compareTo(Object o) {
    	if (o == null)
    	    return -1;
	if (o instanceof Media) {
	    int titleComp  = getTitle().compareTo(((Media)o).getTitle());
	    float costComp = Math.abs(getCost() - ((Media)o).getCost());
	    return (titleComp != 0) ? titleComp
		: costComp > 0.001f ? 1
		: costComp < -0.001f ? -1
		: 0;
	}
	return -1;
    }
}
