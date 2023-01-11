package shell;

import java.util.ArrayList;

public interface Command {
	String name();
	String keyCode();
	ArrayList<Option> options();
	ArrayList<Parameter> parameters();
	String execute(ArrayList<Option> options, ArrayList<Parameter> parameters);
	String help();
}
