package modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InfoTabView{
	private StringProperty nom;
	private StringProperty prenom;
	private StringProperty status;
	private StringProperty typePaiement;
	private BooleanProperty aPayer;
	private IntegerProperty montant;
	private IntegerProperty paiementEffectuer;
	private StringProperty cours;
	private BooleanProperty aPayerCour;
	private IntegerProperty montantCour;
	private IntegerProperty paiementEffectuerCour;
	
	public InfoTabView(Personne p) {
		nom = new SimpleStringProperty(p.getNom());
		prenom = new SimpleStringProperty(p.getPrenom());
		status = new SimpleStringProperty(p.getStatus());
		cours = null;
		typePaiement =  new SimpleStringProperty(p.getMaCotisation().getTypePaiment());
		aPayer = new SimpleBooleanProperty(p.getMaCotisation().aPayer());
		montant = new SimpleIntegerProperty(p.getMaCotisation().getTotal());
		paiementEffectuer = new SimpleIntegerProperty( p.getMaCotisation().getDejaPayer());
	}
	public InfoTabView(Personne p, int idcours) {
		nom = new SimpleStringProperty(p.getNom());
		prenom = new SimpleStringProperty(p.getPrenom());
		status = new SimpleStringProperty(p.getStatus());
		typePaiement =  new SimpleStringProperty(p.getMaCotisation().getTypePaiment());
		cours = new SimpleStringProperty(p.getMesCours().get(idcours).getIntituler());
		aPayerCour = new SimpleBooleanProperty(p.getMaCotisation().getAPayersCours().get(idcours));
		montantCour = new SimpleIntegerProperty(p.getMaCotisation().getPrixCours().get(idcours));
		paiementEffectuerCour = new SimpleIntegerProperty(p.getMaCotisation().getDejaPayerCour());
	}
}
