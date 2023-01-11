package userlist;

public class SingletonIDSystem {
	private volatile static SingletonIDSystem singleton;
	public IDSystem idSystem;
	
	private SingletonIDSystem() {
		idSystem = new ServerIDSystem();
	}
	public static SingletonIDSystem getInstance() {
		if(singleton == null) {
			synchronized(SingletonIDSystem.class) {
				if(singleton==null) {
					singleton = new SingletonIDSystem();
				}
				return singleton;
			}
		}
		return singleton;
	}
}
