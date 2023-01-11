package shell;

import java.util.ArrayList;

import servercommand.Broadcast;

public class SingletonServerCommandList {
	private volatile static SingletonServerCommandList singleton;
	public ArrayList<Command> cmdList;
	
	private SingletonServerCommandList() {
		cmdList = new ArrayList<Command>();
		cmdList.add(new Broadcast());
	}
	public static SingletonServerCommandList getInstance() {
		if(singleton==null) {
			synchronized(SingletonServerCommandList.class) {
				if(singleton==null) {
					singleton = new SingletonServerCommandList();
				}
				return singleton;
			}
		}
		return singleton;
	}
}
