package shell;

public abstract class AbstractOption implements Option{
	protected String name;
	protected String keyCode;
	protected String info;
	
	public AbstractOption(String name, String keyCode, String info) {
		this.name=name;
		this.keyCode=keyCode;
		this.info=info;
	}
	
	public String name() {
		return name;
	}

	public String keyCode() {
		return keyCode;
	}

	public String info() {
		return info;
	}
	public String toString() {
		return "Name: " + name +" KeyCode: -" + keyCode + " Info: " + info;
	}

}
