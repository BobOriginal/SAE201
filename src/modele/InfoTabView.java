package modele;

public class InfoTabView {
	private String nom;
	private String prenom;
	private String status;
	private String cours;
	private String typePaiement;
	private Boolean aPayer;
	private Double montant;
	private Double paiementEffectuer;

	
	
	public InfoTabView(Personne p,int cour) {
		nom = p.getNom();
		prenom = p.getPrenom();
		status = p.getStatus();
		cours = p.getMesCours().get(cour).getIntituler();
		typePaiement = p.getMaCotisation().getTypePaiment();
		aPayer = p.getMaCotisation().aPayer();
		montant = p.getMaCotisation().getTotal();
		paiementEffectuer = p.getMaCotisation().getDejaPayer();
	}
	
	
	
}
