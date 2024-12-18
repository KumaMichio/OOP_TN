package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private float length;
	private String director;
	
    public Disc(String title, String category, float cost, int length, String director) {
        super.setTitle(title);
        super.setCategory(category);
        super.setCost(cost);
        this.length = length;
        this.director = director;
    }
    
	public Disc(String title, double cost) {
		// TODO Auto-generated constructor stub
	}

	public float getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	
}
