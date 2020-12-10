package Networking.Commands;

public class HelpCommand extends Command{

	@Override
	public String[] Alias() {
		
		return null;
	}

	@Override
	public String Execute(Object... objects) {
		String response="";
		objects[0] = (String) response;
		return response;
	}

}
