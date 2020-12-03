import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
public class ServerThread extends Thread {
    private Socket connectionSocket;
    private BufferedReader inFromClient; 
    private DataOutputStream outToClient;
    private String clientSentence;
    private boolean isConnected;
    private ArrayList<String> history;
    private ArrayList<String> quotes;
    public ServerThread(String jmeno,Socket socket){
        super(jmeno);
        this.connectionSocket=socket;
        history = new ArrayList<>();
        quotes = makeQuotes();
    }
    @Override
    public void run(){
    	
        try{
            isConnected=true;
            inFromClient =new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            outToClient.writeBytes("Jsi pripojen k serveru\n\r");
            while(isConnected){
                clientSentence = inFromClient.readLine();
                clientSentence=clientSentence.toLowerCase();
                history.add(clientSentence);
                System.out.println(getName()+" received:" + clientSentence);
                outToClient.writeBytes("Server:"+executeCommand(clientSentence)+"\n\r");
            }
        }catch(Exception e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
    }
    }
    private String executeCommand(String command) throws IOException{
        switch(command){
            case "date":
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
                return dtf.format(now);
            case "help":
                String response="\n\rhelp vypise napovedu\n\rdate vypise aktualni cas\n\rquote vypise nahodny citat\n\rhistory vypise historii prikazu\n\rstop-client stopne klienta\n\rstop-server stopne server";
                return response;
            case "quote":{
            	Random rd=new Random();
            	return quotes.get(rd.nextInt(quotes.size())+0);
            }
            case "history":
            	String result="";
            	for(int i=0;i<history.size();i++)
            		result+=history.get(i)+"\n\r";
            	return result;
            case "stop-client":
                isConnected=false;
                outToClient.writeBytes("Your connection is shutting down");
                outToClient.close();
                inFromClient.close();
                connectionSocket.close();
                System.out.println(getName()+" is shutting down the connection");
                return "";
            case "stop-server":
                outToClient.writeBytes("Server is shutting down");
                System.out.println("Server is shutting down due to client:"+getName());
                System.exit(0);
            default:
                return "Unknown Command";
            
        }
    }
    private ArrayList<String> makeQuotes() {
    	ArrayList<String> quotes=new ArrayList<>();
    	quotes.add("The greatest glory in living lies not in never falling, but in rising every time we fall. -Nelson Mandela");
        quotes.add("The way to get started is to quit talking and begin doing. -Walt Disney");
        quotes.add("Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking. -Steve Jobs");
        quotes.add("If life were predictable it would cease to be life, and be without flavor. -Eleanor Roosevelt");
        quotes.add("If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough. -Oprah Winfrey");
        quotes.add("If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.-James Cameron");
        return quotes;
    }

}