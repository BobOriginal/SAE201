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
}
