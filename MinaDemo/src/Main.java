
import server.Initialization;
import server.MinaShortConnServer;
import server.MinaLongConnServer;

public class Main {
	public static void main(String[] args) throws Exception {
		Initialization.getInstance().init();
		MinaShortConnServer server1 = new MinaShortConnServer();
		server1.start();
		MinaLongConnServer server2 = new MinaLongConnServer();
		server2.start();
	}
}
