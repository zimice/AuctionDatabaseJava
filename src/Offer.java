
public class Offer {
	private User user;
	private	double biddedPrice;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getBiddedPrice() {
		return biddedPrice;
	}
	public Offer(User user, double d) {
		super();
		this.user = user;
		this.biddedPrice = d;
	}
	public Offer(double biddedPrice) {
		this.user = null;
		this.biddedPrice = biddedPrice;
	}
}
