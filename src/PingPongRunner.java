import java.util.Collections;

public class PingPongRunner {

	public static void main(String[] args) {
		int port = 25566;
		
		PongServer pos = new PongServer(port);
		pos.start();
		
		PingClient pic = new PingClient(port);
		pic.start();
	}

}
