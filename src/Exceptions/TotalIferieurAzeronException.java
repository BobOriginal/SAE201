package Exceptions;

public class TotalIferieurAzeronException extends Exception {
    public TotalIferieurAzeronException() {
        System.out.println("Le total n'est pas bon : ");
    }

    public String toString() {
        return "Inférieur a Zéro";
    }
}
