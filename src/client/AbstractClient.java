package client;

import java.util.HashMap;

import clientgui.GUISetup;
import clientserver.NetworkSetup;
import shell.Shell;
import userlist.UserFrame;

public abstract class AbstractClient implements Client{
	protected HashMap<String,Object> map;
	
	public AbstractClient(GUISetup guiSetup,NetworkSetup networkSetup, UserFrame userFrame, Shell shell) {
		map = new HashMap<String, Object>();
		map.put("guiSetup", guiSetup);
		map.put("networkSetup", networkSetup);
		map.put("userFrame", userFrame);
		map.put("shell", shell);
	}
	
	public void go() {
		try {
			GUISetup guiSetup = (GUISetup)map.get("guiSetup");
			UserFrame userFrame = (UserFrame)map.get("userFrame");
			NetworkSetup networkSetup = (NetworkSetup)map.get("networkSetup");
			Shell shell = (Shell)map.get("shell");
			guiSetup.go(userFrame, networkSetup, shell);
			networkSetup.go(userFrame, guiSetup);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public HashMap<String,Object> map(){
		return map;
	}
	
	

}
