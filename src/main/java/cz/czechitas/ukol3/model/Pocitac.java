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
        }else {
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

    @Override
    public String toString() {
        if (jeZapnuty) {
            return "Počítač je zapnutý.";
        }
        return "Počítač je vypnutý.";
    }
}
