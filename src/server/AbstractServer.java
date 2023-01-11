package server;

import servernetwork.NetworkSetup;
import userlist.IDSystem;
import userlist.UserListFormatter;

public abstract class AbstractServer implements Server{
	protected NetworkSetup networkSetup;
	protected UserListFormatter userList;
	protected IDSystem idSystem;
	
	public AbstractServer(NetworkSetup su, UserListFormatter li, IDSystem idSystem) {
		this.networkSetup = su;
		this.userList = li;
		this.idSystem = idSystem;
	}
	public void go() {
		networkSetup.go();
	}
	
	public UserListFormatter userList() {
		return userList;
	}
	public NetworkSetup networkSetup() {
		return networkSetup;
	}
	public void stop() {
		userList.userList().stop();
	}
	

}
