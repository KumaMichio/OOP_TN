package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.hedspi.aims.exception.PlayerException;


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

	public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
		super(title, category, cost, length, director);
		// TODO Auto-generated constructor stub
	}

	public String getArtist(){
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
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
    
//    public void play() {
//        System.out.println("Playing Compact Disc: " + this.getTitle());
//        System.out.println("Artist: " + this.artist);
//        System.out.println("Total Length: " + this.getLength() + " mins");
//        System.out.println("Tracks:");
//        for (Track track : tracks) {
//            track.play(); // Call play() for each track
//        }
//    }
    
	 // Method to play a track
    @Override
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD artist: " + artist);
            System.out.println("CD length: " + this.getLength());
            for (Track track: tracks) {
                track.play();
            }
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()) {
                nextTrack = (Track) iter.next();
                nextTrack.play();
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    // Utility method to display all authors (for testing purposes)
    public Track getTracksAsString() {
        return Track.join(", ", tracks);
    }
    public boolean contains(Track track) {
        for (Track item : tracks) {
            if (item.equals(track)) { // Sử dụng equals đã override trong Media
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "CompactDisc{" +
               "title='" + super.getTitle() + '\'' +
               ", category='" + super.getCategory() + '\'' +
               ", director='" + super.getDirector() + '\'' +
               ", length='" + super.getLength() + '\'' +
               ", cost=" + super.getCost() +
               ", artist='" + artist + '\'' +
               '}';
    }

}
