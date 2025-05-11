package cz.czechitas.ukol3.model;

public class Pamet {

    private long kapacita;              // v bajtech

    public long getKapacita() {
        return kapacita;
    }

    public void setKapacita(long kapacita) {
        if (kapacita <= 499_000_000L) {
            System.err.println("Příliš malá RAM.");
            return;
        }
        this.kapacita = kapacita;
    }

    @Override
    public String toString() {
        return "Pamet:" +
                kapacita +
                "B";
    }
}
