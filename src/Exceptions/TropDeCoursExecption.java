package Exceptions;

public class TropDeCoursExecption extends Exception {

	private static final long serialVersionUID = -3243158712551007891L;
	
	public TropDeCoursExecption(){
		System.out.println("L'élève assite déja a trop de cours");
	}

}
