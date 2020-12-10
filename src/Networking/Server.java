package Networking;

import java.io.*;
import java.net.*;

import AuctionDatabase.UserDatabase;

public class Server {
	int port = 62223;
	private ServerSocket welcomeSocket = new ServerSocket(port);
	private int ThreadCounter = 0;
	public boolean isRunning = false;
	UserDatabase userDatabase = new UserDatabase();
	public Server(UserDatabase ud) throws Exception {
		userDatabase = ud;
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			new ServerThread("#" + ThreadCounter, connectionSocket,userDatabase).start();
			ThreadCounter++;
		}
	}
	public Server(UserDatabase ud,String response) throws Exception {
		userDatabase = ud;
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			new ServerThread("#" + ThreadCounter, connectionSocket,userDatabase,response).start();
			ThreadCounter++;
		}
	}

}