public class Aims {

	public static void main(String[] args) {
		//Create a new cart
		Cart anOrder = new Cart();
		
		//Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Danmachi", 
				"Animation", "Hideki Tachibana", 68, 10.05f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("One Piece: Red", 
				"Animation", "Gorou Taniguchi", 96, 12.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Venom: The last dance", 
				"Actions", "Kelly Marcel", 100, 20.05f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Conjuring");
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc( "Action", "The Spiderman 3", 25.50f);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc( "Hideo Kojima", "Adventure", "Death Stranding", 30.60f);
		
		
		// add single discs
		anOrder.addDigitalVideoDisc(dvd6);
		
		// add a list discs
		DigitalVideoDisc[] dvdList = { dvd2, dvd3 };
		anOrder.addDigitalVideoDisc(dvdList);
		
		//print total cost of the items in the cart
		System.out.println("Total` cost is: ");
		System.out.println(anOrder.calculateCost());
		
		anOrder.removeDigitalVideoDisc(dvd3);
	}
}
