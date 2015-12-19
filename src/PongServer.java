import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PongServer extends PingPongCommon {

	public PongServer(int port){
		super(port, "Pong Thread");
		System.out.println("Created new Pong Client");
	}
	
	@Override
	public void run(){
		System.out.println("New pong thread!\n");
		try {
			ServerSocket pongSocket = new ServerSocket(this.getPort());
			System.out.println("\t-Server is HOT");
			Socket clientSocket = pongSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine, outputLine = "";
			System.out.println("\tWaiting.");
			while((inputLine = in.readLine())!=null){
				System.out.println("\t-Pong recieved: \"" + inputLine + "\"");
				System.out.println("\t-Replying");
				out.println("Pong");
				System.out.println("\t-Pong ready");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("Shutting pong thread down");
	}
}