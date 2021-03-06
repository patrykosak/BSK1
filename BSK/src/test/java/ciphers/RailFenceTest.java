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
public class RailFenceTest {
    public RailFenceTest() {
    }

    @Test
    public void testEncode() {
        String result = RailFence.encode("DALMATYNCZYK", 3);
         assertEquals(result,"DACAMTNZKLYY");
    }

    @Test
    public void testDecode() {
        String result = RailFence.decode("DACAMTNZKLYY", 3);
         assertEquals(result,"DALMATYNCZYK");
    }
    
        @Test
    public void testRailFance() {
        String plainText = "THEGLOVESPROTECTMYFEETFROMEXCESSWORK";
        String testCipherText = RailFence.encode(plainText, 3);
        String testPlainText = RailFence.decode(testCipherText, 3);
            assertEquals(plainText,testPlainText);
    }
    
        @Test
    public void testEncode1() {
        String result = RailFence.encode("LABRADOR", 4);
            assertEquals(result,"LOADRBAR");
    }

    @Test
    public void testDecode1() {
        String result = RailFence.decode("LOADRBAR", 4);
        assertEquals(result,"LABRADOR");
    }
    
        @Test
    public void testEncode2() {
        String result = RailFence.encode("OWCZAREKNIEMIECKI", 5);
         assertEquals(result,"ONIWKIKCEECZRMEAI");
    }

    @Test
    public void testDecode2() {
        String result = RailFence.decode("ONIWKIKCEECZRMEAI", 5);
         assertEquals(result,"OWCZAREKNIEMIECKI");
    }
}
