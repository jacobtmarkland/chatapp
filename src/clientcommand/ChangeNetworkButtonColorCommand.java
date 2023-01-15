package clientcommand;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

import colorscheme.ColorPalette;
import colorscheme.DefaultColorPalette;
import shell.AbstractCommand;
import shell.Option;
import shell.Parameter;

public class ChangeNetworkButtonColorCommand extends AbstractCommand{

	protected JButton jButton;
	protected ColorPalette colorPalette;
	
	public ChangeNetworkButtonColorCommand(JButton jButton) {
		super("Change network button color", "changenetworkbutton");
		super.parameters.add(new ColorParameter());
		super.options.add(new ForegroundOption());
		super.options.add(new BackgroundOption());
		this.jButton = jButton;
		this.colorPalette = new DefaultColorPalette();
	}

	public String execute(ArrayList<Option> options, ArrayList<Parameter> parameters) {
		if(options.size() > 2) {
			return super.invalidOption+"\nYou can choose up to two options\n"+super.invalidOption;
		}
		if(parameters.size()>2 || parameters.size() < 1) {
			return super.invalidParameter+"\nYou have to have one or more parameters or less than 3 parameters\n"+super.invalidParameter;
		}
		boolean fore = false;
		boolean back = false;
		Color c1 = null;
		Color c2 = null;
		for(Option a:options) {
			if(a.keyCode().equals(this.options.get(0).keyCode())) {
				fore = true;
			}
			else if(a.keyCode().equals(this.options.get(1).keyCode())) {
				back = true;
			}
		}
		for(Parameter a:parameters) {
			if(colorPalette.colorMap().containsKey(a.value())) {
				if(c1==null) {
					c1= colorPalette.colorMap().get(a.value());
				}else {
					c2 = colorPalette.colorMap().get(a.value());
				}
			}
		}
		if(parameters.size() > 1) {
			if(fore && back) {
				jButton.setForeground(c1);
				jButton.setBackground(c2);
				return super.success+"\nYou set the foreground: "+c1.toString() +" background: " + c2.toString()+"\n"+super.success;
			}else {
				return super.fail+"\nYou have to choose two options with two parameters\n"+super.fail;
			}
		}
		else {
			if(fore && back) {
				jButton.setForeground(c1);
				jButton.setBackground(c1);
				return super.success+"\nYou set the foreground: "+c1.toString() +" background: " + c1.toString()+"\n"+super.success;
			}else if(fore && !(back)) {
				jButton.setForeground(c1);
				return super.success+"\nYou set the foreground: "+c1.toString()+"\n"+super.success;
			}else if(!(fore) && back) {
				jButton.setBackground(c1);
				return super.success+"\nYou set the background: "+c1.toString()+"\n"+super.success;
			}else {
				jButton.setForeground(c1);
				return super.success+"\nYou set the foreground: "+c1.toString()+"\n"+super.success;
			}
		}
	}

}
