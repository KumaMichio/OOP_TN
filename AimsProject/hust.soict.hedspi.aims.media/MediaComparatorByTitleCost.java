package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Compare by title in ascending order
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        // If titles are equal, compare by cost in descending order
        return Double.compare(m2.getCost(), m1.getCost());
    }
}
