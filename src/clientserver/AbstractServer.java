package clientserver;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;

import clientgui.GUISetup;
import userlist.UserFrame;

import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class AbstractServer implements Server{
	
	protected SocketChannel socket;
	protected PrintWriter writer;
	protected BufferedReader reader;
	protected GUISetup guiSetup;
	protected UserFrame userFrame;
	
	public AbstractServer(SocketChannel a, GUISetup guiSetup, UserFrame userFrame) {
		this.socket =a;
		this.guiSetup = guiSetup;
		this.userFrame = userFrame;
		writer = new PrintWriter(Channels.newWriter(socket, UTF_8));
		reader = new BufferedReader(Channels.newReader(socket, UTF_8));
	}
	
	public abstract void run();
	
	public void sendMessage(String a) {
		writer.println(a);
		writer.flush();
	}

	public SocketChannel socket() {
		return socket;
	}

	public PrintWriter writer() {
		return writer;
	}

	public BufferedReader reader() {
		return reader;
	}
	public GUISetup guiSetup() {
		return this.guiSetup;
	}
	public UserFrame userFrame() {
		return userFrame;
	}

}
