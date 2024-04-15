package reseau_neurones;

public abstract class Neurone {
    protected double[] poids;
    protected double seuil;

    // Constructeur mis à jour pour accepter les poids et le seuil comme arguments
    public Neurone(double[] poids, double seuil) {
        this.poids = poids;
        this.seuil = seuil;
    }

    public abstract double activer(double[] entrees);
}
