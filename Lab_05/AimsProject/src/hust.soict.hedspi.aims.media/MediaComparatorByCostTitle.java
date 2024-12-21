package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Compare by cost in descending order
        int costComparison = Double.compare(m2.getCost(), m1.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        // If costs are equal, compare by title in ascending order
        return m1.getTitle().compareTo(m2.getTitle());
    }
}
