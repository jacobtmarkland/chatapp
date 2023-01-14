package clientserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import clientgui.GUISetup;
import userlist.UserFrame;
import userlist.UserType;

public class AbstractNetworkSetup implements NetworkSetup{
	protected boolean online;
	protected final ExecutorService pool;
	protected Server server;
	public AbstractNetworkSetup() {
		pool = Executors.newSingleThreadExecutor();
		online = false;
		server=null;
	}
		
	public void go(UserFrame userFrame, GUISetup guiSetup) {
		InetSocketAddress server = new InetSocketAddress("127.0.0.1",5000);
		try {
			SocketChannel socketChannel = SocketChannel.open(server);
			online=true;
			PrintWriter writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
			if(userFrame.id().userType()==UserType.NORMAL) {
				
				writer.println("/createaccount;-r;(" + userFrame.id().name()+")");
			}else if(userFrame.id().userType()==UserType.ADMIN){
				writer.println("/createaccount;-a;(" + userFrame.id().name()+")");
			}
			writer.flush();
			this.server = new ServerHandler(socketChannel,guiSetup);
			pool.execute(this.server);
		}catch(IOException e) {
			online=false;
			e.printStackTrace();
		}
	}
	public void sendMessage(String a) {
		server.sendMessage(a);
	}
	public Server server() {
		return server;
	}
	public boolean online() {
		return online;
	}
}
