package exceptions;

public class InvalidIdException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidIdException(Object desc){
		super("Invalid id: "+desc);
	}
}
