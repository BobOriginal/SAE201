
package modele;

import java.util.ArrayList;

public class ListeDesFacturesArchiver {
    ArrayList<Facture> listeDesArchives = new ArrayList<>();

    public void ajouterArchive(Facture f) {
        listeDesArchives.add(f);
    }

    public void retirerArchive(int id) {
        int i = -1;
        while (id != listeDesArchives.get(i).getNumero()) {

            i++;
            if (id != listeDesArchives.get(i).getNumero()) {
                listeDesArchives.remove(i);
            }
        }
    }

    public Facture trouverFacture(int id) {
        int i = 0;
        while (listeDesArchives.get(i).getPersonne().getId() != id) {
            i++;
        }
        return listeDesArchives.get(i);
    }

    public void affiche() {
        int i;
        for (i = 0; i < listeDesArchives.size(); i++) {
            System.out.println(listeDesArchives.get(i));
        }
    }
}
