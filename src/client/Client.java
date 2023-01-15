package client;

import java.util.HashMap;

import clientgui.GUISetup;
import clientserver.NetworkSetup;
import shell.Shell;
import userlist.UserFrame;

public interface Client {
	public void go();
	public HashMap<String,Object> map();
}
