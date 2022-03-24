package ciphers;

import java.util.Arrays;

public class LFSRGenerator {
    public static final boolean _1 = true;
    public static final boolean _0 = false;

    public static boolean[] generate(boolean[] polynomial, boolean[] seed_init, int keyLength) {
        boolean[] seed = Arrays.copyOf(seed_init, seed_init.length);
        boolean[] key = new boolean[keyLength];
        boolean xor;
        for (int i = 0; i < keyLength; i++) {
            key[i] = seed[seed.length - 1];
            xor = LFSRGenerator.performXors(polynomial, seed);
            LFSRGenerator.shiftBits(seed);
            seed[0] = xor;
        }
        return key;
    }

    private static boolean performXors(boolean[] polynomial, boolean[] seed) {
        boolean result = false;
        for (int i = 0; i < polynomial.length; i++) {
            if (polynomial[i]) {
                result ^= seed[i];
            }
        }
        return result;
    }

    private static void shiftBits(boolean[] seed) {
        for (int i = seed.length - 1; i > 0; i--) {
            seed[i] = seed[i-1];
        }
    }
}
