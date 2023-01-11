package userlist;

public abstract class AbstractIDSystem implements IDSystem{
	private Integer idCurr;
	
	public AbstractIDSystem() {
		idCurr = 0;
	}
	public AbstractIDSystem(Integer start) {
		idCurr = start;
	}
	
	public synchronized Integer current() {
		return idCurr;
	}

	public synchronized Integer increase() {
		return idCurr++;
	}

	public synchronized Integer decrease() {
		return idCurr--;
	}

}
