package reseau_neurones;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Initialisation des poids et seuils pour la fonction ET
        double[] poids = {1.0, 1.0}; // Poids pour la fonction ET
        double seuil = 1.5; // Seuil pour activer la sortie à 1

        // Création d'un neurone de sortie
        NeuroneSortie neuroneSortie = new NeuroneSortie(poids, seuil);

        // Création du réseau de neurones avec un seul neurone de sortie
        ReseauDeNeurones reseau = new ReseauDeNeurones(new Neurone[]{neuroneSortie});

        // Définition des échantillons pour la fonction ET
        Echantillon[] echantillons = new Echantillon[] {
                new Echantillon(new int[]{0, 0}, 0),
                new Echantillon(new int[]{0, 1}, 0),
                new Echantillon(new int[]{1, 0}, 0),
                new Echantillon(new int[]{1, 1}, 1)
        };

        LotEchantillons lot = new LotEchantillons(echantillons);

        // Évaluation des échantillons par le réseau
        for (Echantillon e : lot.getEchantillons()) {
            double[] entreesDouble = convertToDoubleArray(e.getEntrees());
            int resultat = reseau.evaluer(entreesDouble);
            System.out.println("Entrées: " + Arrays.toString(e.getEntrees()) + " - Résultat attendu: " + e.getResultatAttendu() + " - Résultat obtenu: " + resultat);
        }
    }

    // Méthode utilitaire pour convertir un tableau d'entiers en un tableau de doubles
    private static double[] convertToDoubleArray(int[] input) {
        double[] output = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[i];
        }
        return output;
    }



}
