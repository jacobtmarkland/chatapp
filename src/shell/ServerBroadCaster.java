package shell;

import userlist.SingletonUserList;

public class ServerBroadCaster extends AbstractBroadCaster{
	public ServerBroadCaster() {
		super(SingletonUserList.getInstance().userList);
	}

}
