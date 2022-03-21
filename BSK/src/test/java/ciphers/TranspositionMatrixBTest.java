/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author xxx
 */
public class TranspositionMatrixBTest {
    
    public TranspositionMatrixBTest() {
    }
    
 @Test
    public void testEncode() {
        String result = TranspositionMatrixB.encode("DALMATYNCZYK", "CONVENIENCE");
         assertEquals(result,"DKZANYYLTCAM");
    }

    @Test
    public void testDecode() {
        String result = TranspositionMatrixB.decode("DKZANYYLTCAM", "CONVENIENCE");
         assertEquals(result,"DALMATYNCZYK");
    }
    
        @Test
    public void testMatrixB() {
        String plainText = "THEGLOVESPROTECTMYFEETFROMEXCESSWORK";
        String testCipherText = TranspositionMatrixB.encode(plainText,"CONVENIENCE");
        String testPlainText = TranspositionMatrixB.decode(testCipherText, "CONVENIENCE");
            assertEquals(plainText,testPlainText);
    }
    
        @Test
    public void testEncode1() {
        String result = TranspositionMatrixB.encode("LABRADOR", "CONVENIENCE");
            assertEquals(result,"LAROBDAR");
    }

    @Test
    public void testDecode1() {
        String result = TranspositionMatrixB.decode("LAROBDAR", "CONVENIENCE");
        assertEquals(result,"LABRADOR");
    }
    
        @Test
    public void testEncode2() {
        String result = TranspositionMatrixB.encode("OWCZAREKNIEMIECKI", "CONVENIENCE");
         assertEquals(result,"OMIAKKEECERINWIZC");
    }

    @Test
    public void testDecode2() {
        String result = TranspositionMatrixB.decode("OMIAKKEECERINWIZC", "CONVENIENCE");
         assertEquals(result,"OWCZAREKNIEMIECKI");
    }
    
}
