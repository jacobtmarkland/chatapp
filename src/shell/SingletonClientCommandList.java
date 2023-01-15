package shell;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		try {
				JTextField textField = (JTextField)SingletonGUI.getInstance().guiSetup.map().get("textField");
				JTextArea textArea = (JTextArea)SingletonGUI.getInstance().guiSetup.map().get("textArea");
				JButton sendButton = (JButton)SingletonGUI.getInstance().guiSetup.map().get("sendButton");
				JButton networkButton = (JButton)SingletonGUI.getInstance().guiSetup.map().get("networkButton");
				
				cmdList = new ArrayList<Command>();
				cmdList.add(new ChangeTextFieldColorCommand(textField));
				cmdList.add(new ChangeTextAreaColorCommand(textArea));
				cmdList.add(new ChangeSendButtonColorCommand(sendButton));
				cmdList.add(new ChangeNetworkButtonColorCommand(networkButton));
				cmdList.add(new ChangeClientColorCommand(textArea,textField,sendButton,networkButton));
				if(a.equals("a")) {
					
				}
		}
		catch(Exception e) {
			e.printStackTrace();
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
