package client;

import clientgui.GUISetup;
import clientserver.NetworkSetup;
import shell.Shell;
import userlist.UserFrame;

public abstract class AbstractClient implements Client{
	protected GUISetup guiSetup;
	protected NetworkSetup networkSetup;
	protected UserFrame userFrame;
	protected Shell shell;
	
	public AbstractClient(GUISetup guiSetup,NetworkSetup networkSetup, UserFrame userFrame, Shell shell) {
		this.guiSetup = guiSetup;
		this.networkSetup = networkSetup;
		this.userFrame = userFrame;
		this.shell = shell;
	}
	
	public void go() {
		guiSetup.go(userFrame, networkSetup, shell);
		networkSetup.go(userFrame, guiSetup);
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
	public Shell shell() {
		return shell;
	}
	
	

}
