package business;

import java.io.Serializable;

public class LoginException extends Exception implements Serializable {

	public LoginException() {
		super();
	}

	public LoginException(Throwable t) {
		super(t);
	}

	public LoginException(String s) {
		super(s);
	}

	private static final long serialVersionUID = 5399827794066637059L;
}
