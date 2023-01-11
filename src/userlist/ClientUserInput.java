package userlist;

public class ClientUserInput extends AbstractUserInput{
	public ClientUserInput() {
		super();
	}
	
	@Override
	public boolean isUserInput() {
		if(super.currLine().length()>1) {
			if(currLine().charAt(0)=='/') {
				return false;
			}
		}
		return true;
	}
}
