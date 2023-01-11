package servernetwork;

import userlist.IDSystem;
import userlist.UserList;

public interface NetworkSetup {
	void go();
	boolean online();
	UserList userList();
	IDSystem idSystem();
}
