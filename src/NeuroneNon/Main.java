package NeuroneNon;

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

// Classe représentant un neurone de sortie pour la fonction "NON"
class NeuroneSortie {
    private double poids; // Poids de l'entrée
    private double seuil; // Seuil pour l'activation

    public NeuroneSortie() {
        // Pour la fonction "NON", nous avons une seule entrée et un seul neurone de sortie
        poids = -1; // Poids négatif pour inverser l'entrée
        seuil = -0.5; // Seuil négatif pour activer le neurone lorsque l'entrée est 0
    }

    // Méthode d'activation du neurone
    public double activer(double entree) {
        // Calcul de la somme pondérée de l'entrée
        double sommePonderee = entree * poids;

        // Activation basée sur un seuil
        return sommePonderee > seuil ? 1 : 0;
    }
}

// Classe principale pour tester le neurone "NON"
public class Main {
    public static void main(String[] args) {
        NeuroneSortie neuroneNON = new NeuroneSortie();

        // Test du neurone "NON" avec les entrées possibles pour la fonction "NON"
        double[] tests = {0, 1};
        for (double test : tests) {
            double resultat = neuroneNON.activer(test);
            System.out.println("Entrée: " + test + ", Sortie: " + resultat);
        }
    }
}
