package servernetwork;

import java.nio.channels.SocketChannel;
import java.util.ArrayList;

import servercommand.AdminAccountOption;
import servercommand.NameParameter;
import servercommand.RegularAccountOption;
import shell.AbstractCommand;
import shell.Option;
import shell.Parameter;
import userlist.*;

public class CreateAccountCommand extends AbstractCommand{
	protected SocketChannel socket;
	protected UserList userList;
	protected IDSystem idSystem;
	
	public CreateAccountCommand(SocketChannel socket, UserList userList, IDSystem idSystem) {
		super("Create Account", "createaccount");
		this.socket = socket;
		this.userList = userList;
		this.idSystem = idSystem;
		super.options.add(new RegularAccountOption());
		super.options.add(new AdminAccountOption());
		super.parameters.add(new NameParameter());
	}


	public String execute(ArrayList<Option> options, ArrayList<Parameter> parameters) {
		User user = null;
		if(options.size() > 1) {
			return super.invalidOption+"\nYou can only choose one type of account\n"+super.invalidOption;
		}
		if(parameters.size()!=1) {
			return super.invalidParameter+"\nYou have to have a single name parameter with no spaces\n"+super.invalidParameter;
		}
		for(Option a:options) {
			if(a.keyCode().equals(this.options.get(0).keyCode())) {
				userList.add(new NormalUser(new NormalUserFrame(socket, new NormalID(parameters.get(0).value(),idSystem))));
				for(User use:userList.userList()) {
					if(use.userFrame().socket().equals(this.socket)) {
						user = use;
					}
				}
				if(user!=null) {
					return super.success+"\nUser made: "+ user.userFrame().id().toString()+"\n" + super.success;
				}else {
					return super.fail;
				}
			}
			if(a.keyCode().equals(this.options.get(1).keyCode())) {
				userList.add(new AdminUser(new AdminUserFrame(socket, new AdminID(parameters.get(0).value(),idSystem))));
				for(User use:userList.userList()) {
					if(use.userFrame().socket().equals(this.socket)) {
						user = use;
					}
				}
				if(user!=null) {
					return super.success+"\nUser made: "+ user.userFrame().id().toString()+"\n" + super.success;
				}else {
					return super.fail;
				}
			}
		}
		userList.add(new NormalUser(new NormalUserFrame(socket, new NormalID(parameters.get(0).value(),idSystem))));
		for(User use:userList.userList()) {
			if(use.userFrame().socket().equals(this.socket)) {
				user = use;
			}
		}
		if(user!=null) {
			return super.success+"\nUser made: "+ user.userFrame().id().toString()+"\n" + super.success;
		}else {
			return super.fail;
		}
	}



}
