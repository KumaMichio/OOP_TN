package hust.soict.hedspi.aims.store.Store;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
    private static final int MAX_ITEMS_IN_STORE = 50; 
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private int qtyInStore = 0; 
    
    // Retrieves all items in the store
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    
    // Adds 
    public void addMedia(Media media) {
        if (qtyInStore >= MAX_ITEMS_IN_STORE) {
            System.out.println("Cannot add media. Store has reached its maximum capacity of " + MAX_ITEMS_IN_STORE + " items.");
        } else if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            qtyInStore++;
            System.out.println("Media added to the store: " + media.getTitle());
        } else {
            System.out.println("Media is already in the store: " + media.getTitle());
        }
    }
    // Removes 
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            qtyInStore--;
            System.out.println("Media removed from the store: " + media.getTitle());
        } else {
            System.out.println("Media not found in the store: " + media.getTitle());
        }
    }
    //remove find by title
    public void removeMedia(String title) {
		// Search for the media item with the given title
	    for (Media media : itemsInStore) {
	        if (media.getTitle().equalsIgnoreCase(title)) {
	            // Remove the item if found
	            itemsInStore.remove(media);
	            System.out.println("Media removed: " + title);
	            return; // Exit the method after removal
	        }
	    }
	    // If the loop completes, the title was not found
	    System.out.println("Media not found: " + title);
	}
    public void displayStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
            return;
        }
        System.out.println("Items in the store:");
        for (Media media : itemsInStore) {
            System.out.println(media);
        }
    }
    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media; 
            }
        }
        return null; 
    }
}
