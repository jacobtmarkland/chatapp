package clientserver;

import clientgui.GUISetup;
import userlist.UserFrame;

public interface NetworkSetup {
	void go();
	void sendMessage(String a);
	void setGUI(GUISetup a);
	boolean online();
	Server server();
	GUISetup guiSetup();
	UserFrame userFrame();
}
