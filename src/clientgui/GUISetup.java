package clientgui;

import java.util.HashMap;

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
	void paint(UserFrame userFrame, NetworkSetup networkSetup, Shell shell);
	void go(UserFrame userFrame, NetworkSetup networkSetup, Shell shell);
	HashMap<String, Object> map();
}
