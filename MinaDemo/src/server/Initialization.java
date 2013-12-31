package server;

import java.util.HashMap;
import org.apache.mina.core.session.IoSession;

public class Initialization {
	private static Initialization instance;
	private HashMap<String, IoSession> clientMap;

	public Initialization() {

	}

	public static Initialization getInstance() {
		if (instance == null)
			instance = new Initialization();
		return instance;
	}

	public void init() {
		HashMap<String, IoSession> clientMap = new HashMap<String, IoSession>();
		this.clientMap = clientMap;
	}

	public HashMap<String, IoSession> getClientMap() {
		return clientMap;
	}

	public void setClientMap(HashMap<String, IoSession> clientMap) {
		this.clientMap = clientMap;
	}

}
