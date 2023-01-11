package userlist;

import java.util.ArrayList;

import shell.Command;

public interface UserInput {
	void readLine(String a);
	String currLine();
	boolean isUserInput();
}
