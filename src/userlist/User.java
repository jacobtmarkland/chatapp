package userlist;

import java.util.ArrayList;

import shell.Command;
import shell.Shell;

public interface User extends Runnable{
	void run();
	void sendMessage(String a);
	UserFrame userFrame();
	Shell shell();
	UserInput userInput();
}
