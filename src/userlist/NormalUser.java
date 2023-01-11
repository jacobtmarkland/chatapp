package userlist;

import java.io.IOException;
import java.util.ArrayList;

import servernetwork.CreateAccountCommand;
import shell.Command;
import shell.ServerShell;

public class NormalUser extends AbstractUser{

	public NormalUser(NormalUserFrame a) {
		super(a,new ServerShell());
	}



}
