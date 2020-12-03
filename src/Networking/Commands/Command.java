package Networking.Commands;

public abstract class Command {
	
	public abstract String[] Alias();
	public abstract String Execute(Object...objects);
	
}
