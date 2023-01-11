package client;

import clientgui.GUISetup;
import clientserver.NetworkSetup;
import userlist.UserFrame;

public abstract class AbstractClient implements Client{
	protected GUISetup guiSetup;
	protected NetworkSetup networkSetup;
	protected UserFrame userFrame;
	
	public AbstractClient(GUISetup guiSetup,NetworkSetup networkSetup, UserFrame userFrame) {
		this.guiSetup = guiSetup;
		this.networkSetup = networkSetup;
		this.userFrame = userFrame;
	}
	
	public void go() {
		guiSetup.go();
		networkSetup.go();
	}
	public GUISetup guiSetup() {
		return this.guiSetup;
	}
	public NetworkSetup networkSetup() {
		return this.networkSetup;
	}
	public UserFrame userFrame() {
		return this.userFrame;
	}
	
	

}
