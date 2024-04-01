import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(8000);
		System.out.println("waiting for clients");
		Socket soc = new Socket();
		
		
		soc = ss.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		PrintWriter p = new PrintWriter(soc.getOutputStream(),true);
		BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
		String clientmsg="";
		
		while(true) {	
	
		
			clientmsg = in.readLine();
		
					if(clientmsg.equals("exit")) {
						p.println("GOOD BYE");
						break;
					}
			System.out.println("Client: "+clientmsg);		
		    String sreply = serverInput.readLine();			
		    p.println(sreply);
		}
		
	}
	
}
