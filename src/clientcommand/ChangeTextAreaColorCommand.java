package clientcommand;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextArea;

import colorscheme.ColorPalette;
import colorscheme.DefaultColorPalette;
import shell.AbstractCommand;
import shell.Option;
import shell.Parameter;

public class ChangeTextAreaColorCommand extends AbstractCommand{

	protected JTextArea jArea;
	protected ColorPalette colorPalette;
	
	public ChangeTextAreaColorCommand(JTextArea jArea) {
		super("Change text area color", "changetextarea");
		super.parameters.add(new ColorParameter());
		super.options.add(new ForegroundOption());
		super.options.add(new BackgroundOption());
		this.jArea = jArea;
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
				jArea.setForeground(c1);
				jArea.setBackground(c2);
				return super.success+"\nYou set the foreground: "+c1.toString() +" background: " + c2.toString()+"\n"+super.success;
			}else {
				return super.fail+"\nYou have to choose two options with two parameters\n"+super.fail;
			}
		}
		else {
			if(fore && back) {
				jArea.setForeground(c1);
				jArea.setBackground(c1);
				return super.success+"\nYou set the foreground: "+c1.toString() +" background: " + c1.toString()+"\n"+super.success;
			}else if(fore && !(back)) {
				jArea.setForeground(c1);
				return super.success+"\nYou set the foreground: "+c1.toString()+"\n"+super.success;
			}else if(!(fore) && back) {
				jArea.setBackground(c1);
				return super.success+"\nYou set the background: "+c1.toString()+"\n"+super.success;
			}else {
				jArea.setForeground(c1);
				return super.success+"\nYou set the foreground: "+c1.toString()+"\n"+super.success;
			}
		}
	}

}
