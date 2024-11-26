public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered ++;
			System.out.println(disc.getTitle() + " " + "has been added");
		}else {
			System.out.println("The cart is full");
		}
	}
	// add multiples discs
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for(DigitalVideoDisc disc : dvdList) {
			if(qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered ++;
				System.out.println(disc.getTitle() + " " + "has been added");
			}else {
			System.out.println("The cart is full. Cannot add more items");
			break;
			}
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].equals(disc)) {
				for(int j = i; j <= qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				itemsOrdered[qtyOrdered - 1] = null;
				qtyOrdered--;
				System.out.println("The disc has been deleted");
			}
		}
		System.out.println("The disc is not in the cart");
		
	}
	
	public float calculateCost() {
		float total = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
	
    public void displayCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println(
                (i + 1) + ". DVD - " +
                disc.getTitle() + " - " +
                disc.getCategory() + " - " +
                disc.getDirector() + " - " +
                disc.getLength() + " mins: " +
                disc.getCost() + " $"
                );
        }
    }
        
        public void searchById(int id) {
            boolean found = false;
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemsOrdered[i].getId() == id) {
                    System.out.println("DVD found: " + itemsOrdered[i]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No DVD found with ID: " + id);
            }
        }
        public void searchByTitle(String title) {
            boolean found = false;
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemsOrdered[i].isMatch(title)) {
                    System.out.println("DVD found: " + itemsOrdered[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No DVD found with title containing: " + title);
            }

        System.out.println("Total cost: " +calculateCost() + " $");
        System.out.println("***************************************************");
    }

}
