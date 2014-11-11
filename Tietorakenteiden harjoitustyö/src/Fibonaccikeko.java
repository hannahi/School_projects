/**
 * @author Hanna Hirvonen
 * 
 * Fibonacci-keko tietorakenne, jossa operaatiot lisää, poista, poista minimi
 * sekä muuta arvoa.
 * /

/** 
 * @param minimi osoittaa keon pienimpään arvoon
 * @param koko kertoo solmujen lukumäärän
 */
public class Fibonaccikeko {

    private FiboSolmu minimi;
    private int koko;

    /**
     * Konstruktori.
     * 
     * Parametrit minimi ja koko alustetaan.
     */
    public Fibonaccikeko() {
        minimi = null;
        koko = 0;
    }

    /**
     * Palauttaa keon koon (solmujen määrän).
     * 
     * @return koko 
     */
    public int getKoko() {
        return this.koko;
    }

    /**
     * Lisää solmun kekoon:
     * Alustetaan solmun kentät ja lisätään rengaslistaan keon minimin 
     * vasemmalle puolelle. Minimiä päivitetään tarvittaessa. Kekoon hyväksytään
     * vain positiivisia Integer-tyyppisiä arvoja.
     * 
     * @param avain
     */
    public void lisaa(int avain) throws Exception {
        if (avain < 0) {
            throw new Exception("Arvo negatiivinen!");
        }

        FiboSolmu solmu = new FiboSolmu(avain);
        solmu.aste = 0;
        solmu.vanhempi = null;
        solmu.lapsi = null;
        solmu.vasen = solmu.oikea = solmu;
        solmu.merkitty = false;

        if (minimi != null) {
            solmu.oikea = minimi;
            solmu.vasen = minimi.vasen;
            minimi.vasen = solmu;
            solmu.vasen.oikea = solmu;
            if (solmu.avain < minimi.avain) {
                minimi = solmu;
            }
        } else {
            minimi = solmu;
        }

        koko++;
    }

    /**
     * Palauttaa keon minimisolmun.
     * 
     * @return minimi
     */
    public FiboSolmu returnMin() {
        return minimi;
    }

    /**
     * Poistaa solmun keosta: 
     * Ensiksi solmun avaimen arvo muutetaan negatiiviseksi.
     * (Keosta löytyy vain positiivisia arvoja.)
     * Lopuksi pienin arvo poistetaan.
     * 
     * @param solmu 
     */
    public void poista(FiboSolmu solmu) throws Exception {
        if (koko == 0) {
            throw new Exception("Keko on tyhjä!");
        }
        muutaArvoa(solmu, Integer.MIN_VALUE);
        poistaMinimi();
    }

    /**
     * Poistaa minimisolmun keosta:
     * Minimin lapset lisätään yksitellen juurilistaan. Minimi poistetaan 
     * juurilistasta ja kutsutaan yhdista()-metodia yhdistämään samanasteiset 
     * (aste = lapsisolmujen lkm) juuret.
     */
    public void poistaMinimi() throws Exception {
        if (koko == 0) {
            throw new Exception("Keko on tyhjä!");
        }

        FiboSolmu z = minimi;

        if (z != null) {

            int lastenLkm = z.aste;

            if (lastenLkm != 0) {
                FiboSolmu x = z.lapsi.oikea;
                FiboSolmu apu;

                while (lastenLkm > 0) {

                    apu = x.oikea;

                    // poistetaan lapsisolmu 

                    x.vasen.oikea = x.oikea;
                    x.oikea.vasen = x.vasen;

                    // lisätään lapsisolmu juurilistaan

                    x.oikea = minimi;
                    x.vasen = minimi.vasen;
                    minimi.vasen = x;
                    x.vasen.oikea = x;

                    x.vanhempi = null;
                    x = apu;
                    lastenLkm--;
                }
            }

            //poistetaan minimi juurilistasta

            z.vasen.oikea = z.oikea;
            z.oikea.vasen = z.vasen;

            if (z == z.oikea) {
                minimi = null;
            } else {
                // uusi minimi otetaan poistettavan oikealta puolelta

                minimi = z.oikea;
                yhdista();
            }

            koko--;
        }
    }

    /**
     * Tekee solmusta x solmun y lapsen. 
     * 
     * @param x solmu
     * @param y solmu
     */
    public void link(FiboSolmu y, FiboSolmu x) {

        // poistetaan y juurilistasta

        y.vasen.oikea = y.oikea;
        y.oikea.vasen = y.vasen;

        // tehdään y:stä x:n lapsi
        
        y.vanhempi = x;

        if (x.lapsi == null) {
            x.lapsi = y;
            y.oikea = y;
            y.vasen = y;
        } else {
            y.vasen = x.lapsi;
            y.oikea = x.lapsi.oikea;
            x.lapsi.oikea = y;
            y.oikea.vasen = y;
        }
        
        x.aste++;
        y.merkitty = false;
    }

    /**
     * Yhdistää samanastesia (sama määrä lapsia) juurisolmuja, jotta juurilistan 
     * kaikki juurisolmut olisivat eriasteisia.
     */
    public void yhdista() {
        int taulukonKoko = this.koko;
        FiboSolmu array[] = new FiboSolmu[taulukonKoko];
        for (int i = 0; i < taulukonKoko; i++) {
            array[i] = null;
        }

        // lasketaan juurilistan solmut
        
        int numRoots = 0;
        FiboSolmu x = minimi;

        if (x != null) {
            numRoots++;
            x = x.oikea;

            while (x != minimi) {
                numRoots++;
                x = x.oikea;
            }
        }
        
        // sijoitetaan solmuja taulukkoon asteiden mukaan 

        while (numRoots > 0) {
            int d = x.aste;
            FiboSolmu seur = x.oikea;
            
            while (array[d] != null) {
                FiboSolmu y = array[d];
                if (x.avain > y.avain) {
                    FiboSolmu temp = y;
                    y = x;
                    x = temp;
                }

                // linkitetään samanasteiset solmut
                
                link(y, x);

                array[d] = null;
                d++;
            }
            
            array[d] = x;
            x = seur;
            numRoots--;
        }

        // rakennetaan juurilista uudestaan taulukon avulla
        
        minimi = null;
        
        for (int i = 0; i < taulukonKoko; i++) {
            FiboSolmu y = array[i];
            
            if (y != null) {
                if (minimi != null) {

                    // poistetaan solmu juurilistasta

                    y.vasen.oikea = y.oikea;
                    y.oikea.vasen = y.vasen;

                    // lisätään solmu uudestaan juurilistaan 

                    y.oikea = minimi;
                    y.vasen = minimi.vasen;
                    minimi.vasen = y;
                    y.vasen.oikea = y;

                    if (y.avain < minimi.avain) {
                        minimi = y;
                    }
                } else {
                    minimi = y;
                }
            }
        }
    }

    /**
     * Muuttaa solmun avaimen arvoa:
     * Muutetetaan halutun solmun arvo pienemmäksi kuin nykyinen arvo.
     * Tämän jälkeen tehdään mahdolliset korjausoperaatiot.
     * 
     * @param solmu 
     * @param uusiAvain 
     * 
     */
    public void muutaArvoa(FiboSolmu x, int uusiAvain) throws Exception {
        if (koko == 0) {
            throw new Exception("Keko on tyhjä!");
        }

        if (uusiAvain > x.getAvain()) {
            throw new Exception("Uusi avain suurempi kuin nykyinen!");
        }
        
        x.avain = uusiAvain;
        FiboSolmu y = x.vanhempi;
        
        if (y != null && x.avain < y.avain) {
            cut(x, y);
            cascadeCut(y);
        }
        
        if (x.avain < minimi.avain) {
            minimi = x;
        }
    }

    /**
     * Poistaa solmun vanhemmastaan ja lisää sen juurilistaan.
     * 
     * @param x, y 
     */
    private void cut(FiboSolmu x, FiboSolmu y) {

        //poistetaan solmu lapsilistasta
        
        x.vasen.oikea = x.oikea;
        x.oikea.vasen = x.vasen;
        y.lapsi = x.vasen;

        y.aste--;

        if (y.aste == 0) {
            y.lapsi = null;
        }

        //lisätään juurilistaan

        x.oikea = minimi;
        x.vasen = minimi.vasen;
        minimi.vasen = x;
        x.vasen.oikea = x;

        x.vanhempi = null;
        x.merkitty = false;
    }

    /**
     * Poistaa solmun vanhemmastaan juurilistaan asti tai jos se löytää
     * merkitsettömän solmun.
     * 
     * @param solmu
     */
    private void cascadeCut(FiboSolmu y) {
        FiboSolmu z = y.vanhempi;
        
        if (z != null) {
            if (y.merkitty == false) {
                y.merkitty = true;
            } else {
                cut(y, z);
                cascadeCut(z);
            }
        }
    }

    /**
     * Tulostaa juurilistan tai lapsilistan solmut.
     * Ottaa parametriksi solmun, josta lähtien kaikki seuraavat solmut
     * käydään läpi. Palauttaa String esityksen solmuista.
     * 
     * @param t
     * @return 
     */
    public String tulostaLista(FiboSolmu t) {
        FiboSolmu apu = t;
        String s = "";
        t = t.oikea;
        while (t != apu) {
            s = s + t.avain + " ";
            t = t.oikea;
        }
        s = s + apu.avain;
        return s;
    }
//
    public static void main(String[] args) throws Exception {
        Fibonaccikeko fkeko = new Fibonaccikeko();
//        int operaatioita = 1000000;
//         for (int i = 0; i < operaatioita; i++) {
//            fkeko.lisaa((int) (operaatioita * Math.random() + 1));
//        }
//        long alku = System.currentTimeMillis();
//        for (int i = 0; i < 1000; i++) {
//            fkeko.poistaMinimi();
//        }
//        long loppu = System.currentTimeMillis();
//        long aika = loppu - alku;
//        
//         FiboSolmu s = fkeko.returnMin().oikea;
//         int laskuri = 0;
//         while (s != fkeko.returnMin()) {
//             ++laskuri;
//             s = s.oikea;
//         }
//         ++laskuri;
//         System.out.println("aika "+aika+" juurisolmut "+laskuri+" koko "+fkeko.getKoko());
//        int operaatioita = 100;
//        int arvo = ((int) ((3*operaatioita) * Math.random() + 2*operaatioita+1));
//        System.out.println(arvo);
//        double rajaus = operaatioita-(operaatioita*0.95);
//        int uusiarvo = ((int) ((rajaus) * Math.random() + 2*operaatioita));
//        System.out.println(uusiarvo);
        
        fkeko = new Fibonaccikeko();
        int operaatioita = 1000000;
        for (int i = 0; i < operaatioita; i++) {
            fkeko.lisaa((int) ((2*operaatioita) * Math.random() + operaatioita+1));
        }

        double ala = 3*operaatioita-(3*(operaatioita*0.0001));
        System.out.println("ala "+ala);
        double yla = operaatioita*3;
        System.out.println("ylä "+yla);
        for (int i = 0; i < operaatioita; i++) {
            int arvo = ((int) ((yla-ala) * Math.random() + ala));
            System.out.println("arvo "+arvo);
            fkeko.muutaArvoa(fkeko.returnMin(), arvo);
            yla = ala;
//            System.out.println("ylä "+yla);
            ala = ala - yla * 0.0001;
//            System.out.println("ala "+ala);
        }
        
//        fkeko.lisaa(4);
//        fkeko.lisaa(8);
//        fkeko.lisaa(7);
//        fkeko.lisaa(2);
//        fkeko.lisaa(3);
//        fkeko.poistaMinimi();
//        fkeko.lisaa(12);
//        fkeko.lisaa(14);
//        fkeko.poistaMinimi();
//        fkeko.lisaa(17);
//        fkeko.lisaa(19);
//        fkeko.poistaMinimi();
//        fkeko.lisaa(9);
//        fkeko.lisaa(5);
//        fkeko.poistaMinimi();
//        fkeko.lisaa(11);
//        fkeko.poistaMinimi();
//        System.out.println(fkeko.tulostaLista(fkeko.returnMin()));
//        System.out.println(fkeko.returnMin());
    }
}