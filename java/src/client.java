import java.io.*;
import java.net.Socket;


public class client {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
				Socket soc = new Socket("localhost",8000);				
				System.out.println("Enter Username");	
				serverConnection serverConnection = new serverConnection(soc); 	
				PrintWriter clientMessage = new PrintWriter(soc.getOutputStream(),true);
				BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));			
				String clientmsg = "";
				String userName = null;
				new Thread(serverConnection).start();
				while(true) {
					if(userName==null){
						userName = clientInput.readLine();
					}else
					
					{
						clientmsg = clientInput.readLine();	
						if(clientmsg.equals("quit")){
							clientMessage.println(userName+" has left the chat");
							break;
						}
							
						clientMessage.println(userName+">> "+clientmsg);		
					}					
					
				  //  System.out.println("Server: "+serverBuffer.readLine());
         
				}
	}
}
