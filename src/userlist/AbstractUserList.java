package userlist;

import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;

public abstract class AbstractUserList implements UserList{
	
	protected final HashMap<Integer, Integer> map;
	protected final ArrayList<User> userList;
	protected final ExecutorService pool;
	
	public AbstractUserList() {
		map = new HashMap<Integer, Integer>();
		userList = new ArrayList<User>();
		pool = Executors.newCachedThreadPool();
	}
	public synchronized void add(User a) {
		userList.add(a);
		pool.execute(a);
	}

	public synchronized boolean remove(User a) {
		return userList.remove(a);
	}
	public synchronized boolean remove(SocketChannel socket) {
		User remove = null;
		for(User user:userList) {
			if(user.userFrame().socket().equals(socket)) {
				remove = user;
			}
		}
		if(remove==null) {
			return false;
		}else {
			return userList.remove(remove);
		}
	}
	public synchronized boolean remove(Integer a) {
		int n = userList.size();
		int[] sort = new int[n];
		for(int i = 0; i < sort.length; i++) {
			if(userList.get(i).userFrame().id().id() == a) {return userList.remove(userList.get(i));};
		}
		return false;
	}
	public synchronized void block(Integer user, Integer userBlock) {
		map.put(user, userBlock);
	}
	public synchronized ArrayList<User> userList() {
		return userList;
	}

	public synchronized HashMap<Integer, Integer> blockList() {
		return map;
	}
	
	public synchronized void stop() {
		pool.shutdown();
	}
}
