package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.PlayerException;

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
	public void setTitle(String title) {
		this.title = title;
	}


	public void setLength(float length) {
		this.length = length;
	}
    @Override
    public int hashCode() {
        float result;
        if (title != null) {
            result = title.hashCode(); // Lấy mã băm của title nếu không null
        } else {
            result = 0; // Nếu title là null, gán mã băm là 0
        }
        result = 31 *result + length; // Kết hợp thêm thuộc tính length
        return (int)(result); // Trả về kết quả mã băm dạng số nguyên
    }

   // Method to play a track
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + title);
            System.out.println("Track length : " + length);
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
	public static Track join(String string, ArrayList<Track> tracks) {
		// TODO Auto-generated method stub
		return null;
	}
	 public String toString() {
	        return "Track{" +
	               "title='" + title + '\'' +
	               ", length='" + length + '\'' +
	               '}';
	    }
}

