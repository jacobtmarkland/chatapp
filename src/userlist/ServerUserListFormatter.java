package userlist;

import java.util.HashMap;

public class ServerUserListFormatter extends AbstractUserListFormatter{
	public static final String formatBar = "###############Server Formatter 1.0###############\n";
	
	public ServerUserListFormatter(UserList userList, HashMap<Integer, Integer> blockList) {
		super(userList,blockList);
	}
	
	public String toString() {
		int n = userList.userList().size();
		String returns = "";
		returns+=formatBar;
		for(int i = 0; i < n; i++) {
			User a = userList.userList().get(i);
			UserType type = a.userFrame().id().userType();
			Integer id = a.userFrame().id().id();
			String name = a.userFrame().id().name();
			String line = type.toString() + ":"+id.toString() + ":"+name+"\n";
			returns+=line;
		}
		returns+=formatBar;
		return returns;
	}
}
