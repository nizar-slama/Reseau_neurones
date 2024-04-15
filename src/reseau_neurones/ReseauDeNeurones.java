package reseau_neurones;

public class ReseauDeNeurones {
    private Neurone[] neurones;

    public ReseauDeNeurones(Neurone[] neurones) {
        this.neurones = neurones;
    }

    public int evaluer(double[] entrees) {
        // Simplement propager à travers un seul neurone pour notre fonction ET
        return (int) neurones[0].activer(entrees);
    }
}
