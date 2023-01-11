package userlist;

public class SingletonUserList {
	private volatile static SingletonUserList singleton;
	public UserList userList;
	
	private SingletonUserList() {
		userList = new ServerUserList();
	}
	public static SingletonUserList getInstance() {
		if(singleton==null) {
			synchronized(SingletonUserList.class) {
				if(singleton==null) {
					singleton = new SingletonUserList();
				}
				return singleton;
			}
		}
		return singleton;
	}

}
