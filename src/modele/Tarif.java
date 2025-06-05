package modele;

import java.util.HashMap;

	public class Tarif {
		static HashMap<Double,Integer> prixCourPleinTarif = new HashMap<Double, Integer>();
		static HashMap<Double,Integer> prixCourTarifReduit = new HashMap<Double, Integer>();
		static HashMap<Double,Paiement3fois> prixCourPleinTarif3fois = new HashMap<Double, Paiement3fois>();
		static HashMap<Double,Paiement3fois> prixCourTarifReduit3fois = new HashMap<Double, Paiement3fois>();
		static Integer prixNonInscrit = 44;
		static Integer prixInscription = 33;
		
		protected static void initTarif() {
			prixCourPleinTarif.put(0.75,91);
			prixCourPleinTarif.put(1.00,112);
			prixCourPleinTarif.put(1.25,133);
			prixCourPleinTarif.put(1.5,150);
			prixCourPleinTarif.put(1.75,168);
			prixCourPleinTarif.put(2.00,185);
			prixCourPleinTarif.put(2.25,199);
			prixCourPleinTarif.put(2.5,213);
			prixCourPleinTarif.put(2.75,227);
			prixCourPleinTarif.put(3.00,241);
			prixCourPleinTarif.put(3.25,255);
			prixCourPleinTarif.put(3.5,269);
			prixCourPleinTarif.put(3.75,279);
			prixCourPleinTarif.put(4.00,290);
			prixCourPleinTarif.put(4.25,300);
			prixCourPleinTarif.put(4.5,310);
			prixCourPleinTarif.put(4.75,321);
			prixCourPleinTarif.put(5.00,331);
			prixCourPleinTarif.put(5.50,352);
			prixCourPleinTarif.put(6.00,372);
			prixCourPleinTarif.put(6.50,393);
			prixCourPleinTarif.put(7.00,413);
			prixCourPleinTarif.put(7.5,434);

			prixCourTarifReduit.put(0.75,74);
			prixCourTarifReduit.put(1.00,83);
			prixCourTarifReduit.put(1.25,101);
			prixCourTarifReduit.put(1.5,110);
			prixCourTarifReduit.put(1.75,122);
			prixCourTarifReduit.put(2.00,134);
			prixCourTarifReduit.put(2.25,146);
			prixCourTarifReduit.put(2.5,158);
			prixCourTarifReduit.put(2.75,167);
			prixCourTarifReduit.put(3.00,176);
			prixCourTarifReduit.put(3.25,185);
			prixCourTarifReduit.put(3.5,194);
			prixCourTarifReduit.put(3.75,200);
			prixCourTarifReduit.put(4.00,206);
			prixCourTarifReduit.put(4.25,212);
			prixCourTarifReduit.put(4.5,214);
			prixCourTarifReduit.put(5.00,226);

			
		}
		
		private void addPleinTarif(Double nombreHeur,Integer  prix){
			prixCourPleinTarif.put(nombreHeur, prix);
		}
		
		
		private void addTarifReduit(Double nombreHeur,Integer prix){
			prixCourTarifReduit.put(nombreHeur, prix);
		}
		
		
		private void removePleinTarif(Double nombreHeur){
			prixCourPleinTarif.remove(nombreHeur);
		}
		
		private void removeTarifReduit(Double nombreHeur){
			prixCourTarifReduit.remove(nombreHeur);
		}
	
}