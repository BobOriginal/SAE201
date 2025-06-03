package Exceptions;

public class EtudiantNullException extends Exception {
    public EtudiantNullException() {
        System.out.println("Attention, l'élève est null : ");
    }

    public String toString() {
        return "L'élève ne peux pas être null";
    }

}
