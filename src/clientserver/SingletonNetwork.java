package clientserver;

public class SingletonNetwork {
	private volatile static SingletonNetwork singleton;
	public NetworkSetup networkSetup;
	
	private SingletonNetwork() {
		networkSetup = new ServerNetworkSetup();
	}
	public static SingletonNetwork getInstance() {
		if(singleton==null) {
			synchronized(SingletonNetwork.class) {
				if(singleton==null) {
					singleton = new SingletonNetwork();
				}
				
				return singleton;
			}
		}
		return singleton;
	}
}
