package Networking.Commands;

public abstract class Command {
	
	public abstract String[] Alias();
	public abstract String Execute();
	public abstract String getHelp();
	
}
