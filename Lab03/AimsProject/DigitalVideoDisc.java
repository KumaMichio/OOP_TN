public class DigitalVideoDisc {
	
	
	public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }
	
	public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
	
	// Class variable to track the number of DigitalVideoDiscs created
    private static int nbDigitalVideoDiscs = 0;
	private String title;


	private String category;
	private String director;
	private int length;
	private float cost;
	
	private int id; // Instance variable to store the unique id for each DVD
	
	public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        // Assign the current value of nbDigitalVideoDiscs as the id for this DVD
        this.id = nbDigitalVideoDiscs;
    }
	// Method to get the total number of DVDs created
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
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
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
    public int getId() {
        return id; // Return the unique id of this DVD
    }
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

}
