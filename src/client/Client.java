package client;

import clientgui.GUISetup;
import clientserver.NetworkSetup;
import shell.Shell;
import userlist.UserFrame;

public interface Client {
	GUISetup guiSetup();
	NetworkSetup networkSetup();
	UserFrame userFrame();
	Shell shell();
	public void go();
}
