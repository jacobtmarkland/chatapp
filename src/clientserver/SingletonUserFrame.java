package clientserver;

import userlist.UserFrame;
import userlist.NormalUserFrame;
import userlist.NormalID;
import userlist.AdminUserFrame;
import userlist.AdminID;

public class SingletonUserFrame {
	private volatile static SingletonUserFrame singleton;
	public UserFrame userFrame;
	
	private SingletonUserFrame(String a) {
		if(a.equals("r")) {
			userFrame = new NormalUserFrame(null,new NormalID(null,null));
		}
		if(a.equals("a")) {
			userFrame = new AdminUserFrame(null,new AdminID(null,null));
		}else {
			userFrame = new NormalUserFrame(null,new NormalID(null,null));
		}
	}
	public static SingletonUserFrame getInstance(String a) {
		if(singleton==null) {
			synchronized(SingletonUserFrame.class) {
				if(singleton==null) {
					singleton = new SingletonUserFrame(a);
				}
				return singleton;
			}
		}
		return singleton;
	}
}
