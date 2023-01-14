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
	JFrame frame();
	ClientColorScheme colorScheme();
	JTextField textField();
	JTextArea textArea();
	JButton sendButton();
	JButton connectButton();
	UserInput userInput();
	void paint(UserFrame userFrame, NetworkSetup networkSetup, Shell shell);
	void go(UserFrame userFrame, NetworkSetup networkSetup, Shell shell);
}
