package exceptions;

public class UsernameOrEmailAlreadyTakenException extends Exception {

	private static final long serialVersionUID = 1L;


	public UsernameOrEmailAlreadyTakenException(String description) {
		super(description);
	}
}
