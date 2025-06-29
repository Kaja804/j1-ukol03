package cz.czechitas.ukol3.model;

import java.util.Objects;

public class Pocitac {

    private boolean jeZapnuty;
    private Pamet ram;
    private Procesor cpu;
    private Disk pevnyDisk;
    private Disk druhyDisk;

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

    public Disk getDruhyDisk() {
        return druhyDisk;
    }

    public void setDruhyDisk(Disk druhyDisk) {
        this.druhyDisk = druhyDisk;
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
        if (getPevnyDisk().getVyuziteMisto() + velikost > getPevnyDisk().getKapacita()) {
        } else {
            pevnyDisk.setVyuziteMisto(getPevnyDisk().getVyuziteMisto() + velikost);
            System.out.println("Vytvořil se soubor o velikosti " + velikost + "B a vyuzité místo pevného disku se zvětšilo na " + getPevnyDisk().getVyuziteMisto() + "B.");
            return;
        }
        if (getDruhyDisk().getVyuziteMisto() + velikost > getDruhyDisk().getKapacita()) {
            System.err.println("Pro soubor velikosti " + velikost + "B není dostatek místa na disku.");
        } else {
            druhyDisk.setVyuziteMisto(getDruhyDisk().getVyuziteMisto() + velikost);
            System.out.println("Vytvořil se soubor o velikosti " + velikost + "B a vyuzité místo druhého disku se zvětšilo na " + getDruhyDisk().getVyuziteMisto() + "B.");
        }

    }

    public void vymazSouborOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("Počítač je vypnutý, nelze pracovat se soubory");
            return;
        }
        if (getPevnyDisk().getVyuziteMisto() - velikost >= 0 && velikost <= getPevnyDisk().getVyuziteMisto()) {
            pevnyDisk.setVyuziteMisto(getPevnyDisk().getVyuziteMisto() - velikost);
            System.out.println("Vymazal se soubor o velikosti " + velikost + "B a využité místo na pevném disku se snížilo na " + getPevnyDisk().getVyuziteMisto() + "B.");
            return;
        }
        if (getDruhyDisk().getVyuziteMisto() - velikost >= 0 && velikost <= getDruhyDisk().getVyuziteMisto()) {
            druhyDisk.setVyuziteMisto(getDruhyDisk().getVyuziteMisto() - velikost);
            System.out.println("Vymazal se soubor o velikosti " + velikost + "B a využité místo na druhém disku se snížilo na " + getDruhyDisk().getVyuziteMisto() + "B.");
        } else {
            System.err.println("Soubor velikosti " + velikost + "B nelze smazat.");
        }
    }

    @Override
    public String toString() {
        if (jeZapnuty) {
            return "Počítač je zapnutý.";
        }
        return "Počítač je vypnutý.";
    }
}
