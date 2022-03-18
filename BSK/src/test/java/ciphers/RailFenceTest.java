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

    @org.junit.jupiter.api.Test
    public void testEncode() {
        String result = RailFence.encode("DALMATYNCZYK", 3);
        assert result.equals("DACAMTNZKLYY");
    }

    @org.junit.jupiter.api.Test
    public void testDecode() {
        String result = RailFence.decode("DACAMTNZKLYY", 3);
        assert result.equals("DALMATYNCZYK");
    }
    
        @org.junit.jupiter.api.Test
    public void testEncode1() {
        String result = RailFence.encode("ANTROPOMORFIZACJA", 6);
        assert result.equals("AFNRITOZRMAOOCAPJ");
    }

    @org.junit.jupiter.api.Test
    public void testDecode1() {
        String result = RailFence.decode("AFNRITOZRMAOOCAPJ", 6);
        assert result.equals("ANTROPOMORFIZACJA");
    }
    
        @org.junit.jupiter.api.Test
    public void testEncode2() {
        String result = RailFence.encode("LABRADOR", 4);
        assert result.equals("LOADRBAR");
    }

    @org.junit.jupiter.api.Test
    public void testDecode2() {
        String result = RailFence.decode("LOADRBAR", 4);
        assert result.equals("LABRADOR");
    }
    
        @org.junit.jupiter.api.Test
    public void testEncode3() {
        String result = RailFence.encode("OWCZAREKNIEMIECKI", 5);
        assert result.equals("ONIWKIKCEECZRMEAI");
    }

    @org.junit.jupiter.api.Test
    public void testDecode3() {
        String result = RailFence.decode("ONIWKIKCEECZRMEAI", 5);
        assert result.equals("OWCZAREKNIEMIECKI");
    }
}
