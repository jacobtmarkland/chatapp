package shell;

import userlist.User;
import userlist.UserList;

public abstract class AbstractBroadCaster implements BroadCaster{
	protected UserList userList;
	
	public AbstractBroadCaster(UserList userList) {
		this.userList = userList;
	}
	public void sendAll(String text) {
		for(User usr:userList.userList()) {
			usr.sendMessage(text);
		}
	}

	public UserList userList() {
		return userList;
	}

}
