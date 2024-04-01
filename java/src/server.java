import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(8000);
		System.out.println("waiting for clients");
		Socket soc = new Socket();
		
		soc = ss.accept();
		System.out.println("Client Connected");
		BufferedReader clientBuffer = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		PrintWriter serverOut = new PrintWriter(soc.getOutputStream(),true);
		BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
		String clientmsg="";
		
		while(true) {		
		
			clientmsg = clientBuffer.readLine();		
					if(clientmsg.equals("exit")) {
						serverOut.println("GOOD BYE");
						clientBuffer.close();
						serverOut.close();
						serverInput.close();
						soc.close();
						
					}
			System.out.println("Client: "+clientmsg);		
		    String sreply = serverInput.readLine();			
		    serverOut.println(sreply);
		}		
	}
		
	
}
