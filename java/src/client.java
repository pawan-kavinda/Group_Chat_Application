import java.io.*;
import java.net.Socket;


public class client {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
				Socket soc = new Socket("localhost",8000);				
				System.out.println("Enter Username");	
				 	
				PrintWriter p = new PrintWriter(soc.getOutputStream(),true);
				BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));	
				
				BufferedReader servermsg = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				String clientmsg = "";
				
				while(true) {
				
					clientmsg = userInput.readLine();
				
				    p.println(clientmsg);					
				
				    System.out.println("Server: "+servermsg.readLine());
         
				}
	}
}
