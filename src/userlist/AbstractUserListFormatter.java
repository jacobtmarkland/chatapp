package userlist;

import java.util.HashMap;

public abstract class AbstractUserListFormatter implements UserListFormatter{
	protected UserList userList;
	protected HashMap<Integer,Integer> blockList;
	public AbstractUserListFormatter(UserList userList, HashMap<Integer, Integer> blockList) {
		this.userList = userList;
		this.blockList = blockList;
	}
	
	public UserList userList() {
		return userList;
	}
	public HashMap<Integer, Integer> map() {
		return blockList;
	}

	public abstract String toString();
}
