package Networking.Commands;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

import AuctionDatabase.User;

public class LoginCommand extends Command {
	private BufferedReader inFromClient=null;
	private DataOutputStream outToClient=null;
	public LoginCommand(BufferedReader inFromClient,DataOutputStream outToClient) {
		this.inFromClient=inFromClient;
		this.outToClient=outToClient;
	}
	@Override
	public String[] Alias() {
		String[] aliases = {"login"};
		return aliases;
	}
	@Override
	public String Execute() {
		
		String username, password;
		try {
			outToClient.writeBytes("Jmeno:");
			username = inFromClient.readLine();
			outToClient.writeBytes("\n\rHeslo:");
			password = inFromClient.readLine();
		} catch (IOException e) {
			System.err.println("Error in LOGIN method");
			return "NOT";
		}
		
		return "LOGED";
	}


}
 