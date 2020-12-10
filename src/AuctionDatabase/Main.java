package AuctionDatabase;
import java.util.ArrayList;

import Networking.Server;

public class Main {
	public static void main(String[]args) {
		Wine a = new Wine(2002,TypeOfWine.red,"Chato de Saul",299.9,12);
		Wine b = new Wine(2008,TypeOfWine.white,"Chato de Zel",199.9,12);
		AuctionDatabase ad = new AuctionDatabase();
		ad.add(a);
		ad.add(b);
		String response= "";
		System.out.println(ad.find("Chato de Saul").getYear());
		response+=ad.find("Chato de Saul").getYear()+"\r\n";
		System.out.println(ad.DbtoString());
		response+=ad.DbtoString()+"\r\n";
		User u = new User("Zimice","Javajava1.");
		System.out.println(User.checkPassword("Javajava1&"));
		Auction advert = AdvertParser.getAuction("Advert/Test.txt");
		System.out.println(advert.toString());
		response+=advert.toString()+"\r\n";
		Auction ac= new Auction(new Wine(456, TypeOfWine.red, "vino", 29.9, 5416));
		Offer f= new Offer(30.9);
		System.out.println(ac.addOffer(f));
		response+=ac.addOffer(f)+"\r\n";
		try {
			UserDatabase ud = new UserDatabase();
			System.out.println(ud.addUser(new User("simon","java")));
			Server s = new Server(ud, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}

