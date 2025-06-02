package Exceptions;

public class PaimentTropBasException extends PaimentExecption {

	private static final long serialVersionUID = 4054453914769259287L;

	public PaimentTropBasException() {
		System.out.println("Le paiment est trop bas");
	}
}
