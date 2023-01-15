package shell;

public abstract class AbstractParameter implements Parameter{

	protected String name;
	protected String info;
	protected String value;
	
	public AbstractParameter(String name, String info, String value) {
		this.name=name;
		this.info=info;
		this.value=value;
	}
	
	public String name() {
		return name;
	}

	public String info() {
		return info;
	}
	public String value() {
		return value;
	}
	public void setValue(String va) {
		value=va;
	}
	public String toString() {
		return "Name: " + name + " Info: " + info;
	}
}
