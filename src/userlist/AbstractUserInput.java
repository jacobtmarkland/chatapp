package userlist;

import java.util.ArrayList;

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
	
	public String getCommand(){
		try {
			String edit = currLine();
			ArrayList<String> parameter = new ArrayList<String>();
			String newLine = "";
			String parameterLine = "";
			boolean onParameter = false;
			for(int i = 0; i < edit.length(); i++) {
				if(edit.charAt(i)=='(') {
					onParameter = true;
				}
				if(!onParameter) {
					newLine+=edit.charAt(i);
				}else {
					parameterLine+=edit.charAt(i);
				}
				if(edit.charAt(i)==')') {
					onParameter=false;
					parameter.add(parameterLine);
					parameterLine="";
				}
			}
			for(String para:parameter) {
				newLine+=" "+para;
			}
			String newerLine = "";
			boolean onespace = false;
			for(int i = 0; i < newLine.length();i++) {
				if(!(newLine.charAt(i)==' ')) {
					onespace = false;
					newerLine+=newLine.charAt(i);
				}else if(onespace==false){
					onespace=true;
					newerLine+=newLine.charAt(i);
				}
			}
			String newestString = "";
			onParameter = false;
			for(int i = 0; i < newerLine.length();i++) {
				if(edit.charAt(i)=='(') {
					onParameter = true;
				}
				if(!onParameter && edit.charAt(i)==' ') {
					newestString+=";";
				}else if (!onParameter){
					newestString+=edit.charAt(i);
				}
				if(onParameter) {
					newestString += edit.charAt(i);
				}
				if(edit.charAt(i)==')') {
					onParameter=false;
				}
			}
			
			return newestString;
		}catch(Exception e) {
			e.printStackTrace();
			return "/";
		}
	}

}
