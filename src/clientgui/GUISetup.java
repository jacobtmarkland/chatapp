package clientgui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clientserver.NetworkSetup;
import colorscheme.ClientColorScheme;
import shell.Shell;
import userlist.UserFrame;
import userlist.UserInput;

public interface GUISetup {
	NetworkSetup networkSetup();
	void setNetworkSetup(NetworkSetup a);
	JFrame frame();
	ClientColorScheme colorScheme();
	JTextField textField();
	JTextArea textArea();
	JButton sendButton();
	JButton connectButton();
	UserFrame userFrame();
	UserInput userInput();
	Shell shell();
	void go();
}
