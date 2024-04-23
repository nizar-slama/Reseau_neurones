package reseau_neurones;


public abstract class Neurone {
    protected double[] poids;
    protected double seuil;

    public Neurone(int nombreDeLiens) {
        this.poids = new double[nombreDeLiens];
        for (int i = 0; i < nombreDeLiens; i++) {
            this.poids[i] = Math.random(); // Initialisation aléatoire des poids
        }
        this.seuil = Math.random(); // Initialisation aléatoire du seuil
    }

    public abstract double activer(double[] entrees);
}
