package clientserver;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.channels.SocketChannel;

import clientgui.GUISetup;

public interface Server extends Runnable{
	void run();
	GUISetup guiSetup();
	void sendMessage(String a);
	SocketChannel socket();
	PrintWriter writer();
	BufferedReader reader();
}
