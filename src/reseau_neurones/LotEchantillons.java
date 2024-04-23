package reseau_neurones;


import java.util.ArrayList;
public class LotEchantillons {
    private ArrayList<Echantillon> echantillons; // Liste des échantillons

    public LotEchantillons() {
        this.echantillons = new ArrayList<>();
    }

    // Ajoute un échantillon au lot
    public void ajouterEchantillon(Echantillon echantillon) {
        echantillons.add(echantillon);
    }

    // Retourne la liste des échantillons
    public ArrayList<Echantillon> getEchantillons() {
        return echantillons;
    }
}
