package clientserver;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;

import java.util.HashMap;

import clientgui.GUISetup;
import userlist.UserFrame;

import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class AbstractServer implements Server{
	
	protected HashMap<String, Object> map;
	
	public AbstractServer(SocketChannel a, GUISetup guiSetup, UserFrame userFrame) {
		map = new HashMap<String, Object>();
		map.put("socket", a);
		map.put("guiSetup", guiSetup);
		map.put("userFrame", userFrame);
		map.put("writer", new PrintWriter(Channels.newWriter(a, UTF_8)));
		map.put("reader", new BufferedReader(Channels.newReader(a, UTF_8)));
	}
	
	public abstract void run();
	
	public void sendMessage(String a) {
		try {
			PrintWriter writer = (PrintWriter) map.get("writer");
			writer.println(a);
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, Object> map(){
		return map;
	}

}
