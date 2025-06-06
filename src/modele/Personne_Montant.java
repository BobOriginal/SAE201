package modele;

public class Personne_Montant {
    
    private double montantDu;
    private double montantPaye;
    private String nom;
    private String prenom;
    private String status;
    public Personne_Montant(Personne pers, double montantDu , double montantPaye){
        this.nom = pers.getNom();
        this.prenom = pers.getPrenom();
        this.status = pers.getStatus();
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
