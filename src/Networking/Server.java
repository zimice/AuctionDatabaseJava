import java.io.*;
import java.net.*;
public class Server{
    private ServerSocket welcomeSocket = new ServerSocket(23);
    private int ThreadCounter = 0 ;
    public boolean isRunning =false;
    public Server() throws Exception{
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            new ServerThread("#"+ThreadCounter,connectionSocket).start();
            ThreadCounter++;
        }
    }
    
}