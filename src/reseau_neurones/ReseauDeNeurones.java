package reseau_neurones;

public class ReseauDeNeurones {
    private Couche[] couches;

    public ReseauDeNeurones(int[] configuration, String[] types) {
        this.couches = new Couche[configuration.length];
        for (int i = 0; i < configuration.length; i++) {
            int nombreDeLiens = i < configuration.length - 1 ? configuration[i + 1] : 0;
            couches[i] = new Couche(configuration[i], types[i], nombreDeLiens);
        }
    }

    public double[] propager(double[] entrees) {
        double[] sorties = entrees;
        for (Couche couche : couches) {
            sorties = couche.activerCouche(sorties);
        }
        return sorties;
    }
}
