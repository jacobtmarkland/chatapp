package clientserver;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.channels.SocketChannel;

public interface Server extends Runnable{
	void run();
	void sendMessage(String a);
	SocketChannel socket();
	PrintWriter writer();
	BufferedReader reader();
}
