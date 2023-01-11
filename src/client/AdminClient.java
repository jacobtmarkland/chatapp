package client;

import clientgui.ClientGUI;
import clientgui.SingletonGUI;
import clientserver.ServerNetworkSetup;
import clientserver.SingletonNetwork;
import clientserver.SingletonUserFrame;

public class AdminClient extends AbstractClient{
	public AdminClient(){
		super(new ClientGUI("a"), new ServerNetworkSetup("a"), SingletonUserFrame.getInstance("a").userFrame);
		super.guiSetup = super.networkSetup.guiSetup();
		super.guiSetup.setNetworkSetup(super.networkSetup);
		SingletonGUI.getInstance("a").guiSetup = guiSetup;
		SingletonNetwork.getInstance("a").networkSetup = networkSetup;
	}
	public void go() {
		super.guiSetup().go();
		super.networkSetup().go();
	}
	public static void main(String[] args) {
		new AdminClient().go();
	}
}
