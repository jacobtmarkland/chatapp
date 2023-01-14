package client;

import clientgui.ClientGUI;
import clientgui.SingletonGUI;
import clientserver.ServerNetworkSetup;
import clientserver.SingletonNetwork;
import clientserver.SingletonUserFrame;
import colorscheme.ClientColorScheme;
import shell.ClientShell;
import userlist.NormalID;
import userlist.NormalUserFrame;
import userlist.SingletonIDSystem;

public class DefaultClient extends AbstractClient{
	
	public DefaultClient(){
		super(SingletonGUI.getInstance().guiSetup, SingletonNetwork.getInstance().networkSetup,SingletonUserFrame.getInstance("r").userFrame, new ClientShell("r"));
	}
	public static void main(String[] args) {
		new DefaultClient().go();
	}
}