package AuctionDatabase;
import java.util.HashSet;

public class UserDatabase {
	HashSet users = new HashSet();

	public UserDatabase() {
		users = new HashSet();
	}

	public String addUser(User u) {
		String result = "User added";
		try {
			if(users.add(u) == false)
				throw new UsernameTakenException("User already in database");
			if (User.checkPassword(u.getPassword()));
				throw new PasswordWeakException("Password does not meet basic requirements");
			if(User.checkContact(tel, address, email)) // TODO
		}catch (UsernameTakenException e ) {
			result = e.getMessage();
		} catch (PasswordWeakException e) {
			result = e.getMessage();
		}
		
		return result;

	}
	public static boolean checkUsernameInSavedDatabase() {
		return true; // TODO udelat databazi a prohledat ulozenou
	}

}
