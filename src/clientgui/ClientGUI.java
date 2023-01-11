package clientgui;

import clientserver.NetworkSetup;
import clientserver.SingletonNetwork;
import clientserver.SingletonUserFrame;
import colorscheme.ClientColorScheme;
import userlist.UserFrame;

public class ClientGUI extends AbstractGUISetup{

	public ClientGUI(UserFrame userFrame,NetworkSetup networkSetup) {
		super(userFrame,networkSetup);
	}
	public ClientGUI(String a) {
		super(SingletonUserFrame.getInstance(a).userFrame, SingletonNetwork.getInstance(a).networkSetup);
		SingletonNetwork.getInstance(a).networkSetup.setGUI(this);
	}


}
