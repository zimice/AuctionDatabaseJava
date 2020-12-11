package AuctionDatabase;

public class UsernameTakenException extends Exception {
	public UsernameTakenException() {
		super();
	}
	public UsernameTakenException(String mes) {
		super(mes);
	}
}
