import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingClient extends PingPongCommon {

	public PingClient(int port){
		super(port, "Ping Thread");
		System.out.println("Created new Ping client");
	}
	
	@Override
	public void run(){
		System.out.println("New ping thread!\n");
		try {
			//socket used to talk to the server
			Socket pongSocket = new Socket("localhost", this.getPort());
			//output stream
			PrintWriter out = new PrintWriter(pongSocket.getOutputStream(), true);
			//input from Socket Stream
			BufferedReader in = new BufferedReader(new InputStreamReader(pongSocket.getInputStream()));
			//input from Console (user input) stream
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			//get user input, send it to the server, print the reply, repeat.
			System.out.println("Say something to the other server. Or type quit to quit.");
			String userInput, serverReply;
			while((userInput = stdIn.readLine()) != null && !userInput.equals("quit")){
				System.out.println("Sending \"" + userInput + "\" to the server!");
				out.println(userInput);
				System.out.println("Waiting for server reply");
				serverReply = in.readLine();
				System.out.println("Server Says: " + serverReply);
				System.out.println("\nSay something to the other server. Or type quit to quit.");
			}
			
			//Done, close 'er on up boy.
			System.out.println("Bye!");
			stdIn.close();
			in.close();
			out.close();
			pongSocket.close();
		} catch (UnknownHostException e) {
			System.out.println("Error, host not found. Ya fucked up real good.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error, IO exception bud.");
			e.printStackTrace();
		}
		System.out.println("Shutting ping thread down");
	}
}
