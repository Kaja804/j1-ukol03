package cz.czechitas.ukol3.model;

import cz.czechitas.ukol3.HlavniProgram;

public class Disk {

    private long kapacita;                      // v bajtech
    private long vyuziteMisto;                  // v bajtech

    public long getKapacita() {
        return kapacita;
    }

    public void setKapacita(long kapacita) {
        if (kapacita < 10) {
            System.err.println("Disk je přiliš malý");
            return;
        }
        this.kapacita = kapacita;
    }

    public long getVyuziteMisto() {
        return vyuziteMisto;
    }

    public void setVyuziteMisto(long vyuziteMisto) {
        if (vyuziteMisto > kapacita || vyuziteMisto < 0L) {
            System.err.println("Nesprávně zadaná hodnota.");
        }
        this.vyuziteMisto = vyuziteMisto;
    }

    @Override
    public String toString() {
        return "Disk:" +
                "kapacita:" + kapacita +
                "B, využité místo:" + vyuziteMisto +
                "B";
    }
}
