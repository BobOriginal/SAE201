package modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InfoTabView{
	
	private Personne p;
	private int idCours;
	private StringProperty nom;
	private StringProperty prenom;
	private StringProperty status;
	private StringProperty typePaiement;
	private BooleanProperty aPayer;
	private IntegerProperty montant;
	private IntegerProperty dejaPayer;
	private IntegerProperty resteAPayer;
	private IntegerProperty paiementEffectuer;
	private DoubleProperty nombreHeureCour;
	private StringProperty cours;
	private BooleanProperty aPayerCour;
	private IntegerProperty montantCour;
	private IntegerProperty paiementEffectuerCour;
	
	public InfoTabView(Personne p) {
		this.p = p;
		nom = new SimpleStringProperty(p.getNom());
		prenom = new SimpleStringProperty(p.getPrenom());
		status = new SimpleStringProperty(p.getStatus());
		cours = null;
		typePaiement =  new SimpleStringProperty(p.getMaCotisation().getTypePaiment());
		aPayer = new SimpleBooleanProperty(p.getMaCotisation().aPayer());
		montant = new SimpleIntegerProperty(p.getMaCotisation().getTotal());
		paiementEffectuer = new SimpleIntegerProperty( p.getMaCotisation().getDejaPayer());
		dejaPayer = new SimpleIntegerProperty(p.getMaCotisation().getDejaPayer());
		resteAPayer = new SimpleIntegerProperty(p.getMaCotisation().getResteAPayer());
	}
	
	public InfoTabView(Personne p, int idcours) {
		this.p = p;
		this.idCours = idcours;
		nom = new SimpleStringProperty(p.getNom());
		prenom = new SimpleStringProperty(p.getPrenom());
		status = new SimpleStringProperty(p.getStatus());
		typePaiement =  new SimpleStringProperty(p.getMaCotisation().getTypePaiment());
		cours = new SimpleStringProperty(p.getMesCours().get(idcours).getIntituler());
		aPayerCour = new SimpleBooleanProperty(p.getMaCotisation().getAPayersCours().get(idcours));
		montantCour = new SimpleIntegerProperty(p.getMaCotisation().getPrixCours().get(idcours));
		paiementEffectuerCour = new SimpleIntegerProperty(p.getMaCotisation().getDejaPayerCour());
		nombreHeureCour = new SimpleDoubleProperty(p.getMesCours().get(idcours).getNbHeure());
	}

	public String getNom() {
		return nom.get();
	}
	
	public StringProperty nomProperty() {
		return this.nom;
	}

	public void setNom(StringProperty nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom.get();
	}
	
	public StringProperty prenomProperty() {
		return this.prenom;
	}

	public void setPrenom(StringProperty prenom) {
		this.prenom = prenom;
	}

	public String getStatus() {
		return status.get();
	}
	
	public StringProperty statusProperty() {
		return this.status;
	}

	public void setStatus(StringProperty status) {
		this.status = status;
	}

	public String getTypePaiement() {
		return typePaiement.get();
	}
	
	public StringProperty typePaiementProperty() {
		return this.typePaiement;
	}

	public void setTypePaiement(StringProperty typePaiement) {
		this.typePaiement = typePaiement;
	}

	public Boolean getaPayer() {
		return aPayer.get();
	}

	public BooleanProperty aPayerProperty() {
		return this.aPayer;
	}
	
	public void setaPayer(BooleanProperty aPayer) {
		this.aPayer = aPayer;
	}

	public int getMontant() {
		return montant.get();
	}

	public IntegerProperty montantProperty() {
		return this.montant;
	}
	
	public void setMontant(IntegerProperty montant) {
		this.montant = montant;
	}

	public int getPaiementEffectuer() {
		return paiementEffectuer.get();
	}
	
	public IntegerProperty paiementEffectuerProperty() {
		return this.paiementEffectuer;
	}
	
	public void setPaiementEffectuer(IntegerProperty paiementEffectuer) {
		this.paiementEffectuer = paiementEffectuer;
	}

	public String getCours() {
		return cours.get();
	}
	
	public StringProperty coursProperty() {
		return this.cours;
	}

	public void setCours(StringProperty cours) {
		this.cours = cours;
	}

	public Boolean getaPayerCour() {
		return aPayerCour.get();
	}
	
	public BooleanProperty aPayerCourProperty() {
		return this.aPayerCour;
	}

	public void setaPayerCour(BooleanProperty aPayerCour) {
		this.aPayerCour = aPayerCour;
	}

	public int getMontantCour() {
		return montantCour.get();
	}
	
	public IntegerProperty montantCourProperty() {
		return this.montantCour;
	}

	public void setMontantCour(IntegerProperty montantCour) {
		this.montantCour = montantCour;
	}

	public int getPaiementEffectuerCour() {
		return paiementEffectuerCour.get();
	}
	
	public IntegerProperty paiementEffectuerCourProperty() {
		return this.paiementEffectuerCour;
	}

	public void setPaiementEffectuerCour(IntegerProperty paiementEffectuerCour) {
		this.paiementEffectuerCour = paiementEffectuerCour;
	}

	public Personne getP() {
		return p;
	}

	public int getIdCours() {
		return idCours;
	}

	@Override
	public String toString() {
		return "InfoTabView [p=" + p + ", idCours=" + idCours + ", nom=" + nom + ", prenom=" + prenom + ", status="
				+ status + ", typePaiement=" + typePaiement + ", aPayer=" + aPayer + ", montant=" + montant
				+ ", paiementEffectuer=" + paiementEffectuer + ", cours=" + cours + ", aPayerCour=" + aPayerCour
				+ ", montantCour=" + montantCour + ", paiementEffectuerCour=" + paiementEffectuerCour + "]";
	}

	public int getDejaPayer() {
		return dejaPayer.get();
	}
	
	public IntegerProperty dejaPayerProperty() {
		return this.dejaPayer;
	}

	public int getResteAPayer() {
		return resteAPayer.get();
	}
	
	public IntegerProperty resteAPayerProperty() {
		return this.resteAPayer;
	}

	public Double getNombreHeureCour() {
		return nombreHeureCour.get();
	}
	
	
	
}
