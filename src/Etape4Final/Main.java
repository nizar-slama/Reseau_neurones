package Etape4Final;

import java.util.ArrayList;

// Classe représentant un neurone générique
class Neurone {
    private double[] poids; // Poids des entrées
    private double seuil; // Seuil
    private double tauxApprentissage; // Taux d'apprentissage µ
    private double momentum; // Coefficient de momentum α
    private double[] deltaPoidsPrecedents; // Correction de poids de l'itération précédente

    // Constructeur pour initialiser le neurone avec un nombre spécifique d'entrées
    public Neurone(int nombreEntrees, double[] valeursPoids, double valeurSeuil, double tauxApprentissage, double momentum) {
        poids = new double[nombreEntrees];
        deltaPoidsPrecedents = new double[nombreEntrees];
        this.tauxApprentissage = tauxApprentissage;
        this.momentum = momentum;

        // Étape 1 : Initialisation des poids et du seuil
        for (int i = 0; i < nombreEntrees; i++) {
            poids[i] = valeursPoids[i]; // Assignation des valeurs fixes
            deltaPoidsPrecedents[i] = 0; // Initialiser les corrections de poids précédentes à zéro
        }
        seuil = valeurSeuil;
    }

    // Méthode d'activation du neurone
    public double activer(double[] entrees) {
        double sommePonderee = 0;
        // Étape 3 : Calcul de la somme pondérée des entrées
        for (int i = 0; i < entrees.length; i++) {
            sommePonderee += entrees[i] * poids[i];
        }
        // Application du seuil pour obtenir la sortie
        double sortie = sommePonderee - seuil;
        return sortie;
    }

    // Méthode pour mettre à jour les poids
    public void mettreAJourPoids(double[] entrees, double erreur) {
        // Étape 4 : Mise à jour des poids
        for (int i = 0; i < poids.length; i++) {
            // Calcul de la correction du poids
            double deltaPoids = -tauxApprentissage * erreur * entrees[i] + momentum * deltaPoidsPrecedents[i];
            poids[i] += deltaPoids; // Mise à jour du poids
            deltaPoidsPrecedents[i] = deltaPoids; // Stocker la correction pour la prochaine itération
        }
    }

    // Méthodes pour obtenir les poids et le seuil (pour vérification)
    public double[] getPoids() {
        return poids;
    }

    public double getSeuil() {
        return seuil;
    }
}

// Classe représentant un échantillon d'entrée avec le résultat attendu
class Echantillon {
    double[] entrees; // Entrées de l'échantillon
    double resultatAttendu; // Résultat attendu pour ces entrées

    public Echantillon(double[] entrees, double resultatAttendu) {
        this.entrees = entrees;
        this.resultatAttendu = resultatAttendu;
    }

    // Getters pour récupérer les entrées et le résultat attendu
    public double[] getEntrees() {
        return entrees;
    }

    public double getResultatAttendu() {
        return resultatAttendu;
    }
}

// Classe représentant un réseau de neurones
class ReseauNeurones {
    private Neurone neuroneSortie; // Neurone de sortie unique

    public ReseauNeurones(double[] valeursPoids, double valeurSeuil, double tauxApprentissage, double momentum) {
        // Initialisation du neurone de sortie avec les paramètres spécifiés
        neuroneSortie = new Neurone(valeursPoids.length, valeursPoids, valeurSeuil, tauxApprentissage, momentum);
    }

    // Propager les entrées à travers le réseau et obtenir la sortie
    public double propager(double[] entrees) {
        // Étape 3 : Propagation des entrées et calcul de la sortie
        return neuroneSortie.activer(entrees);
    }

    // Calculer l'erreur pour un lot d'échantillons
    public double calculerErreur(ArrayList<Echantillon> echantillons) {
        double erreurTotale = 0;
        // Étape 2 : Calcul de l'erreur totale pour le lot d'échantillons
        for (Echantillon echantillon : echantillons) {
            double sortieReseau = propager(echantillon.getEntrees());
            // Erreur quadratique
            double erreurEchantillon = 0.5 * Math.pow(sortieReseau - echantillon.getResultatAttendu(), 2);
            erreurTotale += erreurEchantillon;
        }
        return erreurTotale / echantillons.size(); // Moyenne de l'erreur
    }

    // Mise à jour des poids pour un lot d'échantillons
    public void ajusterPoids(ArrayList<Echantillon> echantillons) {
        // Étape 4 : Ajustement des poids pour chaque échantillon
        for (Echantillon echantillon : echantillons) {
            double sortieReseau = propager(echantillon.getEntrees());
            double erreur = sortieReseau - echantillon.getResultatAttendu();
            // Mise à jour des poids du neurone de sortie
            neuroneSortie.mettreAJourPoids(echantillon.getEntrees(), erreur);
        }
    }

    // Entraîner le réseau jusqu'à ce que le critère d'arrêt soit atteint
    public void entrainer(ArrayList<Echantillon> echantillons, int maxIterations, double seuilErreur) {
        int iteration = 0;
        double erreur = calculerErreur(echantillons);

        // Étape 5 : Vérifier le critère d'arrêt et boucler si nécessaire
        while (iteration < maxIterations && erreur > seuilErreur) {
            System.out.println("Iteration " + iteration + ": Erreur = " + erreur);
            ajusterPoids(echantillons); // Ajuster les poids
            erreur = calculerErreur(echantillons); // Recalculer l'erreur
            iteration++;
        }

        System.out.println("Entraînement terminé après " + iteration + " itérations avec une erreur de " + erreur);
    }
}

// Classe principale pour tester le réseau de neurones complet
public class Main {
    public static void main(String[] args) {
        // Définir les valeurs initiales des poids et du seuil
        double[] valeursPoids = {0.1, -0.2, 0.3}; // Exemple de valeurs fixes pour les poids
        double valeurSeuil = 0.05; // Exemple de valeur fixe pour le seuil
        double tauxApprentissage = 0.01; // Exemple de taux d'apprentissage
        double momentum = 0.9; // Exemple de coefficient de momentum
        int maxIterations = 1000; // Nombre maximal d'itérations
        double seuilErreur = 0.001; // Seuil d'erreur pour le critère d'arrêt

        // Création du réseau de neurones avec les paramètres spécifiés
        ReseauNeurones reseau = new ReseauNeurones(valeursPoids, valeurSeuil, tauxApprentissage, momentum);

        // Création et ajout des échantillons pour tester le réseau
        ArrayList<Echantillon> echantillons = new ArrayList<>();
        echantillons.add(new Echantillon(new double[]{0.1, 0.2, 0.3}, 1.0));
        echantillons.add(new Echantillon(new double[]{0.2, 0.2, 0.2}, 0.0));
        echantillons.add(new Echantillon(new double[]{0.3, 0.2, 0.1}, 1.0));

        // Entraînement du réseau de neurones
        reseau.entrainer(echantillons, maxIterations, seuilErreur);

        // Affichage des résultats de la propagation pour chaque échantillon après entraînement
        for (Echantillon echantillon : echantillons) {
            double resultat = reseau.propager(echantillon.getEntrees());
            System.out.println("Entrées : " + arrayToString(echantillon.getEntrees()) +
                    ", Sortie prédite : " + resultat +
                    ", Résultat attendu : " + echantillon.getResultatAttendu());
        }
    }

    // Méthode utilitaire pour convertir un tableau en chaîne de caractères
    private static String arrayToString(double[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
