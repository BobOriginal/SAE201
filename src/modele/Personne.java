package modele;

public class Personne {
	private final String ELEVE_TARIF_REDUIT = "tarif reduit";
	private final String ELEVE_PLEIN_TARIF= "plein tarif";
	private final String NON_INSCRIT = "non inscrit";
	private int id;
	private String nom;
	private String prenom;
	private String status;
	private static int nbPersonne = 0;
	public Personne(String nom, String prenom, String status) throws StatusException {
		super();
		this.nom = nom;
		this.prenom = prenom;
		if(status == ELEVE_TARIF_REDUIT || 
		   status == ELEVE_PLEIN_TARIF	||
		   status == NON_INSCRIT) {
			this.status = status;
		}else {
			throw new StatusException();
		}
		
		id = nbPersonne;
		nbPersonne++;
	}
	
	
}
