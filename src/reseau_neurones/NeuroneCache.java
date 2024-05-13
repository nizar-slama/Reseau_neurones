package reseau_neurones;

public class NeuroneCache extends Neurone {
    public NeuroneCache(int nombreDeLiens) {

        super(nombreDeLiens);
    }

    @Override
    public double activer(double[] entrees) {
        double somme = 0;
        // Assurez-vous que la longueur de entrees et poids est la même
        int minLen = Math.min(entrees.length, poids.length);
        for (int i = 0; i < minLen; i++) {
            somme += entrees[i] * poids[i];
        }
        // Activation basée sur un seuil
        return somme > seuil ? somme : 0;
    }
}
