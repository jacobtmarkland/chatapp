package userlist;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserList {
	void add(User a);
	boolean remove(User a);
	boolean remove(Integer a);
	ArrayList<User> userList();
	HashMap<Integer, Integer>blockList();
	void stop();
}
