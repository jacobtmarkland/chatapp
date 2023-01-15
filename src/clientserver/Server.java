package clientserver;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.channels.SocketChannel;

import clientgui.GUISetup;
import userlist.UserFrame;

public interface Server extends Runnable{
	void run();
	GUISetup guiSetup();
	UserFrame userFrame();
	void sendMessage(String a);
	SocketChannel socket();
	PrintWriter writer();
	BufferedReader reader();
}
