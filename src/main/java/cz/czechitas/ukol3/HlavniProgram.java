package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Disk;
import cz.czechitas.ukol3.model.Pamet;
import cz.czechitas.ukol3.model.Pocitac;
import cz.czechitas.ukol3.model.Procesor;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        //TODO tady bude váš kód - vytvoření instance třídy Pocitac, zapnutí, vpynutí, výpis hodnot.
        System.out.println("Program spuštěn.");
        Pocitac kajinPocitac = new Pocitac();


        Disk kajinDisk = new Disk();
        kajinDisk.setKapacita(477_000_000_000L);
        kajinDisk.setVyuziteMisto(199_000_000_000L);
        kajinPocitac.setPevnyDisk(kajinDisk);


        Pamet kajinaPamet = new Pamet();
        kajinaPamet.setKapacita(8_000_000_000L);
        kajinPocitac.setRam(kajinaPamet);

        Procesor kajinProcesor = new Procesor();
        kajinProcesor.setRychlost(2_420_000_000L);
        kajinProcesor.setVyrobce("Intel");
        kajinPocitac.setCpu(kajinProcesor);

        System.out.println(kajinProcesor);
        System.out.println(kajinDisk);
        System.out.println(kajinaPamet);
        System.out.println(kajinPocitac);
        kajinPocitac.zapniSe();
        System.out.println(kajinPocitac);
        kajinPocitac.vytvorSouborOVelikosti(20_000_000L);
        System.out.println(kajinDisk);
        kajinPocitac.vytvorSouborOVelikosti(279_000_000_000L);
        kajinPocitac.vymazSouborOVelikosti(1_000_000_000L);
        System.out.println(kajinDisk);
        kajinPocitac.vymazSouborOVelikosti(1_000_000_000_000L);

    }

}
