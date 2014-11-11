/*
 * Binäärikeon testaus
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaarikekoTest {
    
    Binaarikeko bkeko;
    
    public BinaarikekoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    //alustetaan 100 alkion kokoiseksi
    
    @Before
    public void setUp() {
        bkeko = new Binaarikeko(100);
    }
    
    @After
    public void tearDown() {
        
    }
    
    /**
     * Testaa pystyykö tyhjästä keosta poistaa minimiä.
     * 
     * @throws Exception 
     */    
    @Test
    public void testTyhjaKeko() throws Exception {
        bkeko = new Binaarikeko(0);
        try { 
            bkeko.poistaMinimi();
            fail("Ei tullut poikkeusta!");
        } catch(Exception e) {            
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
            bkeko.poista(0);
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
            bkeko.muutaArvoa(0, 1);
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
            bkeko.lisaa(-5);
            fail("Ei tullut poikkeusta!");
        } catch (Exception e) {
        }
    }
    
    /**
     * Lisätään yksi alkio ja poistetaan se.
     */
    @Test
    public void testLisaaJaPoista() throws Exception {
        bkeko.lisaa(4);
        bkeko.poista(0);
        assertEquals(0, bkeko.getKoko());
        assertEquals("", bkeko.toString());
    }
    
    /**
     * Lisätään yksi alkio ja poistetaan minimi.
     */
    @Test
    public void testLisaaJaPoistaMinimi() throws Exception {
        bkeko.lisaa(4);
        bkeko.poistaMinimi();
        assertEquals(0, bkeko.getKoko());
        assertEquals("", bkeko.toString());
    }
    
    /**
     * Lisätään yksi alkio ja muutetaan arvoa.
     */
    @Test
    public void testLisaaJaMuuta() throws Exception {
        bkeko.lisaa(4);
        bkeko.muutaArvoa(0, 8);
        assertEquals(1, bkeko.getKoko());
        assertEquals("8 ", bkeko.toString());
    }
    
    /**
     * Lisätään kaksi alkiota ja poistetaan minimi.
     */
    @Test
    public void testLisaaJaPoistaMinimi2() throws Exception {
        bkeko.lisaa(4);
        bkeko.lisaa(1);
        bkeko.poistaMinimi();
        assertEquals(1, bkeko.getKoko());
        assertEquals("4 ", bkeko.toString());
    }

    /**
     * Testataan rakentuuko keko oikein, kun sinne lisätään alkioita.
     */
    @Test
    public void testLisaa() throws Exception {
        bkeko.lisaa(14);
        bkeko.lisaa(12);
        bkeko.lisaa(1);
        bkeko.lisaa(8);
        bkeko.lisaa(7);
        bkeko.lisaa(2);
        bkeko.lisaa(3);
        assertEquals("1 7 2 14 8 12 3 ", bkeko.toString());
    }
    
    /**
     * Testataan rakentuuko keko oikein, kun sinne lisätään alkioita.
     */
    @Test
    public void testLisaa2() throws Exception {
        bkeko.lisaa(14);
        bkeko.lisaa(12);
        bkeko.lisaa(9);
        bkeko.lisaa(10);
        bkeko.lisaa(8);
        bkeko.lisaa(7);
        bkeko.lisaa(5);
        bkeko.lisaa(2);
        bkeko.lisaa(3);
        bkeko.lisaa(11);
        bkeko.lisaa(1);
        assertEquals("1 2 7 5 3 12 8 14 9 11 10 ", bkeko.toString());
    }

    /**
     * Testataan poistetaanko haluttu alkio oikein.
     */
    @Test
    public void testPoista() throws Exception {
        bkeko.lisaa(14);
        bkeko.lisaa(12);
        bkeko.lisaa(1);
        bkeko.lisaa(8);
        bkeko.lisaa(7);
        bkeko.lisaa(2);
        bkeko.lisaa(3);
        bkeko.poista(3); //poistetaan indeksissä 3 oleva alkio 14
        assertEquals("1 3 2 7 8 12 ", bkeko.toString());
    }
    
    /**
     * Testataan poistetaanko haluttu alkio oikein.
     */
    @Test
    public void testPoista2() throws Exception {
        bkeko.lisaa(14);
        bkeko.lisaa(12);
        bkeko.lisaa(1);
        bkeko.lisaa(8);
        bkeko.lisaa(7);
        bkeko.lisaa(2);
        bkeko.lisaa(3);
        bkeko.poista(2); //poistetaan indeksissä 2 oleva alkio 2
        assertEquals("1 7 3 14 8 12 ", bkeko.toString());
    }
    
    /**
     * Yritetään poistaa olematonta alkiota.
     */
    @Test
    public void testPoista3() throws Exception {
        bkeko.lisaa(14);
        bkeko.lisaa(12);
        bkeko.lisaa(1);
        bkeko.lisaa(8);
        bkeko.lisaa(7);
        bkeko.lisaa(2);
        bkeko.lisaa(3);
        try { 
            bkeko.poista(7);
            fail("Ei tullut poikkeusta!");
        } catch(Exception e) {            
        }
    }

    /**
     * Testataan poistetaanko minimi oikein.
     */
    @Test
    public void testPoistaMinimi() throws Exception {
        bkeko.lisaa(14);
        bkeko.lisaa(12);
        bkeko.lisaa(1);
        bkeko.lisaa(8);
        bkeko.lisaa(7);
        bkeko.lisaa(2);
        bkeko.lisaa(3);
        bkeko.poistaMinimi();
        assertEquals("2 7 3 14 8 12 ", bkeko.toString());
    }

    /**
     * Testataan korjaantuuko kekoehto sen jälkeen kun minimin arvo on muutettu.
     */
    @Test
    public void testMuutaArvoa() throws Exception {
        bkeko.lisaa(14);
        bkeko.lisaa(12);
        bkeko.lisaa(1);
        bkeko.lisaa(8);
        bkeko.lisaa(7);
        bkeko.lisaa(2);
        bkeko.lisaa(3);
        bkeko.muutaArvoa(0, 100);
        assertEquals("2 7 3 14 8 12 100 ", bkeko.toString());      
    }
    
    /**
     * Testataan korjaantuuko kekoehto, kun muutetaan alkion arvoa.
     */
    @Test
    public void testMuutaArvoa2() throws Exception {
        bkeko.lisaa(14);
        bkeko.lisaa(12);
        bkeko.lisaa(1);
        bkeko.lisaa(8);
        bkeko.lisaa(7);
        bkeko.lisaa(2);
        bkeko.lisaa(3);
        bkeko.muutaArvoa(5, -1);
        assertEquals("-1 7 1 14 8 2 3 ", bkeko.toString());      
    }
    
    /**
     * Testataan löytyykö poikkeus, kun yritetään muuttaa alkiota jota ei ole 
     * keossa.
     */
    @Test
    public void testMuutaArvoa3() throws Exception {
        bkeko.lisaa(14);
        bkeko.lisaa(12);
        bkeko.lisaa(1);
        bkeko.lisaa(8);
        bkeko.lisaa(7);
        bkeko.lisaa(2);
        bkeko.lisaa(3);
        try { 
            bkeko.muutaArvoa(8, -1);
            fail("Ei tullut poikkeusta!");
        } catch(Exception e) {            
        }     
    }

    /**
     * Testataan korjaantuuko kekoehto, kun muutetaan alkion arvoa.
     */
    @Test
    public void testMuutaArvoa4() throws Exception {
        bkeko.lisaa(14);
        bkeko.lisaa(12);
        bkeko.lisaa(1);
        bkeko.lisaa(8);
        bkeko.lisaa(7);
        bkeko.lisaa(2);
        bkeko.lisaa(3);
        bkeko.muutaArvoa(1, 0); //indeksissä 1 oleva alkio muutetaan 0:ksi
        assertEquals("0 1 2 14 8 12 3 ", bkeko.toString()); 
        assertEquals(7 , bkeko.getKoko()); 
    }
}
