package userlist;

import java.io.IOException;
import shell.ServerShell;

public class AdminUser extends AbstractUser {

	public AdminUser(AdminUserFrame a) {
		super(a, new ServerShell());
	}

}
