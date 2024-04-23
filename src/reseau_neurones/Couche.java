package reseau_neurones;

public class Couche {
    private Neurone[] neurones;
    private String typeDeCouche;

    public Couche(int nombreDeNeurones, String typeDeCouche, int nombreDeLiens) {
        this.typeDeCouche = typeDeCouche;
        this.neurones = new Neurone[nombreDeNeurones];

        for (int i = 0; i < nombreDeNeurones; i++) {
            switch (typeDeCouche) {
                case "entree":
                    neurones[i] = new NeuroneEntree(nombreDeLiens);
                    break;
                case "cache":
                    neurones[i] = new NeuroneCache(nombreDeLiens);
                    break;
                case "sortie":
                    neurones[i] = new NeuroneSortie(nombreDeLiens);
                    break;
            }
        }
    }

    public double[] activerCouche(double[] entrees) {
        double[] sorties = new double[neurones.length];
        for (int i = 0; i < neurones.length; i++) {
            sorties[i] = neurones[i].activer(entrees);
        }
        return sorties;
    }
}
