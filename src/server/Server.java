package server;

import servernetwork.NetworkSetup;
import userlist.UserListFormatter;

public interface Server {
	UserListFormatter userList();
	NetworkSetup networkSetup();
	void go();

}
