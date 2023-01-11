package clientserver;

import clientgui.ClientGUI;
import clientgui.SingletonGUI;
import userlist.ServerUserList;
import userlist.SingletonUserList;
import userlist.UserList;

public class SingletonNetwork {
	private volatile static SingletonNetwork singleton;
	public NetworkSetup networkSetup;
	
	private SingletonNetwork(String a) {
		if(a.equals("r")) {
			networkSetup = new ServerNetworkSetup(SingletonUserFrame.getInstance(a).userFrame);
		}else if(a.equals("a")) {
			networkSetup = new ServerNetworkSetup(SingletonUserFrame.getInstance(a).userFrame);
		}
	}
	public static SingletonNetwork getInstance(String a) {
		if(singleton==null) {
			synchronized(SingletonNetwork.class) {
				if(singleton==null) {
					singleton = new SingletonNetwork(a);
				}
				
				return singleton;
			}
		}
		return singleton;
	}
}
