package hust.soict.hedspi.aims.media;
import java.util.Comparator;
public abstract class Media {
	//fields
	private int id;
	private String title;
	private String category;
	private float cost;
	
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = Comparator
            .comparing(Media::getTitle)
            .thenComparing(Comparator.comparingDouble(Media::getCost).reversed());
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = Comparator
            .comparingDouble(Media::getCost).reversed()
            .thenComparing(Media::getTitle);
	//accessors
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	    if (this == o) return true; // Check for reference equality
	    if (!(o instanceof Media)) return false; // Check type compatibility
	    Media media = (Media) o; // Safe cast
	    return this.title != null && this.title.equals(media.title); // Attribute equality
	}
	
	
}
