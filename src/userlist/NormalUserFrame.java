package userlist;

import java.nio.channels.SocketChannel;

public class NormalUserFrame extends AbstractUserFrame{

	public NormalUserFrame(SocketChannel socket, NormalID id) {
		super(socket, id);
	}
	
}
