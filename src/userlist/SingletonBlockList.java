package userlist;

import java.util.HashMap;

public class SingletonBlockList {
	private volatile static SingletonBlockList singleton;
	public HashMap<Integer,Integer> map;
	
	private SingletonBlockList() {
		map = new HashMap<Integer,Integer>();
	}
	public static SingletonBlockList getInstance() {
		if(singleton==null) {
			synchronized(SingletonUserList.class) {
				if(singleton==null) {
					singleton = new SingletonBlockList();
				}
				return singleton;
			}
		}
		return singleton;
	}
}
