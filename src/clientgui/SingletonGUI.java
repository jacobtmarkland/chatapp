package clientgui;

public class SingletonGUI {
	private volatile static SingletonGUI singleton;
	public GUISetup guiSetup;
	
	private SingletonGUI() {
		guiSetup = new ClientGUI();
		}
	public static SingletonGUI getInstance() {
		if(singleton==null) {
			synchronized(SingletonGUI.class) {
				if(singleton==null) {
					singleton = new SingletonGUI();
				}
				return singleton;
			}
		}
		return singleton;
	}
}
