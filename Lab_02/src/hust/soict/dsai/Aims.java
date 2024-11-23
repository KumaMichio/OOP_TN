public class Aims {

	public static void main(String[] args) {
		//Create a new cart
		Cart anOrder = new Cart();
		
		//Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Danmachi", 
				"Animation", "Hideki Tachibana", 68, 10.05f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("One Piece: Red", 
				"Animation", "Gorou Taniguchi", 96, 12.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Venom: The last dance", 
				"Actions", "Kelly Marcel", 100, 20.05f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Conjuring");
		anOrder.addDigitalVideoDisc(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc( "Action", "The Spiderman 3", 25.50f);
		anOrder.addDigitalVideoDisc(dvd5);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc( "Hideo Kojima", "Adventure", "Death Stranding", 30.60f);
		anOrder.addDigitalVideoDisc(dvd6);
		
		//print total cost of the items in the cart
		System.out.println("Total cost is: ");
		System.out.println(anOrder.calculateCost());
		
		anOrder.removeDigitalVideoDisc(dvd3);
	}
}
