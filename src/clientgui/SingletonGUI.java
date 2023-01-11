package clientgui;

import clientserver.SingletonNetwork;

public class SingletonGUI {
	private volatile static SingletonGUI singleton;
	public GUISetup guiSetup;
	
	private SingletonGUI(String a) {
		guiSetup = new ClientGUI(a);
		guiSetup.setNetworkSetup(SingletonNetwork.getInstance(a).networkSetup);
		SingletonNetwork.getInstance(a).networkSetup.setGUI(this.guiSetup);
	}
	public static SingletonGUI getInstance(String a) {
		if(singleton==null) {
			synchronized(SingletonGUI.class) {
				if(singleton==null) {
					singleton = new SingletonGUI(a);
				}
				return singleton;
			}
		}
		return singleton;
	}
}
