package modele;

public class Paiement3fois {
    private Double premier_versement;
	private Double deuxieme_versement;
	private Double troisieme_versement;
	public Paiment3fois(Double premier_versement, Double deuxieme_versement, Double troisieme_versement) {
		super();
		this.premier_versement = premier_versement;
		this.deuxieme_versement = deuxieme_versement;
		this.troisieme_versement = troisieme_versement;
	}
	public Double getPremier_versement() {
		return premier_versement;
	}
	public void setPremier_versement(Double premier_versement) {
		this.premier_versement = premier_versement;
	}
	public Double getDeuxieme_versement() {
		return deuxieme_versement;
	}
	public void setDeuxieme_versement(Double deuxieme_versement) {
		this.deuxieme_versement = deuxieme_versement;
	}
	public Double getTroisieme_versement() {
		return troisieme_versement;
	}
	public void setTroisieme_versement(Double troisieme_versement) {
		this.troisieme_versement = troisieme_versement;
	}
	
}
