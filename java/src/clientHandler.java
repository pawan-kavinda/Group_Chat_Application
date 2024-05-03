import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class clientHandler implements Runnable {
		String clientmsg;
        private Socket client;
        private BufferedReader input;
        private BufferedReader in;
        private PrintWriter out;
        private  ArrayList<clientHandler> clientArray ;

        public clientHandler(Socket socket, ArrayList<clientHandler> clientArray) {           
            try {
                this.client = socket;
                this.clientArray = clientArray;
                input = new BufferedReader(new InputStreamReader(System.in));
                out =new PrintWriter(client.getOutputStream(),true);
                in= new BufferedReader(new InputStreamReader(client.getInputStream()));
                clientmsg="";

            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }        
        
        @Override
        public void run(){
            while(true) {			
                try {
                    clientmsg = in.readLine();
                    if(clientmsg.equals("exit")) {
                        out.println("GOOD BYE");
                        in.close();
                        out.close();
                        input.close();
                        client.close();                            
                    }
            outToAll(clientmsg);            
        }	
                catch (IOException e) {
                    
                    e.printStackTrace();
                }                     
        }         
        
    }
    public void outToAll(String clientmsg){
        for(clientHandler aclient:clientArray ){
            aclient.out.println(clientmsg);
        }
    }

}
