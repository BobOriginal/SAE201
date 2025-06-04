package modele;

import java.util.ArrayList;

public class ListeDesFacturesArchiver {
    ArrayList<FactureArchiver> listeDesArchives = new ArrayList<>();

    public void ajouterArchive(FactureArchiver f) {
        listeDesArchives.add(f);
    }

    public void retirerArchive(int id) {
        int i = -1;
        while (id != listeDesArchives.get(i).getId()) {

            i++;
            if (id != listeDesArchives.get(i).getId()) {
                listeDesArchives.remove(i);
            }
        }
    }
}
