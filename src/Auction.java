import java.util.Stack;

public class Auction {
	Wine wine;
	Stack<Offer> offers;
	Person owner;
	String itemDescription;
	public Wine getWine() {
		return wine;
	}
	public void setWine(Wine wine) {
		this.wine = wine;
	}
	public String addOffer(Offer offer) {
		if(offers.lastElement().getBiddedPrice() < offer.getBiddedPrice()) {
			offers.add(offer);
			return "Offer added";
		} 
		return "Offer price is lower than highest ";
		//offers.pop();
	}
	public Offer getLastOffer() {
		return offers.lastElement();
	}
	@Override
	public String toString() {
		return "Auction [wine=" + wine + ", offers=" + offers + ", owner=" + owner.toString() + ", itemDescription="
				+ itemDescription + "]";
	}
	public Auction(Wine wine) {
		super();
		this.wine = wine;
		offers.add(new Offer(wine.getPrice()));
	}
	public Auction (Wine wine,Person owner,String itemDescription) {
		this.wine=wine;
		this.owner=owner; 
		if(!itemDescription.contains(owner.getAddress()) || !itemDescription.matches(User.TelRegex) || !itemDescription.matches(User.EmailRegex) )
			this.itemDescription= itemDescription; //TODO
		
	}
	public Auction(Wine wine,Offer startingOffer) {
		this.wine = wine;
		offers.add(startingOffer);
	}
}
