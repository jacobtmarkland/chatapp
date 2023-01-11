package userlist;

import java.nio.channels.SocketChannel;

public class AdminUserFrame extends AbstractUserFrame{

	public AdminUserFrame(SocketChannel socket,AdminID a) {
		super(socket, a);
	}

}
