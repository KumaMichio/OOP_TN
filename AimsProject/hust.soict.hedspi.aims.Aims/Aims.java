package hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.media.*;

import hust.soict.hedspi.aims.store.Store.Store;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hedspi.aims.cart.Cart.*;
import java.util.Scanner;
import hust.soict.hedspi.aims.cart.*;


public class Aims {
	private static Store store = new Store();
    private static Cart cart = new Cart();
	public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);
	        int choice;
	        do {
	            showMenu();
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline
	            switch (choice) {
	                case 1:
	                    handleViewStore(scanner);
	                    break;
	                case 2:
	                    handleUpdateStore(scanner);
	                    break;
	                case 3:
	                    handleViewCart(scanner);
	                    break;
	                case 0:
	                    System.out.println("Exiting AIMS. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice! Please try again.");
	            }
	        } while (choice != 0);
	        scanner.close();
	    }
        
        public static void showMenu() {
    		System.out.println("AIMS: ");
    		System.out.println("--------------------------------");
    		System.out.println("1. View store");
    		System.out.println("2. Update store");
    		System.out.println("3. See current cart");
    		System.out.println("0. Exit");
    		System.out.println("--------------------------------");
    		System.out.println("Please choose a number: 0-1-2-3");
        }
        private static void handleViewStore(Scanner scanner) {
            System.out.println("\nStore Items:");
            store.displayStore();
            int choice;
            do {
                storeMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        handleMediaDetails(scanner);
                        break;
                    case 2:
                        handleAddToCart(scanner);
                        break;
                    case 3:
                        handlePlayMedia(scanner);
                        break;
                    case 4:
                        handleViewCart(scanner);
                        return; // Exit to main menu
                    case 0:
                        return; // Back to main menu
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);
        }

        public static void storeMenu() {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
        }

        private static void handleMediaDetails(Scanner scanner) {
            System.out.print("Enter the title of the media: ");
            String title = scanner.nextLine();
            Media media = store.findMediaByTitle(title);
            if (media == null) {
                System.out.println("Media not found!");
                return;
            }
            System.out.println(media);
            int choice;
            do {
                mediaDetailsMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        System.out.println("Media added to cart.");
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        return; // Back to store menu
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);
        }

        public static void mediaDetailsMenu() {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
        }

        private static void handleAddToCart(Scanner scanner) {
            System.out.print("Enter the title of the media: ");
            String title = scanner.nextLine();
            Media media = store.findMediaByTitle(title);
            if (media == null) {
                System.out.println("Media not found!");
                return;
            }
            cart.addMedia(media);
            System.out.println("Media added to cart.");
        }

        private static void handlePlayMedia(Scanner scanner) {
            System.out.print("Enter the title of the media: ");
            String title = scanner.nextLine();
            Media media = store.findMediaByTitle(title);
            if (media == null) {
                System.out.println("Media not found!");
                return;
            }
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media cannot be played.");
            }
        }

        private static void handleUpdateStore(Scanner scanner) {
            System.out.println("Options:");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Back");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter media details (title, cost): ");
                    String title = scanner.nextLine();
                    double cost = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    Media newMedia = new CompactDisc(title, cost);
                    store.addMedia(newMedia);
                    System.out.println("Media added to store.");
                    break;
                case 2:
                    System.out.print("Enter the title of the media to remove: ");
                    String title1 = scanner.nextLine();
                    store.removeMedia(title1);
                    System.out.println("Media removed from store.");
                    break;
                case 0:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }



 

        private static void handleViewCart(Scanner scanner) {
            System.out.println("\nCurrent Cart:");
            cart.displayCart();
            int choice;
            do {
                cartMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        cart.filterMedia(scanner);
                        break;
                    case 2:
                        cart.sortMedia(scanner);
                        break;
                    case 3:
                        System.out.print("Enter the title of the media to remove: ");
                        String title = scanner.nextLine();
                        cart.removeMedia(title);
                        System.out.println("Media removed from cart.");
                        break;
                    case 4:
                        handlePlayMedia(scanner);
                        break;
                    case 5:
                        cart.placeOrder();
                        break;
                    case 0:
                        return; // Back to main menu
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);
        }
        

        public static void cartMenu() {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
        }


	}
