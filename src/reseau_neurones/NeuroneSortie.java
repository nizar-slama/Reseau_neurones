package reseau_neurones;

public class NeuroneSortie extends Neurone {
    public NeuroneSortie(double[] poids, double seuil) {
        super(poids, seuil);
    }

    @Override
    public double activer(double[] entrees) {
        double somme = 0.0;
        for (int i = 0; i < entrees.length; i++) {
            somme += entrees[i] * poids[i];
        }
        return somme > seuil ? 1 : 0;  // Activation pour une sortie binaire
    }
}