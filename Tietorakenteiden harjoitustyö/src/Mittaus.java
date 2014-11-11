/**
 * @author Hanna Hirvonen
 * 
 * Mittausohjelma, jolla tietorakenteita voidaan vertailla. 
 * 
 */

import java.util.ArrayList;

public class Mittaus {

    private Fibonaccikeko fkeko;
    private Binaarikeko bkeko;
    private ArrayList<Long> tulokset;
    private ArrayList<String> metodit;
    private int tulostusLeveys;
    private int ylaRaja;
    private int alaRaja;
    private long aikaraja = 10000;

    /**
     * Luokka tulostuksen muotoilulle.
     */
    private class Formatter {
        
        /**
         * Konstruktorissa määritellään tulostuksen leveys.
         */
        public Formatter() {
           
            for (String metodi : metodit) {
                if (metodi.length() > tulostusLeveys) {
                    tulostusLeveys = metodi.length() + 2;
                }
            }

            String raja = "" + ylaRaja;
            if (raja.length() > tulostusLeveys) {
                tulostusLeveys = raja.length() + 1;
            }
        }

        /**
         * Formatoidaan long-tyyppinen muuttuja.
         * 
         * @param luku
         * @return String
         */
        private String format(long luku) {
            String format = "%" + tulostusLeveys + "d";
            return String.format(format, luku);
        }

        /**
         * Formatoidaan String-tyyppinen muuttuja.
         * 
         * @param nimi
         * @return String
         */
        private String format(String nimi) {
            String format = "%" + tulostusLeveys + "s";
            return String.format(format, nimi);
        }

        /**
         * Tehdään tulostusrivit.
         * 
         * @param tulokset
         * @return String
         */
        private String teeRivi(ArrayList<Long> tulokset) {
            Formatter f = new Formatter();

            String mj = "";
            for (long tulos : tulokset) {
                mj += f.format(tulos);
            }
            return mj;
        }

        /**
         * Tehdään rivi otsikoille.
         * 
         * @param rakenne
         * @return String
         */
        private String teeOtsikkorivi(String rakenne) {
            Formatter f = new Formatter();

            String mj = rakenne + "\n\n";

            mj += f.format("n");
            for (String metodi : metodit) {
                mj += f.format(metodi);
            }

            return mj;
        }
    }

    /**
     * Tehdään mittaukset ja tulostetaan tulokset.
     * 
     * @param rakenne
     * @throws Exception 
     */
    public void teeJaTulosta(String rakenne) throws Exception {
        Formatter f = new Formatter();
        String otsikko = f.teeOtsikkorivi(rakenne);

        System.out.println(otsikko);
        
        if (rakenne.equals("Fibonacci-keko")) {
            
            tulokset = new ArrayList<Long>();
            for (int i = alaRaja; i < ylaRaja; i *= 2) {
                tulokset.add((long) i);
                tulokset.add(mittaaAikaLisaaF(i));
                tulokset.add(mittaaAikaPoistaF(i));
                tulokset.add(mittaaAikaMinimiF(i));
                tulokset.add(mittaaAikaMuutaF(i));
                String tulostusRivi = f.teeRivi(tulokset);
                System.out.println(tulostusRivi);
                tulokset = new ArrayList<Long>();
            }
        }
        
         if (rakenne.equals("Binäärikeko")) {
            
            tulokset = new ArrayList<Long>();
            for (int i = alaRaja; i < ylaRaja; i *= 2 ) {
                tulokset.add((long) i);
                tulokset.add(mittaaAikaLisaaB(i));
                tulokset.add(mittaaAikaPoistaB(i));
                tulokset.add(mittaaAikaMinimiB(i));
                tulokset.add(mittaaAikaMuutaB(i));
                String tulostusRivi = f.teeRivi(tulokset);
                System.out.println(tulostusRivi);
                tulokset = new ArrayList<Long>();
            }
        }
    }
    
    /**
     * Konstruktori luo ArrayListin, joka ottaa arvoikseen String-tyyppisiä
     * arvoja.
     */
    public Mittaus() {

        metodit = new ArrayList<String>();
    }
    /**
     * Palauttaa mittauksen alarajan.
     * 
     * @return alaraja
     */
    public int getAlaRaja() {
        return alaRaja;
    }

    /**
     * Asettaa mittauksen alarajan.
     */
    public void setAlaRaja(int alaRaja) {
        this.alaRaja = alaRaja;
    }

    /**
     * Palauttaa mittauksen ylärajan.
     * 
     * @return ayläraja
     */
    public int getYlaRaja() {
        return ylaRaja;
    }

    /**
     * Asettaa mittauksen ylärajan.
     */
    public void setYlaRaja(int ylaRaja) {
        this.ylaRaja = ylaRaja;
    }
       

    // ************AJANMITTAAJAT**************
    
    /**
     * Fibonacci-keko mittaus: lisää
     * 
     * @param operaatioita
     * @return long
     * @throws Exception 
     */
    public long mittaaAikaLisaaF(int operaatioita) throws Exception {
        fkeko = new Fibonaccikeko();
        long alku = System.currentTimeMillis();
        for (int i = 0; i < operaatioita; i++) {
//            testi.lisaa((int) ((2 * operaatioita) * Math.random() + operaatioita + 1));
            fkeko.lisaa((int) (operaatioita * Math.random() + 1));
        }
        long loppu = System.currentTimeMillis();
        return loppu - alku;
    }

    /**
     * Fibonacci-keko mittaus: poista
     * 
     * @param operaatioita
     * @return long
     * @throws Exception 
     */
    private long mittaaAikaPoistaF(int operaatioita) throws Exception {
        fkeko = new Fibonaccikeko();
        for (int i = 0; i < operaatioita; i++) {
            fkeko.lisaa((int) (operaatioita * Math.random() + 1));
        }
        long alku = System.currentTimeMillis();
        for (int i = 0; i < operaatioita; i++) {
            fkeko.poista(fkeko.returnMin());
        }
        long loppu = System.currentTimeMillis();
        return loppu - alku;
    }

    /**
     * Fibonacci-keko mittaus: poista minimi
     * 
     * @param operaatioita
     * @return long
     * @throws Exception 
     */
    private long mittaaAikaMinimiF(int operaatioita) throws Exception {
        fkeko = new Fibonaccikeko();
        for (int i = 0; i < operaatioita; i++) {
            fkeko.lisaa((int) (operaatioita * Math.random() + 1));
        }
        long alku = System.currentTimeMillis();
        for (int i = 0; i < operaatioita; i++) {
            fkeko.poistaMinimi();
        }
        long loppu = System.currentTimeMillis();
        return loppu - alku;
    }

    /**
     * Fibonacci-keko mittaus: muuta arvoa
     * 
     * @param operaatioita
     * @return long
     * @throws Exception 
         */
    private long mittaaAikaMuutaF(int operaatioita) throws Exception {
        fkeko = new Fibonaccikeko();
        for (int i = 0; i < operaatioita+1; i++) {
            fkeko.lisaa((int) ((2*operaatioita) * Math.random() + operaatioita+1));
        }
        fkeko.poistaMinimi();
        long alku = System.currentTimeMillis();
        for (int i = 0; i < operaatioita; i++) {
            int arvo = operaatioita-1;
            fkeko.muutaArvoa(fkeko.returnMin().oikea, arvo);
        }
        long loppu = System.currentTimeMillis();
        return loppu - alku;
    }
    
    /**
     * Binäärikeko mittaus: lisää
     * 
     * @param operaatioita
     * @return long
     * @throws Exception 
     */
    private long mittaaAikaLisaaB(int operaatioita) throws Exception {
        bkeko = new Binaarikeko(operaatioita);
        long alku = System.currentTimeMillis();
        for (int i = 0; i < operaatioita; i++) {
//            testi.lisaa((int) ((2 * operaatioita) * Math.random() + operaatioita + 1));
            bkeko.lisaa((int) (operaatioita * Math.random() + 1));
        }
        long loppu = System.currentTimeMillis();
        return loppu - alku;
    }

    /**
     * Binäärikeko mittaus: poista 
     * 
     * @param operaatioita
     * @return long
     * @throws Exception 
     */
    private long mittaaAikaPoistaB(int operaatioita) throws Exception {
        bkeko = new Binaarikeko(operaatioita);
        for (int i = 0; i < operaatioita; i++) {
            bkeko.lisaa((int) (operaatioita * Math.random() + 1));
        }
        long alku = System.currentTimeMillis();
        for (int i = 0; i < operaatioita; i++) {
            bkeko.poista(0);
        }
        long loppu = System.currentTimeMillis();
        return loppu - alku;
    }
    
    /**
     * Binäärikeko mittaus: poista minimi
     * 
     * @param operaatioita
     * @return long
     * @throws Exception 
     */
    private long mittaaAikaMinimiB(int operaatioita) throws Exception {
        bkeko = new Binaarikeko(operaatioita);
        long alku = System.currentTimeMillis();
        for (int i = 0; i < operaatioita; i++) {
            bkeko.lisaa((int) (operaatioita * Math.random() + 1));
        }
        for (int i = 0; i < operaatioita; i++) {
            bkeko.poistaMinimi();
        }
        long loppu = System.currentTimeMillis();
        return loppu - alku;
    }
    
    /**
     * Binäärikeko mittaus: muuta
     * 
     * @param operaatioita
     * @return long
     * @throws Exception 
     */
    public long mittaaAikaMuutaB(int operaatioita) throws Exception {
        bkeko = new Binaarikeko(operaatioita);
        for (int i = 0; i < operaatioita+1; i++) {
            bkeko.lisaa((int) ((2*operaatioita) * Math.random() + operaatioita+1));
        }
        bkeko.poistaMinimi();
        long alku = System.currentTimeMillis();
        for (int i = 0; i < operaatioita; i++) {
            int arvo = operaatioita-1;
            bkeko.muutaArvoa(bkeko.getKoko()-1, arvo);
        }
        long loppu = System.currentTimeMillis();
        return loppu - alku;
    }
    
    
    public static void main(String[] args) throws Exception {

        Mittaus mittaaja = new Mittaus();
        mittaaja.metodit.add("lisää");
        mittaaja.metodit.add("poista");
        mittaaja.metodit.add("poistaMin");
        mittaaja.metodit.add("muuta");
        
        mittaaja.setAlaRaja(5000);
        mittaaja.setYlaRaja(5000000);

        mittaaja.teeJaTulosta("Binäärikeko");
        System.out.println("");
        mittaaja.teeJaTulosta("Fibonacci-keko");

    }
}
