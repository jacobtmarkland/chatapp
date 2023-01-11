package shell;

import java.util.ArrayList;

public interface Interpreter {
	String interpret(String input);
	ArrayList<Command> cmdList();
	ArrayList<Option> optionList();
	ArrayList<Parameter> parameterList();
	Command cmd();
}
