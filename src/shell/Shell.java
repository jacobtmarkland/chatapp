package shell;

import java.util.ArrayList;

public interface Shell {
	String executeCmd();
	void setCmd(ArrayList<Command> list);
	ArrayList<Command> cmdList();
	String currLine();
	void readLine(String a);
	Interpreter interpreter();
}
