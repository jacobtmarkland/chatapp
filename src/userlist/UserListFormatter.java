package userlist;

import java.util.HashMap;

public interface UserListFormatter {
	UserList userList();
	HashMap<Integer, Integer> map();
	String toString();
}
