package userlist;

public abstract class AbstractID implements ID{
	protected String name;
	protected Integer id;
	protected final IDSystem idSystem;
	protected final UserType userType;
	
	public AbstractID(String name, IDSystem idSystem, UserType a) {
		if(name==null) {
			name="null";
		}else {
			this.name = name;
		}
		this.idSystem = idSystem;
		if(!(idSystem==null)) {
			this.id = this.idSystem.increase();
		}else{this.id=-1;}
		this.userType = a;
	}
	public String name() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(Integer a) {
		this.id = a;
	}
	public Integer id() {
		return id;
	}
	public IDSystem idSystem() {
		return idSystem;
	}
	public UserType userType() {
		return userType;
	}
	
	public String toString() {
		return "usertype:"+userType+" id:"+id+" name:"+name;
	}
}
