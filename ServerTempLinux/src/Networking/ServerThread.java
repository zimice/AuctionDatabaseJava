package Networking;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import AuctionDatabase.User;
import AuctionDatabase.UserDatabase;
import Networking.Commands.*;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ServerThread extends Thread {
	private Socket connectionSocket;
	private static BufferedReader inFromClient = null;
	private static DataOutputStream outToClient = null;
	private String clientSentence;
	private boolean isConnected;
	private static String logged;
	private UserDatabase ud;
	private static HashMap<String, Command> PublicCommands = new HashMap<>();
	private static HashMap<String, Command> UserCommands = new HashMap<>();

	public ServerThread(String jmeno, Socket socket, UserDatabase ud) {
		super(jmeno);
		this.ud = ud;
		this.connectionSocket = socket;
	}

	public ServerThread(String jmeno, Socket socket, UserDatabase ud, String response) {
		super(jmeno);
		this.ud = ud;
		this.connectionSocket = socket;
	}

	@Override
	public void run() {

		try {

			isConnected = true;
			logged = "NOT";
			inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			outToClient.writeBytes("Jsi pripojen k serveru aukcni databaze:\n\r");
			while (isConnected) {
				initPublicCommands();
				while (logged != "LOGED") {
					clientSentence = getUserInput(inFromClient);
					logged=PublicCommands.get(clientSentence).Execute();
				}
				clientSentence = inFromClient.readLine();
				clientSentence = clientSentence.toLowerCase();
				System.out.println(getName() + " received:" + clientSentence);
				// outToClient.writeBytes("Server:" + executeCommand(clientSentence) + "\n\r");
				outToClient.writeBytes(clientSentence + "\n\r");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	private String getUserInput(BufferedReader inFromClient) throws IOException {
		String clientSentence = inFromClient.readLine();
		clientSentence = clientSentence.toLowerCase();
		return clientSentence;
	}

	private void initPublicCommands() {
		HelpCommand help = new HelpCommand();
		LoginCommand login = new LoginCommand(inFromClient, outToClient);
		Command[] commands = { help, login };
		for (Command c : commands) {
			String[] aliases = c.Alias();
			for (String s : aliases)
				PublicCommands.put(s, c);
		}
	}

	private void initUserCommands() {
		HelpCommand help = new HelpCommand();
		UsersAuctionsCommand userAuctions = new UsersAuctionsCommand();
		Command[] commands = { help, userAuctions };
		for (Command c : commands) {
			String[] aliases = c.Alias();
			for (String s : aliases)
				UserCommands.put(s, c);
		}
	}

}