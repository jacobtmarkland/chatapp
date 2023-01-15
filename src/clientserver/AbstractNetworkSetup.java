package clientserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import clientgui.GUISetup;
import userlist.UserFrame;
import userlist.UserType;

public class AbstractNetworkSetup implements NetworkSetup{
	protected HashMap<String,Object> map;
	
	public AbstractNetworkSetup() {
		map = new HashMap<String,Object>();
		map.put("pool", Executors.newSingleThreadExecutor());
		map.put("online", Boolean.FALSE);
		map.put("server", null);
	}
		
	public void go(UserFrame userFrame, GUISetup guiSetup) {
		InetSocketAddress server = new InetSocketAddress("127.0.0.1",5000);
		try {
			ExecutorService pool = (ExecutorService)map.get("pool");

			SocketChannel socketChannel = SocketChannel.open(server);
			map.replace("online", Boolean.FALSE, Boolean.TRUE);
			PrintWriter writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
			if(userFrame.id().userType()==UserType.NORMAL) {
				
				writer.println("/createaccount;-r;(" + userFrame.id().name()+")");
			}else if(userFrame.id().userType()==UserType.ADMIN){
				writer.println("/createaccount;-a;(" + userFrame.id().name()+")");
			}
			writer.flush();
			map.replace("server", null, new ServerHandler(socketChannel,guiSetup,userFrame));
			Server handler = (Server)map.get("server");
			pool.execute(handler);
		}catch(IOException e) {
			try {
				map.replace("online", Boolean.TRUE, Boolean.FALSE);
			}catch(Exception ee) {
				ee.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	public HashMap<String, Object> map(){
		return map;
	}

	public void sendMessage(String a) {
		try {
			Server ser = (Server)map.get("server");
			ser.sendMessage(a);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
