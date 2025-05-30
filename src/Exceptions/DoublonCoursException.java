package Exceptions;

public class DoublonCoursException extends Exception {

	private static final long serialVersionUID = 1L;

	public DoublonCoursException() {
		System.out.println("Eleve est déjà inscrit a ce cours");
	}
}
