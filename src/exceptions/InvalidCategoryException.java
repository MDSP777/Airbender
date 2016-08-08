package exceptions;

public class InvalidCategoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCategoryException(String s){
		super("Invalid category: "+s);
	}
}
