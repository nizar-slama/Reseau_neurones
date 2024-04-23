package NeuroneXOR;

import java.util.ArrayList;

// Classe représentant un échantillon d'entrée avec le résultat attendu
class Echantillon {
    private double[] entrees;
    private double resultatAttendu;

    public Echantillon(double[] entrees, double resultatAttendu) {
        this.entrees = entrees;
        this.resultatAttendu = resultatAttendu;
    }

    public double[] getEntrees() {
        return entrees;
    }

    public double getResultatAttendu() {
        return resultatAttendu;
    }
}

// Classe représentant un ensemble d'échantillons
class LotEchantillons {
    private ArrayList<Echantillon> echantillons;

    public LotEchantillons() {
        this.echantillons = new ArrayList<>();
    }

    public void ajouterEchantillon(Echantillon echantillon) {
        echantillons.add(echantillon);
    }

    public ArrayList<Echantillon> getEchantillons() {
        return echantillons;
    }
}

// Classe représentant un neurone
class Neurone {
    private double[] poids;
    private double seuil;

    public Neurone(double[] poids, double seuil) {
        this.poids = poids;
        this.seuil = seuil;
    }

    public double activer(double[] entrees) {
        double sommePonderee = 0;
        for (int i = 0; i < entrees.length; i++) {
            sommePonderee += entrees[i] * poids[i];
        }
        return sommePonderee >= seuil ? 1.0 : 0.0;
    }
}

// Classe représentant le réseau de neurones pour la fonction "XOR"
class ReseauNeuronesXOR {
    private Neurone[] coucheCachee;
    private Neurone sortie;

    public ReseauNeuronesXOR() {
        coucheCachee = new Neurone[] {
                new Neurone(new double[]{1.0, 1.0}, 0.5), // Neurone pour "OR"
                new Neurone(new double[]{-1.0, -1.0}, -1.5) // Neurone pour "NAND"
        };
        sortie = new Neurone(new double[]{1.0, 1.0}, 1.5); // Poids et seuil pour "XOR"
    }

    public double propager(double entree1, double entree2) {
        double[] entreesCoucheCachee = new double[coucheCachee.length];
        for (int i = 0; i < coucheCachee.length; i++) {
            entreesCoucheCachee[i] = coucheCachee[i].activer(new double[]{entree1, entree2});
        }
        return sortie.activer(entreesCoucheCachee);
    }
}

// Classe principale pour tester le réseau "XOR"
public class Main {
    public static void main(String[] args) {
        ReseauNeuronesXOR reseauXOR = new ReseauNeuronesXOR();

        double[][] tests = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        for (double[] test : tests) {
            double resultat = reseauXOR.propager(test[0], test[1]);
            System.out.println("Entrées: [" + test[0] + ", " + test[1] + "], Sortie: " + resultat);
        }
    }
}
