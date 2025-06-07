package Exceptions;

public class PaimentTropEleverException extends PaimentExecption {

	private static final long serialVersionUID = -785306392605430703L;

	public PaimentTropEleverException(){
		System.out.println("la valeur du paiment est trop élever");
	}
}
