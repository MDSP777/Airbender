package exceptions;

public class InvalidQuantityException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidQuantityException(String desc){
		super("Invalid quantity specified: "+desc);
	}
}
