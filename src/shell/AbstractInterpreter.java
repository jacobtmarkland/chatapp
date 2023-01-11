package shell;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractInterpreter implements Interpreter{
	protected ArrayList<Command> cmdList;
	protected Command cmd;
	protected ArrayList<Option> optionList;
	protected ArrayList<Parameter> parameterList;
	protected HashMap<String, String> map;
	
	public AbstractInterpreter(ArrayList<Command> cmdList) {
		this.cmdList = cmdList;
		clearList();
		setMap();
	}
	
	public void setMap() {
		map = new HashMap<String,String>();
		for(Command cmd:cmdList) {
			String keyCode = cmd.keyCode().toLowerCase();
			map.put(keyCode, keyCode);
		}
	}
	
	public void clearList() {
		cmd=null;
		optionList = new ArrayList<Option>();
		parameterList = new ArrayList<Parameter>();
	}
	
	public String interpret(String input) {
		clearList();
		input = input.toLowerCase();
		int n = input.length();
		if(n<2) {
			return AbstractCommand.invalidCommand;
		}
		input = input.substring(1, n);
		String[] format = input.split(";");
		boolean help = false;
		if(format.length > 0) {
			if(format[0].equals("help")) {
				help=true;
			}
		}
		for(String snip:format) {
			run(snip);
		}
		if(cmd==null) {
			return AbstractCommand.invalidCommand;
		}else {
			if(help==false) {
				return cmd.execute(optionList, parameterList);
			}else {
				return cmd.help();
			}
		}
	}
	
	protected void run(String cmdSnip) {
		if(isCommand(cmdSnip)) {
			
		}else if(isOption(cmdSnip)) {
			
		}else if(isParameter(cmdSnip)){
		}
	}
	
	protected boolean isParameter(String cmdSnip) {
		int n = cmdSnip.length();
		if(n>2) {
			if(cmdSnip.charAt(0)=='(' && cmdSnip.charAt(n-1)==')') {
				cmdSnip = cmdSnip.substring(1,n-1);
				parameterList.add(new SystemParameter(cmdSnip));
				return true;
			}
		}
		return false;
	}
	
	protected boolean isOption(String cmdSnip) {
		int n = cmdSnip.length();
		if(n>1) {
			if(cmdSnip.charAt(0)=='-') {
				cmdSnip = cmdSnip.substring(1,n);
				if(cmd!=null) {
					for(Option op:cmd.options()) {
						if(op.keyCode().equals(cmdSnip)) {
							optionList.add(op);
							return true;
						}
					}
					return false;
				}
			}
		}
		return false;
	}
	
	protected boolean isCommand(String keyCode) {
		if(map.containsKey(keyCode)) {
			for(Command cmd:cmdList) {
				if(cmd.keyCode().equals(keyCode)) {
					this.cmd=cmd;
					return true;
				}
			}
		}
		return false;
	}
	public ArrayList<Command> cmdList() {
		return cmdList;
	}
	public ArrayList<Option> optionList() {
		return optionList;
	}
	public ArrayList<Parameter> parameterList() {
		return parameterList;
	}

	public Command cmd() {
		return cmd;
	}

}
