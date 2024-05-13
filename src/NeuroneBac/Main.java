package NeuroneBac;

import java.util.ArrayList;

class Echantillon {
    private String nom;
    private double[] notes;
    private String mentionAttendue;

    public Echantillon(String nom, double[] notes, String mentionAttendue) {
        this.nom = nom;
        this.notes = notes;
        this.mentionAttendue = mentionAttendue;
    }

    public String getNom() {
        return nom;
    }

    public double[] getNotes() {
        return notes;
    }

    public String getMentionAttendue() {
        return mentionAttendue;
    }
}

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

class NeuroneSortie {
    private double[] poids;
    private double biais;

    public NeuroneSortie(double[] poids, double biais) {
        this.poids = poids;
        this.biais = biais;
    }

    public String activer(double[] notes) {
        double sommePonderee = 0;
        for (int i = 0; i < notes.length; i++) {
            sommePonderee += notes[i] * poids[i];
        }
        double sommeCoefficients = 0;
        for (int i = 0; i < notes.length; i++) {
            sommeCoefficients += poids[i];
        }
        double moyenne = sommePonderee / sommeCoefficients;

        if (moyenne < biais) {
            return "Échec";
        } else if (moyenne < 12) {
            return "Passable";
        } else if (moyenne < 14) {
            return "Assez Bien";
        } else if (moyenne < 16) {
            return "Bien";
        } else {
            return "Très Bien";
        }
    }
}


class ReseauNeuronesBAC {
    private NeuroneSortie neuroneSortie;

    public ReseauNeuronesBAC(double[] coefficients) {
        this.neuroneSortie = new NeuroneSortie(coefficients, 10.0);
    }

    public String propager(double[] notes) {
        return neuroneSortie.activer(notes);
    }

    // Méthode pour évaluer le coût basé sur la précision des prédictions
    public double evaluerCout(ArrayList<Echantillon> echantillons) {
        int nombreErreurs = 0;
        for (Echantillon echantillon : echantillons) {
            String prediction = propager(echantillon.getNotes());
            if (!prediction.equals(echantillon.getMentionAttendue())) {
                nombreErreurs++;
            }
        }
        return (double) nombreErreurs / echantillons.size(); // Retourne le taux d'erreur
    }
}

public class Main {
    public static void main(String[] args) {
        double[] coefficients = {12, 16, 10, 8, 8}; // MATH, NSI, PC, SVT, SI
        ReseauNeuronesBAC reseauBAC = new ReseauNeuronesBAC(coefficients);

        LotEchantillons lotEchantillons = new LotEchantillons();
        lotEchantillons.ajouterEchantillon(new Echantillon("HAL", new double[]{14, 10, 20, 15, 16}, "Bien"));
        lotEchantillons.ajouterEchantillon(new Echantillon("IBM", new double[]{7, 14, 2, 12, 8}, "Échec"));
        lotEchantillons.ajouterEchantillon(new Echantillon("JCN", new double[]{14, 13, 6, 4, 8}, "Échec"));
        lotEchantillons.ajouterEchantillon(new Echantillon("KDO", new double[]{6, 11, 16, 12, 20}, "Échec"));
        lotEchantillons.ajouterEchantillon(new Echantillon("LEP", new double[]{4, 12, 4, 18, 12}, "Échec"));
        lotEchantillons.ajouterEchantillon(new Echantillon("MFQ", new double[]{9, 10.4, 8, 10, 13}, "Échec"));
        lotEchantillons.ajouterEchantillon(new Echantillon("NGR", new double[]{10, 7.4, 6, 14, 16}, "Échec"));
        lotEchantillons.ajouterEchantillon(new Echantillon("OHS", new double[]{4, 8, 10, 12, 18}, "Échec"));
        lotEchantillons.ajouterEchantillon(new Echantillon("PIT", new double[]{5, 13, 5, 14, 12}, "Échec"));
        lotEchantillons.ajouterEchantillon(new Echantillon("QJU", new double[]{6, 19, 12, 8, 10}, "Assez Bien"));


        double cout = reseauBAC.evaluerCout(lotEchantillons.getEchantillons());
        System.out.println("Coût total (taux d'erreur) : " + cout);

        for (Echantillon echantillon : lotEchantillons.getEchantillons()) {
            String resultat = reseauBAC.propager(echantillon.getNotes());
            System.out.println("Élève " + echantillon.getNom() + " - Résultat: " + resultat + " - Attendu: " + echantillon.getMentionAttendue());
        }
    }
}




/* Nous sommes actuellement en train de mettre à jour le code.
Merci de votre patience pendant que nous travaillons à l'amélioration de l'expérience utilisateur
 */