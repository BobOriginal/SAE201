package modele;

import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InfoTabView{
	private StringProperty nom;
	private StringProperty prenom;
	private StringProperty status;
	private StringProperty typePaiement;
	private BooleanProperty aPayer;
	private DoubleProperty montant;
	private DoubleProperty paiementEffectuer;
	private StringProperty cours;
	private BooleanProperty aPayerCour;
	private DoubleProperty montantCour;
	private DoubleProperty paiementEffectuerCour;

	
	
	public InfoTabView(Personne p) {
		nom = new SimpleStringProperty(p.getNom());
		prenom = new SimpleStringProperty(p.getPrenom());
		status = new SimpleStringProperty(p.getStatus());
		cours = null;
		typePaiement =  new SimpleStringProperty(p.getMaCotisation().getTypePaiment());
		aPayer = new SimpleBooleanProperty(p.getMaCotisation().aPayer());
		montant = new SimpleDoubleProperty(p.getMaCotisation().getTotal());
		paiementEffectuer = new SimpleDoubleProperty( p.getMaCotisation().getDejaPayer());
	}
	public InfoTabView(Personne p,int idcours) {
		nom = new SimpleStringProperty(p.getNom());
		prenom = new SimpleStringProperty(p.getPrenom());
		status = new SimpleStringProperty(p.getStatus());
		typePaiement =  new SimpleStringProperty(p.getMaCotisation().getTypePaiment());
		cours = new SimpleStringProperty(p.getMesCours().get(idcours).getIntituler());
		aPayerCour = new SimpleBooleanProperty(p.getMaCotisation().getaPayersCours().get(idcours));
		montantCour = new SimpleDoubleProperty(p.getMaCotisation().getPrixCours().get(idcours));
		paiementEffectuerCour = new SimpleDoubleProperty(p.getMaCotisation().getDejaPayerCour());
	}
}
