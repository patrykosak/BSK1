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
public class TranspositionMatrixATest {
    
    public TranspositionMatrixATest() {
    }
    
    @Test
    public void testEncode() {
        String result = TranspositionMatrixA.encode("DALMATYNCZYK");
         assertEquals(result,"LMDAANCTZYYK");
    }

    @Test
    public void testDecode() {
        String result = TranspositionMatrixA.decode("LMDAANCTZYYK");
         assertEquals(result,"DALMATYNCZYK");
    }
    
        @Test
    public void testMatrixA() {
        String plainText = "THEGLOVESPROTECTMYFEETFROMEXCESSWORK";
        String testCipherText = TranspositionMatrixA.encode(plainText);
        String testPlainText = TranspositionMatrixA.decode(testCipherText);
            assertEquals(plainText,testPlainText);
    }
    
        @Test
    public void testEncode1() {
        String result = TranspositionMatrixA.encode("LABRADOR");
            assertEquals(result,"BRLAARDO");
    }

    @Test
    public void testDecode1() {
        String result = TranspositionMatrixA.decode("BRLAARDO");
        assertEquals(result,"LABRADOR");
    }
    
        @Test
    public void testEncode2() {
        String result = TranspositionMatrixA.encode("OWCZAREKNIEMIECKI");
         assertEquals(result,"CZOAWKNRIEIEECMKI");
    }

    @Test
    public void testDecode2() {
        String result = TranspositionMatrixA.decode("CZOAWKNRIEIEECMKI");
         assertEquals(result,"OWCZAREKNIEMIECKI");
    }    
}
