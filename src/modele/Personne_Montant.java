package modele;

public class Personne_Montant {
    private double montantDu;
    private double montantPaye;
    private Personne pers;
    public Personne_Montant(Personne pers , double montantDu , double montantPaye){
        this.pers = pers;
        this.montantDu = montantDu;
        this.montantPaye = montantPaye;
    }

    public double getMontantDu() {
        return montantDu;
    }
    public void setMontantDu(double montantDu) {
        this.montantDu = montantDu;
    }
    public double getMontantPaye() {
        return montantPaye;
    }
    public void setMontantPaye(double montantPaye) {
        this.montantPaye = montantPaye;
    }
    public Personne getPers() {
        return pers;
    }
    public void setPers(Personne pers) {
        this.pers = pers;
    }
    
}
