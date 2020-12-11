package AuctionDatabase;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Queue;

public class AuctionDatabase {
	private Hashtable<String,Wine> db = new Hashtable<>();
	private Auction actualAuction;
	private Queue<Auction> waitingAuctions;
	public AuctionDatabase() {
		
	}
	public AuctionDatabase(Queue<Auction> waitingAuctions) {
		this.waitingAuctions = waitingAuctions;
	}
	public AuctionDatabase(Auction actualAuction) {
		this.actualAuction = actualAuction;
	}
	private boolean addWineToDatabase(Wine wine) {
		return db.put(wine.getName(), wine) == null ? true : false;	
	}
	public String add(Wine wine) {
		String status;
		try{
			if(addWineToDatabase(wine)) 
				throw new WineAlreadyInDBException();
			addToQueue(wine.getName());
			status = "Wine added";
		}catch(WineAlreadyInDBException e) {
			status = "Wine is already auctioned";
		}
		return status;
		
	}
	private void addToQueue(String wineName) {
		waitingAuctions.add(new Auction(find(wineName)));
	}
	public Auction getAuctualAuction() {
		return actualAuction;
	}
	private void newAuction() {
		this.actualAuction= waitingAuctions.remove();
	}
	
	public Wine find(String name) {
		return db.get(name);
	}
	public String DbtoString() {
		String result = "";
		Enumeration<String> keys = db.keys();
		List<String> listedKeys= Collections.list(keys);
		Collections.sort(listedKeys);
		db.forEach( 
	            (k, v) -> System.out.println("Key : " + k + ", Value : " + v.toString())); 
	    
		return result;
	}
}
