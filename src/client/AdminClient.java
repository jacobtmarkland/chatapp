package client;

import clientgui.SingletonGUI;
import clientserver.SingletonNetwork;
import clientserver.SingletonUserFrame;
import shell.ClientShell;

public class AdminClient extends AbstractClient{
	public AdminClient(){
		super(SingletonGUI.getInstance().guiSetup, SingletonNetwork.getInstance().networkSetup,SingletonUserFrame.getInstance("a").userFrame, new ClientShell("a"));
	
	}
	public static void main(String[] args) {
		new AdminClient().go();
	}
}
