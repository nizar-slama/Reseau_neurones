package NeuroneBac;

import java.util.ArrayList;

class Echantillon {
    private double[] notes;
    private boolean reussite;

    public Echantillon(double[] notes, boolean reussite) {
        this.notes = notes;
        this.reussite = reussite;
    }

    public double[] getNotes() {
        return notes;
    }

    public boolean isReussite() {
        return reussite;
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

    public boolean activer(double[] notes) {
        double sommePonderee = 0;
        for (int i = 0; i < notes.length; i++) {
            sommePonderee += notes[i] * poids[i];
        }
        double moyenne = sommePonderee / poids.length;
        return moyenne >= biais;
    }
}

class ReseauNeuronesBAC {
    private NeuroneSortie neuroneSortie;

    public ReseauNeuronesBAC(double[] coefficients) {
        this.neuroneSortie = new NeuroneSortie(coefficients, 10.0);
    }

    public boolean propager(double[] notes) {
        return neuroneSortie.activer(notes);
    }
}

public class Main {
    public static void main(String[] args) {
        double[] coefficients = {12, 16, 10, 8, 8}; // MATH, NSI, PC, SVT, SI
        ReseauNeuronesBAC reseauBAC = new ReseauNeuronesBAC(coefficients);

        double[] notesEleve1 = {14, 10, 20, 15, 16}; // HAL
        boolean reussiteAttendue1 = true; // Supposons qu'il a réussi selon les notes fournies
        double[] notesEleve2 = {7, 14, 2, 12, 8}; // IBM
        boolean reussiteAttendue2 = false; // Supposons qu'il a échoué selon les notes fournies

        LotEchantillons lotEchantillons = new LotEchantillons();
        lotEchantillons.ajouterEchantillon(new Echantillon(notesEleve1, reussiteAttendue1));
        lotEchantillons.ajouterEchantillon(new Echantillon(notesEleve2, reussiteAttendue2));

        for (Echantillon echantillon : lotEchantillons.getEchantillons()) {
            boolean resultat = reseauBAC.propager(echantillon.getNotes());
            System.out.println("Élève réussite: " + resultat + " Attendu: " + echantillon.isReussite());
        }
    }
}
