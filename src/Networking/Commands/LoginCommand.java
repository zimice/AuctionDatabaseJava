package Networking.Commands;

public class LoginCommand extends Command {
	
	public LoginCommand() {
		
	}
	@Override
	public String[] Alias() {
		String[] aliases = {"login"};
		return aliases;
	}
	@Override
	public String Execute(Object... objects) {
		int a = 0;
		objects[0] = (int) a;
		return null;
	}


}
 