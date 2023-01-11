package servernetwork;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.StackWalker.Option;
import java.lang.reflect.Parameter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

import shell.Command;
import shell.Interpreter;
import shell.ServerInterpreter;
import userlist.IDSystem;
import userlist.SingletonIDSystem;
import userlist.SingletonUserList;
import userlist.UserList;

public class AbstractNetworkSetup implements NetworkSetup{
	protected boolean online;
	protected UserList userList;
	protected IDSystem idSystem;
	
	public AbstractNetworkSetup(UserList userList, IDSystem idSystem) {
		online = false;
		this.userList = userList;
		this.idSystem = idSystem;
		go();
	}
		
	public void go() {
		try {
			InetSocketAddress server = new InetSocketAddress("127.0.0.1",5000);
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel = serverSocketChannel.bind(server);
			ArrayList<Option> options = new ArrayList<Option>();
			ArrayList<Parameter> parameters = new ArrayList<Parameter>();
			ArrayList<Command> cmdList = new ArrayList<Command>();
			online=true;
			while(serverSocketChannel.isOpen()) {
				options = new ArrayList<Option>();
				parameters = new ArrayList<Parameter>();
				cmdList = new ArrayList<Command>();
				SocketChannel socketChannel = serverSocketChannel.accept();
				CreateAccountCommand cmd = new CreateAccountCommand(socketChannel,SingletonUserList.getInstance().userList, SingletonIDSystem.getInstance().idSystem);
				cmdList.add(cmd);
				Interpreter interpreter = new ServerInterpreter(cmdList);
				BufferedReader reader = new BufferedReader(Channels.newReader(socketChannel, UTF_8));
				PrintWriter writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
				String message;
				while((message=reader.readLine())!=null) {
					writer.println(interpreter.interpret(message));
					writer.flush();
					break;
				}
			}
		}catch(IOException e) {
			online = false;
			e.printStackTrace();
		}
	}
	public boolean online() {
		return online;
	}
	public UserList userList() {
		return userList;
	}
	public IDSystem idSystem() {
		return idSystem;
	}

}
