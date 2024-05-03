import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server {
	private static ExecutorService pool = Executors.newFixedThreadPool(4);				
	private static ArrayList<clientHandler> clientHandlers = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		System.out.println("waiting for clients");
		ServerSocket ss = new ServerSocket(8000);		
		
		while(true) {			
			Socket soc = new Socket();			
			soc = ss.accept();			
			System.out.println("Client Connected");
			clientHandler clientThread = new clientHandler(soc, clientHandlers);
			clientHandlers.add(clientThread);
			pool.execute(clientThread);			
			
		}		
	}
		
	
}
