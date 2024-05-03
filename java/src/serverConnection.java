import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
//for continously chat for the client
public class serverConnection implements Runnable{
    private Socket server;
    private BufferedReader in;
   
    public serverConnection(Socket s) throws IOException {
        server = s;
        in = new BufferedReader(new InputStreamReader(server.getInputStream()));      
    }
    @Override
    public void run() {      
            try {
                while (true) {
                    String serverResponse;
                    serverResponse = in.readLine();
                    System.out.println(serverResponse);
                }
               
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }         
           
        }       // TODO Auto-generated method stub       
    
}
