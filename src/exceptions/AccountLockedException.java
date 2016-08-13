package exceptions;

public class AccountLockedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountLockedException(String desc){
		super("Exceeded max login attempts for User Account: "+desc);
	}
}
