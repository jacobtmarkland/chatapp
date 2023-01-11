package userlist;

import java.util.ArrayList;

import shell.Command;

public abstract class AbstractUserInput implements UserInput{
	protected String currLine;
	
	public AbstractUserInput() {
		currLine="";
	}
	
	public void readLine(String a) {
		this.currLine = a;
	}
	
	public String currLine() {
		return this.currLine;
	}

	public boolean isUserInput() {
		if(currLine.length() > 9) {
			String broadCastCommand = currLine.substring(0, 10);
			if(broadCastCommand.equals("/broadcast")) {
				return true;
			}
		}
		return false;
	}

}
