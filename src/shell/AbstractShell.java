package shell;

import java.util.ArrayList;

public abstract class AbstractShell implements Shell{
	protected ArrayList<Command> cmdList;
	protected Interpreter interpreter;
	protected String currLine;
	
	public AbstractShell(Interpreter interpreter,ArrayList<Command> cmdList) {
		this.cmdList = cmdList;
		this.interpreter = interpreter;
		currLine="";
	}
	
	
	public String executeCmd() {
		return interpreter.interpret(currLine);
	}
	public void setCmd(ArrayList<Command> cmdList) {
		this.cmdList = cmdList;
		
	}
	public ArrayList<Command> cmdList() {
		return cmdList;
	}

	public String currLine() {
		return currLine;
	}
	public Interpreter interpreter() {
		return interpreter;
	}
	public void readLine(String a) {
		currLine = a;
	}

}
