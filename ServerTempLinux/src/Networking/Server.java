package Networking;

import java.io.*;
import java.net.*;

import AuctionDatabase.UserDatabase;

public class Server extends Thread {
	int port = 62223;
	private ServerSocket welcomeSocket = new ServerSocket(port);
	private int ThreadCounter = 0;
	public boolean isRunning = false;
	UserDatabase userDatabase = new UserDatabase();
	public Server(UserDatabase ud) throws Exception {
		userDatabase = ud;
		
	}
	
	public Server(UserDatabase ud,String response) throws Exception {
		userDatabase = ud;
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			new ServerThread("#" + ThreadCounter, connectionSocket,userDatabase,response).start();
			ThreadCounter++;
		}
	}
	@Override
	public void run(){
		while (true) {
			Socket connectionSocket;
			try {
				connectionSocket = welcomeSocket.accept();
				new ServerThread("#" + ThreadCounter, connectionSocket,userDatabase).start();
				ThreadCounter++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}