package shell;

public class ClientShell extends AbstractShell{
	public ClientShell() {
		super(new ServerInterpreter(SingletonClientCommandList.getInstance().cmdList), SingletonClientCommandList.getInstance().cmdList);
	}
}
