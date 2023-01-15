package shell;

import java.util.ArrayList;

import clientcommand.ChangeClientColorCommand;
import clientcommand.ChangeNetworkButtonColorCommand;
import clientcommand.ChangeSendButtonColorCommand;
import clientcommand.ChangeTextAreaColorCommand;
import clientcommand.ChangeTextFieldColorCommand;
import clientgui.SingletonGUI;

public class SingletonClientCommandList {
	private volatile static SingletonClientCommandList singleton;
	public ArrayList<Command> cmdList;
	
	private SingletonClientCommandList(String a) {
		cmdList = new ArrayList<Command>();
		cmdList.add(new ChangeTextFieldColorCommand(SingletonGUI.getInstance().guiSetup.textField()));
		cmdList.add(new ChangeTextAreaColorCommand(SingletonGUI.getInstance().guiSetup.textArea()));
		cmdList.add(new ChangeSendButtonColorCommand(SingletonGUI.getInstance().guiSetup.sendButton()));
		cmdList.add(new ChangeNetworkButtonColorCommand(SingletonGUI.getInstance().guiSetup.connectButton()));
		cmdList.add(new ChangeClientColorCommand(SingletonGUI.getInstance().guiSetup.textArea(), SingletonGUI.getInstance().guiSetup.textField(), SingletonGUI.getInstance().guiSetup.sendButton(), SingletonGUI.getInstance().guiSetup.connectButton()));
		if(a.equals("a")) {
			
		}
	}
	public static SingletonClientCommandList getInstance(String a) {
		if(singleton==null) {
			synchronized(SingletonClientCommandList.class) {
				if(singleton==null) {
					singleton = new SingletonClientCommandList(a);
				}
				return singleton;
			}
		}
		return singleton;
	}
}
