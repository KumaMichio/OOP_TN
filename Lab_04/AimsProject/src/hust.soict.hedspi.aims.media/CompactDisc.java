package hust.soict.hedspi.aims.media;

import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	
	public CompactDisc(String title, String category, float cost, int length, String director, String artist,
			ArrayList<Track> tracks) {
		super(title, category, cost, length, director);
		this.artist = artist;
	}



	public CompactDisc(String title, double cost) {
		super(title, cost);
	}



	public String getArtist(){
		return artist;
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Add Successful");
		} else {
			System.out.println("the track has been in the list");
		}
		
	}
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Remove Successful");
		} else{
			System.out.println("The author is not in the list");
		}
	}
    public float getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    public void play() {
        System.out.println("Playing Compact Disc: " + this.getTitle());
        System.out.println("Artist: " + this.artist);
        System.out.println("Total Length: " + this.getLength() + " mins");
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play(); // Call play() for each track
        }
    }
}
