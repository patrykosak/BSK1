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
    
    Integer [] key = new Integer[]{3,4,1,5,2};
    @Test
    public void testEncode() {
        String result = TranspositionMatrixA.encode("DALMATYNCZYK",key);
         assertEquals(result,"LMDAANCTZYYK");
    }

    @Test
    public void testDecode() {
        String result = TranspositionMatrixA.decode("LMDAANCTZYYK",key);
         assertEquals(result,"DALMATYNCZYK");
    }
    
        @Test
    public void testMatrixA() {
        String plainText = "THEGLOVESPROTECTMYFEETFROMEXCESSWORK";
        String testCipherText = TranspositionMatrixA.encode(plainText,key);
        String testPlainText = TranspositionMatrixA.decode(testCipherText,key);
            assertEquals(plainText,testPlainText);
    }
    
        @Test
    public void testEncode1() {
        String result = TranspositionMatrixA.encode("LABRADOR",key);
            assertEquals(result,"BRLAARDO");
    }

    @Test
    public void testDecode1() {
        String result = TranspositionMatrixA.decode("BRLAARDO",key);
        assertEquals(result,"LABRADOR");
    }
    
        @Test
    public void testEncode2() {
        String result = TranspositionMatrixA.encode("OWCZAREKNIEMIECKI",key);
         assertEquals(result,"CZOAWKNRIEIEECMKI");
    }

    @Test
    public void testDecode2() {
        String result = TranspositionMatrixA.decode("CZOAWKNRIEIEECMKI",key);
         assertEquals(result,"OWCZAREKNIEMIECKI");
    }    
}
