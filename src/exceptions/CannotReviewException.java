package exceptions;

public class CannotReviewException extends Exception {

	private static final long serialVersionUID = 1L;

	public CannotReviewException(String desc){
		super("Cannot review without purchasing: "+desc);
	}
}
