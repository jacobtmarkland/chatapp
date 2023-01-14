package shell;

import java.util.ArrayList;

public class SingletonClientCommandList {
	private volatile static SingletonClientCommandList singleton;
	public ArrayList<Command> cmdList;
	
	private SingletonClientCommandList(String a) {
		cmdList = new ArrayList<Command>();
		if(a.equals("a")) {
			
		}else {
			
		}
	}
	public static SingletonClientCommandList getInstance(String a) {
		if(singleton==null) {
			synchronized(SingletonClientCommandList.class) {
				if(singleton==null) {
					singleton = new SingletonClientCommandList(a);
				}
				return singleton;
			}
		}
		return singleton;
	}
}
