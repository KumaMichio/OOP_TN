package hust.soict.hedspi.aims.media;
import java.util.Comparator;
import hust.soict.hedspi.aims.media.MediaComparatorByCostTitle;
import hust.soict.hedspi.aims.media.MediaComparatorByTitleCost;
import hust.soict.hedspi.aims.exception.PlayerException;
public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	private static int nbDigitalVideoDiscs = 0; 

	public Media(String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		this.title = title;
        this.category = category;
        this.cost = cost;
        
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
		
	}
	
    public Media(String title) {
		// TODO Auto-generated constructor stub
		this.title = title;
        this.category = "";
        this.cost = 0;
        
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
		
	}
	@Override
    public boolean equals(Object obj) {
        if (this == obj) { // Check if both references point to the same object
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { // Check if obj is null or a different class
            return false;
        }
        Media media = (Media) obj; // Cast obj to Media
        return title != null && title.equals(media.title); // Check equality of titles
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0; // Generate hashCode based on title
    }
	

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
	public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
	public boolean isMatch(String title2) {
		// TODO Auto-generated method stub
		return false;
}
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	@Override
    public String toString() {
        return "Media{" +
               "title='" + title + '\'' +
               ", category='" + category + '\'' +
               ", cost=" + cost +
               '}';
}
	public void play() throws PlayerException {
        System.out.println("Playing: " + this.title);
    }
}
