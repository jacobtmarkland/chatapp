package client;

import clientgui.ClientGUI;
import clientgui.SingletonGUI;
import clientserver.ServerNetworkSetup;
import clientserver.SingletonNetwork;
import clientserver.SingletonUserFrame;
import colorscheme.ClientColorScheme;
import userlist.NormalID;
import userlist.NormalUserFrame;
import userlist.SingletonIDSystem;

public class DefaultClient extends AbstractClient{
	
	public DefaultClient(){
		super(new ClientGUI("r"), new ServerNetworkSetup("r"), SingletonUserFrame.getInstance("r").userFrame);
		super.guiSetup = super.networkSetup.guiSetup();
		super.guiSetup.setNetworkSetup(super.networkSetup);
		SingletonGUI.getInstance("r").guiSetup = guiSetup;
		SingletonNetwork.getInstance("r").networkSetup = networkSetup;
	}
	public void go() {
		super.guiSetup().go();
		super.networkSetup().go();
	}
	public static void main(String[] args) {
		new DefaultClient().go();
	}
}