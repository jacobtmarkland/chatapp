package userlist;

import java.io.*;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.channels.*;

public abstract class AbstractUserFrame implements UserFrame{
	
	protected final SocketChannel socket;
	protected final BufferedReader reader;
	protected final PrintWriter writer;
	protected final ID id;
	
	public AbstractUserFrame(SocketChannel socket, ID id) {
		if(!(socket==null)) {
			this.socket = socket;
			reader = new BufferedReader(Channels.newReader(this.socket, UTF_8));
			writer = new PrintWriter(Channels.newWriter(this.socket, UTF_8));
		}else {this.socket=null;this.writer=null; this.reader=null;}
		this.id = id;
	}

	public void sendMessage(String a) {
		writer.println(a);
		writer.flush();
	}
	
	public BufferedReader reader() {
		return reader;
	}

	public PrintWriter writer() {
		return writer;
	}

	public SocketChannel socket() {
		return socket;
	}

	public ID id() {
		return id;
	}
	

}
