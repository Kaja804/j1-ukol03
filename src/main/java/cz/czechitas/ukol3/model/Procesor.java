package cz.czechitas.ukol3.model;

public class Procesor {

    private String vyrobce;
    private long rychlost;      // v Hz

    public String getVyrobce() {
        return vyrobce;
    }

    public void setVyrobce(String vyrobce) {
        this.vyrobce = vyrobce;
    }

    public long getRychlost() {
        return rychlost;
    }

    public void setRychlost(long rychlost) {
        if (rychlost <= 499_000_000L) {
            System.err.println("příliš nízká rychlost procesoru nebo špatně zadaná hodnota.");
        }
        this.rychlost = rychlost;
    }

    @Override
    public String toString() {
        return "Procesor:" +
                vyrobce +
                " " + rychlost +
                "Hz";
    }
}
