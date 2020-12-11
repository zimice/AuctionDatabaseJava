package Networking.Commands;

public class HelpCommand extends Command{

	@Override
	public String[] Alias() {
		String[] aliases = {"h","help","manual"};
		return aliases;
	}

	@Override
	public String Execute() {
		String response="";
		return response;
	}

}
