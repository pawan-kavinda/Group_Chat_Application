import java.io.*;
import java.net.Socket;


public class client {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
				Socket soc = new Socket("localhost",8000);				
				System.out.println("Enter Username");	
				 	
				PrintWriter clientMessage = new PrintWriter(soc.getOutputStream(),true);
				BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));	
				
				BufferedReader serverBuffer = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				String clientmsg = "";
				
				while(true) {
					
					clientmsg = clientInput.readLine();					
				    clientMessage.println(clientmsg);							
					
				    System.out.println("Server: "+serverBuffer.readLine());
         
				}
	}
}
