package clientserver;

import java.util.HashMap;


public interface Server extends Runnable{
	void run();
	void sendMessage(String a);
	HashMap<String, Object> map();
}
