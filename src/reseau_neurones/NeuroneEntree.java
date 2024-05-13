package reseau_neurones;

public class NeuroneEntree extends Neurone {
    public NeuroneEntree(int nombreDeLiens) {
        super(nombreDeLiens);
    }

    @Override
    public double activer(double[] entrees) {
        double somme = 0;
        for (int i = 0; i < entrees.length; i++) {
            somme += entrees[i] * poids[i];
        }
        // Envoie la valeur calculée (pas de seuil ici car il s'agit de la couche d'entrée)
        return somme;
    }
}
