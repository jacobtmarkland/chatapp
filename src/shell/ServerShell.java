package shell;

import java.util.ArrayList;

public class ServerShell extends AbstractShell{

	public ServerShell() {
		super(new ServerInterpreter(SingletonServerCommandList.getInstance().cmdList), SingletonServerCommandList.getInstance().cmdList);
	}

}
