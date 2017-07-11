package com.cand.jspfunc.exception;

public class NoUserPermissionException extends Exception {

	public NoUserPermissionException() {
		super("User has no permissions to for this operation");
	}

	public NoUserPermissionException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NoUserPermissionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoUserPermissionException(String arg0) {
		super(arg0);
	}

	public NoUserPermissionException(Throwable arg0) {
		super(arg0);
	}
	
	

}
