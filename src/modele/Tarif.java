package modele;

import java.util.HashMap;

	public class Tarif {
		static HashMap<Double,Double> prixCourPleinTarif ;
		static HashMap<Double,Double> prixCourTarifReduit;
		static HashMap<Double,Paiment3fois> prixCourPleinTarif3fois;
		static HashMap<Double,Paiment3fois> prixCourTarifReduit3fois;
		static Double prixNonInscrit = 44.0;
		static Double prixInscription = 33.0;
		
		protected void initTarif() {
			
		}
		
		private void addPleinTarif(Double nombreHeur,Double prix){
			prixCourPleinTarif.put(nombreHeur, prix);
		}
		
		
		private void addTarifReduit(Double nombreHeur,Double prix){
			prixCourTarifReduit.put(nombreHeur, prix);
		}
		
		
		private void removePleinTarif(Double nombreHeur){
			prixCourPleinTarif.remove(nombreHeur);
		}
		
		private void removeTarifReduit(Double nombreHeur){
			prixCourTarifReduit.remove(nombreHeur);
		}
	
}