package cz.czechitas.ukol3.model;

import java.util.Objects;

public class Pocitac {

    private boolean jeZapnuty;
    private Pamet ram;
    private Procesor cpu;
    private Disk pevnyDisk;
    
    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    public boolean isJeZapnuty() {
        return jeZapnuty;
    }


    public void zapniSe() {
        if (pevnyDisk == null) {
            System.err.println("Cybí disk, nelze spustit.");
            return;
        }
        if (cpu == null) {
            System.err.println("Chybí procesor, nelze spustit.");
            return;
        }
        if (ram == null) {
            System.err.println("Chybí RAM, nelze spustit.");
            return;
        }
        if (jeZapnuty) {
            System.err.println("Počítač nelze znovu zapnout)");
        } else {
            jeZapnuty = true;
            System.out.println("Počítač se zapnul");
        }
    }

    public void vypniSe() {
        if (!jeZapnuty) {
            return;
        }
        jeZapnuty = false;
        System.out.println("Počítač se vypnul");
    }


    public void vytvorSouborOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("Počítač je vypnutý, nelze pracovat se soubory");
            return;
        }
        if (getPevnyDisk().getVyuziteMisto() + velikost >= getPevnyDisk().getKapacita()) {
            System.err.println("Není dostatek místa na disku.");
            return;
        }
        pevnyDisk.setVyuziteMisto(getPevnyDisk().getVyuziteMisto() + velikost);
        System.out.println("Vytvořil se soubor o velikosti " + velikost + "B a vyuzité místo se zvětšilo");
    }

    public void vymazSouborOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("Počítač je vypnutý, nelze pracovat se soubory");
            return;
        }
        if (getPevnyDisk().getVyuziteMisto() - velikost <= 0 || velikost > getPevnyDisk().getVyuziteMisto()) {
            System.err.println("Soubor této velikosti nelze smazat.");
            return;
        }
        pevnyDisk.setVyuziteMisto(getPevnyDisk().getVyuziteMisto() - velikost);
        System.out.println("Vymazal se soubor o velikosti " + velikost + "B a využité místo na disku se snížilo.");
    }

    @Override
    public String toString() {
        if (jeZapnuty) {
            return "Počítač je zapnutý.";
        }
        return "Počítač je vypnutý.";
    }
}
