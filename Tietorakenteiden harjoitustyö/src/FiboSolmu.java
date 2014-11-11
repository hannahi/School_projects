
/**
 *
 * @author hanna
 * Luokka fibonaccikeon solmuille.
 * 
 * Viitteet seuraavaan ja edelliseen solmuun.
 * Viitteet lapseen ja vanhempaan.
 * 
 * Integer aste kertoo lasten lukumäärän. 
 * Boolean merkitty true jos solmun lapsi oli poistettu sen jälkeen kun solmu
 * itse oli lisätty vanhempaan.
 * Integer avain on solmuun liitetty arvo.
 */
public class FiboSolmu {

    FiboSolmu oikea, vasen;
    FiboSolmu lapsi, vanhempi;
    int aste;
    boolean merkitty;
    int avain;

    /**
     * Konstruktori. Solmun parametrit alustetaan. 
     * Viittaukset edelliseen ja seuraavaan solmuun.
     * 
     * @param avain liitetään solmuun
     */
    FiboSolmu(int avain) {
        this.avain = avain;
        oikea = vasen = null;
        aste = 0;
        lapsi = vanhempi = null;
        merkitty = false;
    }
    
    /**
     * Palauttaa solmun avaimen.
     * 
     * @return avain
     */
    public int getAvain() {
        return avain;
    }

    /**
     * String-esitys solmulle. Paluttaa tiedot solmusta: vanhempi, lapsi, oikea,
     * vasen ja aste.
     * 
     * @return String
     */
    @Override
    public String toString() {

        StringBuilder b = new StringBuilder();
        
        b.append("[avain = ");
        b.append(Integer.toString(avain));

        b.append(", vanhempi = ");       
        if (vanhempi != null) {
            b.append(Integer.toString(vanhempi.avain));
        } else {
            b.append("---");
        }
        
        b.append(", aste = ");
        b.append(Integer.toString(aste));
        
        b.append(", oikea = ");
        if (oikea != null) {
            b.append(Integer.toString(oikea.avain));
        } else {
            b.append("---");
        }

        b.append(", vasen = ");
        if (vasen != null) {
            b.append(Integer.toString(vasen.avain));
        } else {
            b.append("---");
        }

        b.append(", lapsi = ");
        if (lapsi != null) {
            b.append(Integer.toString(lapsi.avain));
        } else {
            b.append("---");
        }

        b.append(']');

        return b.toString();
    }
}