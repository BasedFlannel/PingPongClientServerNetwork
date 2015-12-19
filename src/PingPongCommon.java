
public class PingPongCommon implements Runnable {
	int port;
	private Thread t;
	
	public PingPongCommon(int Port, String ThreadName){
		this.port = Port;
		System.out.println("Created new Common Ping Pong Object");
		t = new Thread(this, ThreadName);
	}

	@Override
	public void run() {
		System.out.println("This thread does nothing.");
	}
	public void start(){
		System.out.println("Starting Thread " + t.getName());
		t.start();
	}
	public Thread getThread(){
		return t;
	}
	
	public int getPort(){
		return this.port;
	}
	
}
