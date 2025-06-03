package modele;

import java.util.HashMap;

	public class Tarif {
		static HashMap<Double,Double> prixCourPleinTarif ;
		static HashMap<Double,Double> prixCourTarifReduit;
		static Double prixNonInscrit = 44.0;
		static Double prixInscription = 33.0;
		
		
		private void addPleinTarif(Double nombreHeur,Double prix){
			prixCourPleinTarif.put(nombreHeur, prix);
		}
		
		public void ajouterPleinTarif(Double nombreHeur,Double prix) {
			
		}
		
		private void addTarifReduit(Double nombreHeur,Double prix){
			prixCourTarifReduit.put(nombreHeur, prix);
		}
		
		public void ajouterTarifReduit(Double nombreHeur,Double prix) {
			
		}
		
		private void removePleinTarif(Double nombreHeur){
			prixCourPleinTarif.remove(nombreHeur);
		}
		
		public void suprimmerPleinTarif(Double nombreHeur) {
			
		}
		
		private void removeTarifReduit(Double nombreHeur){
			prixCourTarifReduit.remove(nombreHeur);
		}
		
		public void suprimmerTarifReduit(Double nombreHeur) {
			
		}
		
		public void modifierPleinTarif(Double nombreHeur,Double prix) {
			suprimmerTarifReduit(nombreHeur);
			ajouterTarifReduit(nombreHeur, prix);
		}
}