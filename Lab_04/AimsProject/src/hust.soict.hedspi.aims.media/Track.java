package hust.soict.hedspi.aims.media;

public class Track implements Playable{
	private String title;
	private float length;
	
	
	public Track(String title, float length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}
	public float getLength() {
		return length;
	}
	public void play() {
	        System.out.println("Playing Track: " + this.title);
	        System.out.println("Track length: " + this.length + " mins");
	}
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true; // Check for reference equality
	    if (!(o instanceof Track)) return false; // Check type compatibility
	    Track track = (Track) o; // Safe cast
	    return this.title != null && this.title.equals(track.title) && this.length == track.length; // Attribute equality
	}

	
}
