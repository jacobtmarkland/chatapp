package userlist;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

import servernetwork.CreateAccountCommand;
import shell.Command;
import shell.Shell;

import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class AbstractUser implements User{
	protected UserFrame userFrame;
	protected Shell shell;
	protected UserInput userInput;
	
	public AbstractUser(UserFrame a, Shell shell) {
		this.userFrame = a;
		this.shell = shell;
		this.userInput = new ServerUserInput();
	}
	public UserFrame userFrame() {
		return userFrame;
	}
	public void run() {
		try {
			String message;
			while((message=userFrame.reader().readLine())!=null) {
				userInput.readLine(message);
				if(!userInput.isUserInput()) {
					if(userFrame.id().userType()==UserType.ADMIN) {
						shell.readLine(message);
						sendMessage(shell.executeCmd());
					}else {
						sendMessage("Not an admin");
					}
				}else {
					shell.readLine(message);
					shell.executeCmd();
				}
				
			}
		}catch(IOException e) {
			shell.readLine("remove commd"+userFrame.id());
			shell.executeCmd();
			e.printStackTrace();
		}
	}
	public void sendMessage(String a) {
		userFrame.sendMessage(a);
	}
	
	public Shell shell() {
		return shell;
	}
	public UserInput userInput() {
		return userInput;
	}
}
