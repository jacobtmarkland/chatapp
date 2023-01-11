package userlist;

import java.io.*;
import java.nio.channels.SocketChannel;

public interface UserFrame {
	void sendMessage(String message);
	BufferedReader reader();
	PrintWriter writer();
	SocketChannel socket();
	ID id();
}
