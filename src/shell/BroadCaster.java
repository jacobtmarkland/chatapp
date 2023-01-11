package shell;

import userlist.UserList;

public interface BroadCaster {
	void sendAll(String text);
	UserList userList();
}
