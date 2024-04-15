package reseau_neurones;

public class LotEchantillons {
    private Echantillon[] echantillons;

    public LotEchantillons(Echantillon[] echantillons) {
        this.echantillons = echantillons;
    }

    public Echantillon[] getEchantillons() {
        return echantillons;
    }
}
