package business;

import java.io.Serializable;

@SuppressWarnings("serial")
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
}
