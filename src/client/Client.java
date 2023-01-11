package client;

import clientgui.GUISetup;
import clientserver.NetworkSetup;
import userlist.UserFrame;

public interface Client {
	GUISetup guiSetup();
	NetworkSetup networkSetup();
	UserFrame userFrame();
	public void go();
}
