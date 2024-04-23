// Déclaration du package auquel appartient la classe.
package reseau_neurones;

// Définition de la classe Couche.
public class Couche {
    // Déclaration d'un tableau pour stocker les neurones de cette couche.
    private Neurone[] neurones;
    // Déclaration d'une chaîne pour identifier le type de cette couche (entrée, cache ou sortie).
    private String typeDeCouche;

    // Constructeur de la classe Couche prenant le nombre de neurones, le type de la couche et le nombre de liens pour chaque neurone.
    public Couche(int nombreDeNeurones, String typeDeCouche, int nombreDeLiens) {
        // Initialisation du type de la couche.
        this.typeDeCouche = typeDeCouche;
        // Initialisation du tableau de neurones avec le nombre de neurones spécifié.
        this.neurones = new Neurone[nombreDeNeurones];

        // Boucle pour initialiser chaque neurone du tableau.
        for (int i = 0; i < nombreDeNeurones; i++) {
            // Utilisation d'une structure conditionnelle pour initialiser les neurones en fonction du type de couche.
            switch (typeDeCouche) {
                case "entree": // Cas où la couche est une couche d'entrée.
                    neurones[i] = new NeuroneEntree(nombreDeLiens);
                    break;
                case "cache": // Cas où la couche est une couche cachée.
                    neurones[i] = new NeuroneCache(nombreDeLiens);
                    break;
                case "sortie": // Cas où la couche est une couche de sortie.
                    neurones[i] = new NeuroneSortie(nombreDeLiens);
                    break;
            }
        }
    }

    // Méthode pour activer la couche, c'est-à-dire pour calculer les sorties de tous les neurones de la couche en fonction des entrées données.
    public double[] activerCouche(double[] entrees) {
        // Création d'un tableau pour stocker les sorties de chaque neurone.
        double[] sorties = new double[neurones.length];
        // Boucle pour activer chaque neurone avec les entrées fournies et stocker le résultat dans le tableau de sorties.
        for (int i = 0; i < neurones.length; i++) {
            sorties[i] = neurones[i].activer(entrees);
        }
        // Retour du tableau de sorties.
        return sorties;
    }
}
