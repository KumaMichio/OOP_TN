package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	// Class variable to track the number of DigitalVideoDiscs created
    private static int nbDigitalVideoDiscs = 0;
	
    // Constructors
	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
	}

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(title, category, cost, 0, director); // Call parent constructor with default length
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director); // Call parent constructor with all parameters
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director); // Call parent constructor
        this.setId(id); // Set ID separately
    }

	
	public DigitalVideoDisc(String title) {
        super(title, null, 0, 0, null);
        nbDigitalVideoDiscs++;
        // Assign the current value of nbDigitalVideoDiscs as the id for this DVD
        this.setId(nbDigitalVideoDiscs);
    }



	// Method to get the total number of DVDs created
	public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
	
    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}


}
