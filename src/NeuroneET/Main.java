package NeuroneET;

import java.util.ArrayList;

// Classe représentant un échantillon d'entrée avec le résultat attendu
class Echantillon {
    private double[] entrees; // Entrées de l'échantillon
    private double resultatAttendu; // Résultat attendu pour ces entrées

    public Echantillon(double[] entrees, double resultatAttendu) {
        this.entrees = entrees;
        this.resultatAttendu = resultatAttendu;
    }

    // Getters
    public double[] getEntrees() {
        return entrees;
    }

    public double getResultatAttendu() {
        return resultatAttendu;
    }
}

// Classe représentant un ensemble d'échantillons
class LotEchantillons {
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

// Classe représentant un neurone d'entrée
class NeuroneEntree {
    // Les neurones de la couche d'entrée ne font rien de spécial, ils passent simplement les valeurs d'entrée
}

// Classe représentant un neurone de sortie
class NeuroneSortie {
    private double[] poids; // Poids des entrées
    private double seuil; // Seuil

    public NeuroneSortie() {
        // Pour la fonction "ET", nous avons deux entrées et un seul neurone de sortie
        poids = new double[] {1, 1}; // Poids pour les deux entrées
        seuil = 1.9; // Seuil arbitraire
    }

    // Méthode d'activation du neurone
    public double activer(double[] entrees) {
        // Calcul de la somme pondérée des entrées
        double sommePonderee = 0;
        for (int i = 0; i < entrees.length; i++) {
            sommePonderee += entrees[i] * poids[i];
        }

        // Activation basée sur un seuil
        return sommePonderee > seuil ? 1 : 0;
    }
}

// Classe représentant le réseau de neurones pour la fonction "ET"
class ReseauNeuronesET {
    private NeuroneEntree[] entrees; // Neurones d'entrée
    private NeuroneSortie sortie; // Neurone de sortie

    public ReseauNeuronesET() {
        entrees = new NeuroneEntree[2]; // Deux entrées binaires
        for (int i = 0; i < entrees.length; i++) {
            entrees[i] = new NeuroneEntree();
        }
        sortie = new NeuroneSortie();
    }

    // Méthode pour propager les entrées à travers le réseau et obtenir la sortie
    public double propager(double entree1, double entree2) {
        // Activation de la couche d'entrée
        double[] entreesActivations = new double[] {entree1, entree2};
        // Activation de la couche de sortie
        return sortie.activer(entreesActivations);
    }
}

public class Main {
    public static void main(String[] args) {
        // Créez un réseau de neurones ET
        ReseauNeuronesET reseauET = new ReseauNeuronesET();

        // Testez le réseau avec différentes combinaisons d'entrées
        double[][] tests = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        for (double[] test : tests) {
            double entree1 = test[0];
            double entree2 = test[1];
            double resultat = reseauET.propager(entree1, entree2);
            System.out.println("Entrées: [" + entree1 + ", " + entree2 + "], Sortie: " + resultat);
        }
    }
}

