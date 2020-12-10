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
	private BufferedReader inFromClient;
	private DataOutputStream outToClient;
	private String clientSentence;
	private boolean isConnected, loggedIn;
	private UserDatabase ud;
	private static HashMap <String,Command> PublicCommands = new HashMap<>();
	private static HashMap <String,Command> UserCommands = new HashMap<>();
	private String TestResponse="You haven't send any response from program";

	public ServerThread(String jmeno, Socket socket, UserDatabase ud) {
		super(jmeno);
		this.ud = ud;
		this.connectionSocket = socket;
	}
	public ServerThread(String jmeno, Socket socket, UserDatabase ud,String response) {
		super(jmeno);
		this.ud = ud;
		this.connectionSocket = socket;
		TestResponse = response;
	}

	@Override
	public void run() {

		try {

			isConnected = true;
			loggedIn = false;
			inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			outToClient.writeBytes("Jsi pripojen k serveru aukcni databaze:\n\r");
			while (isConnected) {
				while(!loggedIn) {
					String username, password;
					outToClient.writeBytes("Jmeno:");
					username = getUserInput(inFromClient);
					outToClient.writeBytes("\n\rHeslo:");
					password = getUserInput(inFromClient);
					loggedIn=ud.checkUsernameInHashSet(new User(username,password));
					System.out.println(loggedIn);
				}
				outToClient.writeBytes(TestResponse);
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
		
	}
	
	private void initUserCommands() {
		
	}
	
}