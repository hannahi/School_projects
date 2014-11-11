/**
 * @author Hanna Hirvonen
 * 
 * Binäärikeko tietorakenne, jossa operaatiot lisää, poista, poista minimi
 * sekä muuta arvoa.
 * 
 */
public class Binaarikeko {

    private int[] keko;
    private int maxKoko;
    private int koko;
    private int pienin;

    /**
     * Konstruktori luo minimikeon.
     * Koko annetaan parametrina. 
     * 
     * @param maxKoko pitää muistissa keon maksimi kokoa
     * @param koko pitää kirjaa keon senhetkisestä koosta
     */
    public Binaarikeko(int koko) {
        keko = new int[koko];
        this.maxKoko = koko;
        this.koko = 0;
    }

    /**
     * Paluttaa keon koon (solmujen määrän).
     * 
     * @return koko 
     */
    public int getKoko() {
        return this.koko;
    }

    /**
     * Palauttaa keon pienimmän alkion siis keon juurisolmun.
     * 
     * @return keko[0]
     */
    public int getMinimi() {
        return keko[0];
    }

    /**
     * Palauttaa indeksinä annetun solmun vanhemman indeksin.
     * 
     * @return Integer
     */
    public int vanhempi(int indeksi) {
        if (indeksi == 0) {
            return 0;
        }
        return (indeksi - 1) / 2;
    }

    /**
     * Palauttaa vasemman lapsen indeksin. 
     * 
     * @return Integer
     */
    public int vasenLapsi(int indeksi) {
        return 2 * indeksi + 1;
    }

    /**
     * Palauttaa oikean laspsen indeksin. 
     * 
     * @return Integer
     */
    public int oikeaLapsi(int indeksi) {
        return 2 * indeksi + 2;
    }

    /**
     * Lisätään kekoon alkio. 
     * Keko ottaa parametrikseen vain positiivisia arvoja.
     * 
     * @param alkio
     */
    public void lisaa(int alkio) throws Exception {
        if (alkio < 0) {
            throw new Exception("Arvo negatiivinen!");
        }
        
        if (koko >= maxKoko) {
            return;
        }
        
        keko[koko] = alkio;
        int j = koko++;
        
        while (j > 0 && keko[vanhempi(j)] > alkio) {
            keko[j] = keko[vanhempi(j)];
            j = vanhempi(j);
        }
        
        keko[j] = alkio;
    }

    /**
     * Poistetaan indeksin osoittamasta paikasta alkio. 
     * Poistettava alkio ja keon viimeinen alkio vaihtavat paikkaa.
     * Lopuksi kekoa pienennetään yhdellä.
     * 
     * @param indeksi
     */
    public void poista(int indeksi) throws Exception {  
        if (koko == 0) {
            throw new Exception("Keko on tyhjä!");
        }
        
        if (indeksi > koko-1) {
            throw new Exception("Väärä indeksi! Ei ole keossa!");
        }
        
        keko[indeksi] = keko[koko-1];
        keko[koko-1] = keko[indeksi];
        koko--;
        heapify(indeksi);
    }

    /**
     * Poistetaan minimi keosta. Minimi ja keon viimeinen alkio vaihtavat 
     * paikkaa. Kokoa pienennetään yhdellä ja kutsutaan heapify-operaatiota 
     * korjaamaan kekoehto.
     */
    public void poistaMinimi() throws Exception {
        if (koko == 0) {
            throw new Exception("Keko on tyhjä!");
        }
        
        keko[0] = keko[koko - 1];
        koko--;
        heapify(0);
    }
    
    /**
     * Muuttaa indeksissä i olevaa arvoa. Lopuksi kutsutaan heapify() 
     * korjaamaan kekoehto.
     * 
     * @param i
     * @param k 
     */
    public void muutaArvoa(int i, int k) throws Exception {
        if (koko == 0) {
            throw new Exception("Keko on tyhjä!");
        }
        
        if (i > koko-1) {
            throw new Exception("Indeksi menee yli keon koon!") ;
        }
        
        keko[i] = k;
        
        heapify(i);   
    }
    
    /**
     * Jos indeksissä i olevalla alkiolla on vanhempi sitä viedään ylöspäin 
     * keossa muuten alkiota viedään alaspäin (kutsutaan heapifyDown).
     * 
     * @param i 
     */ 
    private void heapify(int i) {      
        if (keko[vanhempi(i)] > keko[i]) {

            while (keko[vanhempi(i)] > keko[i]) {
                int apu = keko[i];
                keko[i] = keko[vanhempi(i)];
                keko[vanhempi(i)] = apu;
                i = vanhempi(i);
                
                if (i == 0) {
                    break;
                }
            }
        }
        
        heapifyDown(i);    
    }
    
    /**
     * Korjataan kekoehto ylhäältä alaspäin.
     * 
     * @param i
     */
    private void heapifyDown(int i) { 
        
        int vasen = vasenLapsi(i);
        int oikea = oikeaLapsi(i);
 
        if (vasen < koko && keko[vasen] < keko[i]) {
            pienin = vasen;
        } else {
            pienin = i;
        }
        
        if (oikea < koko && keko[oikea] < keko[pienin]) {
            pienin = oikea;
        }
        
        if (pienin != i) {
            int apu2 = keko[i];
            keko[i] = keko[pienin];
            keko[pienin] = apu2;
            heapifyDown(pienin);
        }
    }

    /** 
     * Palauttaa String esityksen keosta.
     * 
     * @return tuloste
     */
    @Override
    public String toString() {
        String tuloste = "";
        for (int i = 0; i < koko; i++) {
            tuloste += keko[i] + " ";
        }
        return tuloste;
    }

//    public static void main(String[] args) throws Exception {
//        Binaarikeko testi = new Binaarikeko(20);
//        testi.lisaa(14);
//        testi.lisaa(12);
//        testi.lisaa(1);
//        testi.lisaa(8);
//        testi.lisaa(7);
//        testi.lisaa(2);
//        testi.lisaa(3);
//        System.out.println(testi.toString());
//        testi.muutaArvoa(1, 0);
//        System.out.println(testi.toString());
//    }
}
