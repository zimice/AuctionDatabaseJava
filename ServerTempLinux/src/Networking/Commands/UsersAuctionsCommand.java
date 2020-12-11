package Networking.Commands;

public class UsersAuctionsCommand extends Command{

	@Override
	public String[] Alias() {
		String[] aliases = {"myauctions","my"};
		return aliases;
	}

	@Override
	public String Execute() {
		return null;
	}

	@Override
	public String getHelp() {
		return "This command returns auctions created by user logged in";
	}

}
