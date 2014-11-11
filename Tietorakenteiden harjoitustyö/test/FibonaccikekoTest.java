
/**
 * @author Hanna Hirvonen
 * 
 * Fibonacci-keko tietorakenteen testaus.
 * 
 * Testataan yksinkertaisilla koeasetelmilla ja monilla eri 
 * operaatioiden yhdistelmillä.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonaccikekoTest {

    Fibonaccikeko fkeko;

    public FibonaccikekoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        fkeko = new Fibonaccikeko();
    }

    @After
    public void tearDown() {
    }

    /**
     * Testataan minimin poistamista tyhjästä keosta.
     * 
     * @throws Exception 
     */
    @Test
    public void testTyhjaKeko() throws Exception {
        try {
            fkeko.poistaMinimi();
            fail("Ei tullut poikkeusta!");
        } catch (Exception e) {
        }
    }
    
    /**
     * Testataan poistamista tyhjästä keosta.
     * 
     * @throws Exception 
     */
    @Test
    public void testPoistaTyhjastaKeosta() throws Exception {
        try {
            fkeko.poista(fkeko.returnMin());
            fail("Ei tullut poikkeusta!");
        } catch (Exception e) {
        }
    }

    /**
     * Testataan arvon muuttamista tyhjästä keosta.
     * 
     * @throws Exception 
     */
    @Test
    public void testMuutaArvoaTyhjastaKeosta() throws Exception {
        try {
            fkeko.muutaArvoa(fkeko.returnMin(), 1);
            fail("Ei tullut poikkeusta!");
        } catch (Exception e) {
        }
    }
    
    /**
     * Testataan negatiivisen arvon lisäystä kekoon.
     * 
     * @throws Exception
     */
    @Test
    public void testNegatiivinenLisays() throws Exception {
        try {
            fkeko.lisaa(-5);
            fail("Ei tullut poikkeusta!");
        } catch (Exception e) {
        }
    }

    /**
     * Lisätään yksi alkio ja poistetaan se. 
     * Testataan onko keko poiston jälkeen tyhjä.
     */
    @Test
    public void testLisaaJaPoista() throws Exception {
        fkeko.lisaa(4);
        fkeko.poista(fkeko.returnMin());
        assertEquals(0, fkeko.getKoko());
    }

    /**
     * Lisätään yksi alkio ja muutetaan sen arvoa.
     * Testataan palauttaako keko juurilistan oikein.
     */
    @Test
    public void testLisaaJaMuuta() throws Exception {
        fkeko.lisaa(4);
        fkeko.muutaArvoa(fkeko.returnMin(), 1);
        assertEquals(1, fkeko.getKoko());
        assertEquals("1", fkeko.tulostaLista(fkeko.returnMin()));
    }
    
    /**
     * Lisätään alkioita ja muutetaan yhden alkion arvoa.
     * Testataan palauttaako keko juurilistan oikein.
     */
    @Test
    public void testLisaaJaMuuta2() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.muutaArvoa(fkeko.returnMin(), 1);
        assertEquals("4 8 7 3 1", fkeko.tulostaLista(fkeko.returnMin()));
    }
    
    /**
     * Lisätään alkioita, poistetaan minimi ja muutetaan yhden alkion arvoa.
     * Testataan palauttaako keko juurilistan oikein.
     */
    @Test
    public void testLisaaJaMuuta3() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        fkeko.muutaArvoa(fkeko.returnMin().lapsi, 1);
        assertEquals("3 1", fkeko.tulostaLista(fkeko.returnMin()));
    }

    /**
     * Lisätään yksi alkio ja poistetaan minimi.
     * Testataan onko keko tyhjä minimin poistamisen jälkeen.
     */
    @Test
    public void testLisaaJaPoistaMinimi1() throws Exception {
        fkeko.lisaa(4);
        fkeko.poistaMinimi();
        assertEquals(0, fkeko.getKoko());
    }

    /**
     * Lisätään kaksi alkiota ja poistetaan minimi.
     * Testataan palauttaako keko juurilistan oikein.
     */
    @Test
    public void testLisaaJaPoistaMinimi2() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(1);
        fkeko.poistaMinimi();
        assertEquals(1, fkeko.getKoko());
        assertEquals("4", fkeko.tulostaLista(fkeko.returnMin()));
    }

    /**
     * Lisätään alkioita.
     * Testataan palauttaako keko juurilistan oikein.
     */
    @Test
    public void testLisaa() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        assertEquals(5, fkeko.getKoko());
        assertEquals("4 8 7 3 2", fkeko.tulostaLista(fkeko.returnMin()));
    }

    /**
     * Lisätään alkioita.
     * Testataan palauttaako keko oikean minimin.
     */
    @Test
    public void testReturnMin() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        assertEquals(2, fkeko.returnMin().avain);
    }

    /**
     * Poistetaan minimi. 
     * Testataan palauttaako keko juurilistan oikein.
     */
    @Test
    public void testPoista() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poista(fkeko.returnMin());
        assertEquals(3, fkeko.returnMin().avain);
    }

    /**
     * Poistetaan minimin oikea lapsi (lapsi viittaa aina oikean puolen lapseen). 
     * Testataan palauttaako keko oikean lapsilistan. 
     * 
     * @throws Exception 
     */
    @Test
    public void testPoistaAlkio() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        fkeko.poista(fkeko.returnMin().lapsi);
        assertEquals(4, fkeko.returnMin().lapsi.avain);
        assertEquals("4", fkeko.tulostaLista(fkeko.returnMin().lapsi));
    }

    /** 
     * Lisätään ja poistetaan alkioita.
     * Testataan palauttaako keko juurilistan oikein. 
     * 
     * @throws Exception 
     */
    @Test
    public void testPoistaAlkio2() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        fkeko.poista(fkeko.returnMin().lapsi);
        fkeko.poista(fkeko.returnMin().lapsi);
        assertEquals(3, fkeko.returnMin().avain);
        assertEquals("8", fkeko.tulostaLista(fkeko.returnMin().lapsi));
    }

    /**
     * Testataan lisää, poista ja poistaMinimin yhdistelmää.
     * Testataan palauttaako keko juurilistan oikein.
     * 
     * @throws Exception 
     */
    @Test
    public void testPoistaAlkio3() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        fkeko.poista(fkeko.returnMin().lapsi);
        fkeko.poista(fkeko.returnMin().lapsi);
        fkeko.lisaa(6);
        fkeko.lisaa(5);
        fkeko.lisaa(11);
        fkeko.poistaMinimi();
        assertEquals(6, fkeko.returnMin().lapsi.avain);
        assertEquals("5", fkeko.tulostaLista(fkeko.returnMin()));
        assertEquals(2, fkeko.returnMin().aste);
    }

    /**
     * Testataan päivittyykö minimi poistaMinimin yhteydessä.
     */
    @Test
    public void testPoistaMinimi() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        assertEquals(3, fkeko.returnMin().avain);
    }

    /**
     * Testataan päivittyykö juurilista oikein poistaMinimin yhteydessä.
     */
    @Test
    public void testPoistaMinimi2() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        assertEquals("3", fkeko.tulostaLista(fkeko.returnMin()));
    }

    /**
     * Testataan lisää, poista ja poistaMinimin yhdistelmää.
     * Testataan palauttaako keko juurilistan oikein.
     * 
     * @throws Exception 
     */
    @Test
    public void testLisaaJaPoistaMinimi3() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        fkeko.lisaa(12);
        fkeko.lisaa(14);
        fkeko.poistaMinimi();
        fkeko.lisaa(17);
        fkeko.lisaa(19);
        fkeko.poistaMinimi();
        fkeko.lisaa(9);
        fkeko.lisaa(5);
        fkeko.poistaMinimi();
        fkeko.lisaa(11);
        fkeko.poistaMinimi();
        fkeko.lisaa(12);
        fkeko.lisaa(14);
        fkeko.poistaMinimi();
        assertEquals("9", fkeko.tulostaLista(fkeko.returnMin()));
        assertEquals(3, fkeko.returnMin().aste);
    }

    /**
     * Testataan lisää ja poistaMinimin yhdistelmää.
     * Testataan palauttaako keko juurilistan oikein.
     * 
     * @throws Exception 
     */
    @Test
    public void testLisaaJaPoistaMinimi4() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        fkeko.lisaa(12);
        fkeko.lisaa(14);
        fkeko.poistaMinimi();
        fkeko.lisaa(17);
        fkeko.lisaa(19);
        fkeko.poistaMinimi();
        fkeko.lisaa(9);
        fkeko.lisaa(5);
        fkeko.poistaMinimi();
        fkeko.lisaa(11);
        fkeko.poistaMinimi();
        assertEquals("12 17 8", fkeko.tulostaLista(fkeko.returnMin()));
        assertEquals(2, fkeko.returnMin().aste);
    }

    /**
     * Testataan lisää, muuta ja poistaMinimin yhdistelmää.
     * Testataan palauttaako keko juurilistan oikein.
     * 
     * @throws Exception 
     */
    @Test
    public void testMuutaArvoa() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        fkeko.muutaArvoa(fkeko.returnMin().lapsi, 1);
        assertEquals("3 1", fkeko.tulostaLista(fkeko.returnMin()));
        assertEquals(0, fkeko.returnMin().aste);
    }

    /**
     * Testataan lisää, muuta ja poistaMinimin yhdistelmää.
     * Testataan palauttaako keko juurilistan oikein. 
     * 
     * @throws Exception 
     */
    @Test
    public void testMuutaArvoa2() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        fkeko.lisaa(12);
        fkeko.lisaa(14);
        fkeko.poistaMinimi();
        fkeko.muutaArvoa(fkeko.returnMin().lapsi, 2);
        assertEquals("4 7 2", fkeko.tulostaLista(fkeko.returnMin()));
        assertEquals(0, fkeko.returnMin().aste);
    }

    /**
     * Testataan lisää, muuta ja poistaMinimin yhdistelmää.
     * Testataan palauttaako keko juurilistan oikein.
     * 
     * @throws Exception 
     */
    @Test
    public void testMuutaArvoa3() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        fkeko.lisaa(12);
        fkeko.lisaa(14);
        fkeko.poistaMinimi();
        fkeko.lisaa(17);
        fkeko.lisaa(19);
        fkeko.poistaMinimi();
        fkeko.lisaa(9);
        fkeko.lisaa(5);
        fkeko.poistaMinimi();
        fkeko.lisaa(11);
        fkeko.poistaMinimi();
        fkeko.muutaArvoa(fkeko.returnMin().lapsi, 2);
        assertEquals("8 12 17 2", fkeko.tulostaLista(fkeko.returnMin()));
        assertEquals(0, fkeko.returnMin().aste);
    }

    /**
     * Testataan lisää, muuta ja poistaMinimin yhdistelmää.
     * Testataan palauttaako keko juurilistan oikein. 
     * 
     * @throws Exception 
     */
    @Test
    public void testMuutaArvoa4() throws Exception {
        fkeko.lisaa(4);
        fkeko.lisaa(8);
        fkeko.lisaa(7);
        fkeko.lisaa(2);
        fkeko.lisaa(3);
        fkeko.poistaMinimi();
        fkeko.lisaa(12);
        fkeko.lisaa(14);
        fkeko.poistaMinimi();
        fkeko.lisaa(17);
        fkeko.lisaa(19);
        fkeko.poistaMinimi();
        fkeko.lisaa(9);
        fkeko.lisaa(5);
        fkeko.poistaMinimi();
        fkeko.lisaa(11);
        fkeko.poistaMinimi();
        fkeko.muutaArvoa(fkeko.returnMin().lapsi, 2);
        fkeko.muutaArvoa(fkeko.returnMin().oikea.lapsi.lapsi, 1);
        assertEquals("2 8 12 17 1", fkeko.tulostaLista(fkeko.returnMin()));
        assertEquals(0, fkeko.returnMin().aste);
    }
}
