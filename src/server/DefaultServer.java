package server;

import servernetwork.ServerNetworkSetup;
import userlist.ServerUserListFormatter;
import userlist.SingletonBlockList;
import userlist.SingletonIDSystem;
import userlist.SingletonUserList;

public class DefaultServer extends AbstractServer{
	public DefaultServer() {
		super(new ServerNetworkSetup(SingletonUserList.getInstance().userList, SingletonIDSystem.getInstance().idSystem), new ServerUserListFormatter(SingletonUserList.getInstance().userList, SingletonBlockList.getInstance().map), SingletonIDSystem.getInstance().idSystem);
	}
	public static void main(String[] args) {
		new DefaultServer();
	}
	
  
}