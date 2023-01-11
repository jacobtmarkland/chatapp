package shell;

import java.util.ArrayList;

public abstract class AbstractCommand implements Command{
	
	protected String name;
	protected String keyCode;
	protected String help;
	protected ArrayList<Option> options;
	protected ArrayList<Parameter> parameters;
	public static final String formatBar = "###############Shell 1.0###############\n";
	public static final String invalidCommand = "###############invalid Command###############\n";
	public static final String invalidParameter = "###############invalid Paramater###############\n";
	public static final String invalidOption = "###############invalid Option###############\n";
	public static final String success = "###############success###############\n";
	public static final String fail = "###############fail###############\n";
	public AbstractCommand(String name, String keyCode) {
		this.name = name;
		this.keyCode = keyCode;
		this.options = new ArrayList<Option>();
		this.parameters = new ArrayList<Parameter>();
		help = help();
	}

	public String name() {
		return name;
	}

	public String keyCode() {
		return keyCode;
	}

	public ArrayList<Option> options() {
		return options;
	}

	public ArrayList<Parameter> parameters() {
		return parameters;
	}

	public abstract String execute(ArrayList<Option> options, ArrayList<Parameter> parameters);

	public String help() {
		if(help!=null)return help;
		help = "Syntax:"+name+" [options] [parameters]\n";
		help += "Syntax2: [options] ex. -o1 -o2\n";
		help += "Syntax3: [parameters] ex. p1 p2\n";
		help+=formatBar;
		help+="Options:\n";
		for(Option op:options) {
			help+=op.toString()+"\n";
		}
		help+=formatBar;
		help+=formatBar;
		help+="Parameters:\n";
		for(Parameter para:parameters) {
			help+=para.toString()+"\n";
		}
		help+=formatBar;
		return help;
		
	}

}
