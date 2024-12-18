package hust.soict.hedspi.aims.cart.Cart;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public Cart() {
        this.itemsOrdered = new ArrayList<>(); // Initialize the list
    }
	// add books, discs
	public void addMedia(Media media) {
		if(!itemsOrdered.contains(media)) {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " " + "has been add to the cart");
		}
		else {
			System.out.println(media.getTitle() + " " + "is already in the cart");
		}
	}
	
	// remove books, discs
	public void removeMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println(media.getTitle() + " " + "removed from the cart");
		} else {
			System.out.println(media.getTitle() + " " + "not found in the cart");
		}
	}
	// remove find by title
	public void removeMedia(String title) {
		// Search for the media item with the given title
	    for (Media media : itemsOrdered) {
	        if (media.getTitle().equalsIgnoreCase(title)) {
	            // Remove the item if found
	            itemsOrdered.remove(media);
	            System.out.println("Media removed: " + title);
	            return; // Exit the method after removal
	        }
	    }
	    // If the loop completes, the title was not found
	    System.out.println("Media not found: " + title);
	}
	
	// calculate cost
    public float calculateCost() {
		float total = 0;
		for(Media media : itemsOrdered) {
			total += media.getCost();
		}
		return total;
	}
	
    // Displays the current contents of the cart
    public void displayCart() {
        System.out.println("Cart contains:");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
        System.out.println("Total cost: $" + calculateCost());
    }

    // Search for objects by ID    
    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
           if (media.getId() == id) {
           return media;
             
                }
            }
        	return null;
          
        }
    // Search for objects by title
    public ArrayList<Media> searchByTitle(String title) {
    		ArrayList<Media> results = new ArrayList<>();
    		for( Media media : itemsOrdered) {
    			if(media.getTitle().toLowerCase().contains(title.toLowerCase())) {
    				results.add(media);
    			}
    		}
    		return results;
    }
    
    public void sortMedia(Scanner scanner) {
        System.out.println("Sort options:");
        System.out.println("1. By Title");
        System.out.println("2. By Cost");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Sorting by title...");
                itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST); // Sort by title comparator
                System.out.println("Cart sorted by title:");
                displayCart();
                break;
            case 2:
                System.out.println("Sorting by cost...");
                itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE); // Sort by cost comparator
                System.out.println("Cart sorted by cost:");
                displayCart();
                break;
            default:
                System.out.println("Invalid choice! Please choose 1 or 2.");
        }
    }

    // Method to place an order and clear the cart
    public void placeOrder() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Your cart is empty. No order placed.");
            return;
        }
        System.out.println("Order placed successfully!");
        itemsOrdered.clear(); // Clear the cart
    }
	public void filterMedia(Scanner scanner) {
		System.out.println("Choose a way to filter: ");
		System.out.println("1. Filter by title");
		System.out.println("2. Filter by category");
	    System.out.println("3. Filter by cost range");
	    System.out.print("Enter your choice: ");

	    int choice = scanner.nextInt();
	    scanner.nextLine(); // Consume newline
	    
	    switch (choice) {
        case 1:
            // Filter by title
            System.out.print("Enter the title to filter: ");
            String title = scanner.nextLine();
            for (Media media : itemsOrdered) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    System.out.println(media);
                }
            }
            break;

        case 2:
            // Filter by category
            System.out.print("Enter the category to filter: ");
            String category = scanner.nextLine();
            for (Media media : itemsOrdered) {
                if (media.getCategory().equalsIgnoreCase(category)) {
                    System.out.println(media);
                }
            }
            break;

        case 3:
            // Filter by cost range
            System.out.print("Enter the minimum cost: ");
            float minCost = scanner.nextFloat();
            System.out.print("Enter the maximum cost: ");
            float maxCost = scanner.nextFloat();
            for (Media media : itemsOrdered) {
                if (media.getCost() >= minCost && media.getCost() <= maxCost) {
                    System.out.println(media);
                }
            }
            break;

        default:
            System.out.println("Invalid choice. Please try again.");
            break;
	    }
	}
}
