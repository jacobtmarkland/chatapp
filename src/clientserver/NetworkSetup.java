package clientserver;

import clientgui.GUISetup;
import userlist.UserFrame;

public interface NetworkSetup {
	void go(UserFrame userFrame, GUISetup guiSetup);
	void sendMessage(String a);
	boolean online();
	Server server();
}
