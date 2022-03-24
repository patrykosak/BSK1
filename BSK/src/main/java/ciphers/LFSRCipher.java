package ciphers;

import java.math.BigInteger;
import java.util.Arrays;

public class LFSRCipher {


    private static final boolean _0 = false;
    private static final boolean _1 = true;

    private static String convertBytesIntoString(boolean[] binary_text) {
        char[] help = new char[binary_text.length];
        for( int index = 0; index < binary_text.length; index++) {
            if(binary_text[index])
                help[index] = '1';
            else
                help[index] = '0';
        }
        String text = String.valueOf(help);
        String result = new String(new BigInteger(text, 2).toByteArray());
        return result;
    }


    private static boolean[] convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))
                            .replaceAll(" ", "0")
            );
        }
        String res = result.toString();
        char[] help = res.toCharArray();
        boolean[] binary = new boolean[help.length];
        for( int i = 0; i< help.length; i++) {
            int number = help[i];
            if( number % 2 == 0)
                binary[i] = _0;
            else
                binary[i] = _1;
        }
        return binary;
    }

    private static boolean[] performXors(boolean[] binary_text, boolean[] key) {
        boolean[] result = new boolean[binary_text.length];
        for (int i = 0; i < binary_text.length; i++) {
            result[i] = binary_text[i] ^ key[i];
        }
        return result;
    }


    public static boolean[] encode (String text, boolean[] polynomial, boolean[] seed) {
        boolean[] binary_text = convertStringToBinary(text);
        System.out.println("Binary text: " + Arrays.toString(binary_text));
        boolean[] key =  LFSRGenerator.generate(polynomial, seed, binary_text.length);
        boolean[] result = LFSRCipher.performXors(binary_text, key);
        System.out.println("ENCODED    : " + Arrays.toString(result));

        return result;
    }

    public static String decode (boolean[] binary_text, boolean[] polynomial, boolean[] seed) {
        boolean[] key =  LFSRGenerator.generate(polynomial, seed, binary_text.length);
        boolean[] result = LFSRCipher.performXors(binary_text, key);
        String text_result = LFSRCipher.convertBytesIntoString(result);
        return text_result;
    }
}
