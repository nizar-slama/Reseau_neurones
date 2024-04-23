package reseau_neurones;

public class NeuroneSortie extends Neurone {
    public NeuroneSortie(int nombreDeLiens) {
        super(nombreDeLiens);
    }

    @Override
    public double activer(double[] entrees) {
        double somme = 0;
        int minLen = Math.min(entrees.length, poids.length);
        for (int i = 0; i < minLen; i++) {
            somme += entrees[i] * poids[i];
        }
        // Pour le neurone de sortie, retourne la somme directement
        return somme;
    }
}
