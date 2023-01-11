package shell;

import java.util.ArrayList;

public class SingletonClientCommandList {
	private volatile static SingletonClientCommandList singleton;
	public ArrayList<Command> cmdList;
	
	private SingletonClientCommandList() {
		cmdList = new ArrayList<Command>();
		//cmdList.add(new Broadcast());
	}
	public static SingletonClientCommandList getInstance() {
		if(singleton==null) {
			synchronized(SingletonClientCommandList.class) {
				if(singleton==null) {
					singleton = new SingletonClientCommandList();
				}
				return singleton;
			}
		}
		return singleton;
	}
}
