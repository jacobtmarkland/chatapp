package shell;

public class ClientShell extends AbstractShell{
	public ClientShell(String a) {
		super(new ServerInterpreter(SingletonClientCommandList.getInstance(a).cmdList), SingletonClientCommandList.getInstance(a).cmdList);
	}
}
