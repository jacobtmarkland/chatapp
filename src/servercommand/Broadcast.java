package servercommand;

import java.util.ArrayList;

import shell.AbstractCommand;
import shell.BroadCaster;
import shell.Option;
import shell.Parameter;
import shell.ServerBroadCaster;

public class Broadcast extends AbstractCommand{
	protected final BroadCaster broadcaster;

	public Broadcast() {
		super("Broadcast","broadcast");
		this.broadcaster = new ServerBroadCaster();
		super.options.add(new EveryoneOption());
		super.parameters.add(new BroadcastParamter());
	}

	public String execute(ArrayList<Option> options, ArrayList<Parameter> parameters) {
		if(options.size() > 1) {
			return super.invalidOption+"\nYou can only choose one communication type\n"+super.invalidOption;
		}
		if(parameters.size()!=1) {
			return super.invalidParameter+"\nYou have to have a single name parameter with no spaces\n"+super.invalidParameter;
		}
		for(Option a:options) {
			if(a.keyCode().equals(this.options.get(0).keyCode())) {
				broadcaster.sendAll(parameters.get(0).value());
				return super.success+"\nMessage broadcasted: " + parameters.get(0).value() + "\n"+super.success;
			}
		}
		if(options.size()==0) {
			broadcaster.sendAll(parameters.get(0).value());
			return super.success+"\nMessage broadcasted: " + parameters.get(0).value() + "\n"+super.success;
		}
		return super.fail;
		
	}

}
