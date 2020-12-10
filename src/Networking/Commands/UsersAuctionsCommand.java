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

}
