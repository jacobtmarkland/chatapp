package clientserver;

import clientgui.GUISetup;
import clientgui.SingletonGUI;
import userlist.UserFrame;

public class ServerNetworkSetup extends AbstractNetworkSetup{
	public ServerNetworkSetup(GUISetup setup, UserFrame userFrame) {
		super(setup,userFrame);
	}
	public ServerNetworkSetup(UserFrame userFrame) {
		super(userFrame);
	}
	public ServerNetworkSetup(String a) {
		super(SingletonGUI.getInstance(a).guiSetup,SingletonUserFrame.getInstance(a).userFrame);
	}
}
