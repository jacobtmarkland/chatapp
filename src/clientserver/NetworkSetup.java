package clientserver;

import java.util.HashMap;

import clientgui.GUISetup;
import userlist.UserFrame;

public interface NetworkSetup {
	void go(UserFrame userFrame, GUISetup guiSetup);
	void sendMessage(String a);
	HashMap<String, Object> map();
}
