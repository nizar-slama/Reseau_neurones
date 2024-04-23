package reseau_neurones;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Configuration du réseau de neurones : nombre de neurones par couche
        int[] configuration = {3, 5, 2}; // 3 neurones en entrée, 5 en couche cachée, 2 en sortie
        String[] types = {"entree", "cache", "sortie"};

        // Création du réseau de neurones
        ReseauDeNeurones reseau = new ReseauDeNeurones(configuration, types);

        // Création d'un lot d'échantillons
        LotEchantillons lot = new LotEchantillons();
        lot.ajouterEchantillon(new Echantillon(new double[]{0.5, -1.2, 0.7}, 0.0));
        lot.ajouterEchantillon(new Echantillon(new double[]{1.5, 0.5, -0.5}, 1.0));

        // Test du réseau de neurones avec chaque échantillon
        for (Echantillon echantillon : lot.getEchantillons()) {
            double[] sorties = reseau.propager(echantillon.getEntrees());
            System.out.println("Entrées: " + Arrays.toString(echantillon.getEntrees()) +
                    ", Sorties attendues: " + echantillon.getResultatAttendu() +
                    ", Sorties obtenues: " + Arrays.toString(sorties));
        }
    }
}

