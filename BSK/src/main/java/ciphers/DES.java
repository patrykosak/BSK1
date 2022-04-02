/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xxx
 */
public class DES {
    private static int[] PC1 = new int[]{ 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34,
            26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63,
            55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53,
            45, 37, 29, 21, 13, 5, 28, 20, 12, 4 };
    
     private static int[] PC2 = { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10,
            23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55,
            30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29,
            32 };
     
       private static int[] initialPermutation = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36,
            28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32,
            24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19,
            11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };
       
        private static int[] shift = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2,
            2, 1 };
        
        private static int[] tableExtension = { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8,
            9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21,
            20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32,
            1 };
        
        private static int[] pMatrix = { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5,
            18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4,
            25};

          private static int[] finalPermutation = { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47,
            15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13,
            53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51,
            19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17,
            57, 25 };
        
         private static int[][][] sbox = {
            { 		{ 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
                    { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
                    { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
                    { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 }
            },
            { 		{ 15, 1, 8, 14, 6, 11, 3, 2, 9, 7, 2, 13, 12, 0, 5, 10 },
                    { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
                    { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
                    { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 }
            },
            { 		{ 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
                    { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
                    { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
                    { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 }
            },
            { 		{ 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
                    { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
                    { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
                    { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 }
            },
            { 		{ 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
                    { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
                    { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
                    { 11, 8, 12, 7, 1, 14, 2, 12, 6, 15, 0, 9, 10, 4, 5, 3 }
            },
            { 		{ 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
                    { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
                    { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
                    { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 }

            },
            { 		{ 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
                    { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
                    { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
                    { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 }

            },
            { 		{ 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
                    { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
                    { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
                    { 2, 1, 14, 7, 4, 10, 18, 13, 15, 12, 9, 0, 3, 5, 6, 11 }

            } };
         
        public static String encode(String text, String key){
             String textAfterInitialPermutation = DES.permute(text, initialPermutation, 64);
             String textLeft = textAfterInitialPermutation.substring(0,32); //PL
             String textRight = textAfterInitialPermutation.substring(32);  //Pr
             
             String keyAfterPC1 = permute(key, PC1, 56);
             String C0 = keyAfterPC1.substring(0,28);
             String D0 = keyAfterPC1.substring(28);
             
             ArrayList<String> subKeys = generateSubKeys(C0, D0,shift);
             ArrayList<String> finalKeys = new ArrayList<>();
             for(int x = 0; x < 16; x++){
                 String keyPermuted = permute(subKeys.get(x), PC2, 48);
                 finalKeys.add(keyPermuted);
             }
             
             for(int i = 0; i < 16; i++){
                 String nextLeft = textRight;
                 String extendedRigtht = permute(textRight, tableExtension, 48);
                 String XOROutputWithKey = XOR(extendedRigtht, finalKeys.get(i));
                 
                 String reducedOutput = SBox(XOROutputWithKey);
                 String permuted = permute(reducedOutput, pMatrix, 32);
                 String prefinal = XOR(permuted, textLeft);
                 
                 textLeft = nextLeft;
                 textRight = prefinal;
                 
             }
             
             String outputBeforeFinalPermutation = textRight + textLeft;
             String result = permute(outputBeforeFinalPermutation,finalPermutation,64);
             
             return result;
                 }
         
        public static String decode(String text, String key){
             String textAfterInitialPermutation = DES.permute(text, initialPermutation, 64);
             String textLeft = textAfterInitialPermutation.substring(0,32); //PL
             String textRight = textAfterInitialPermutation.substring(32);  //Pr
             
             String keyAfterPC1 = permute(key, PC1, 56);
             String C0 = keyAfterPC1.substring(0,28);
             String D0 = keyAfterPC1.substring(28);
             
             ArrayList<String> subKeys = generateSubKeys(C0, D0,shift);
             ArrayList<String> finalKeys = new ArrayList<>();
             for(int x = 15; x >= 0; x--){
                 String keyPermuted = permute(subKeys.get(x), PC2, 48);
                 finalKeys.add(keyPermuted);
             }
             
             for(int i = 0; i < 16; i++){
                 String nextLeft = textRight;
                 String extendedRigtht = permute(textRight, tableExtension, 48);
                 String XOROutputWithKey = XOR(extendedRigtht, finalKeys.get(i));
                 
                 String reducedOutput = SBox(XOROutputWithKey);
                 String permuted = permute(reducedOutput, pMatrix, 32);
                 String prefinal = XOR(permuted, textLeft);
                 
                 textLeft = nextLeft;
                 textRight = prefinal;
                 
             }
             
             String outputBeforeFinalPermutation = textRight + textLeft;
             String result = permute(outputBeforeFinalPermutation,finalPermutation,64);
             
             return result;
             
                 } 
         
         private static String permute(String key, int[] matrix, int size) {
             String keyOutput="";
             for(int x = 0; x < size; x++){
                 int position = matrix[x];
                 keyOutput+=key.charAt(position-1);
             }
             return keyOutput;
            }
         
         private static ArrayList<String> generateSubKeys(String leftHalf, String rightHalf, int[] shifts){
             ArrayList<String> keys = new ArrayList<>();
             for(int i = 0; i < 16; i++){
                 for(int j = 0; j < shifts[i]; j++){
                     leftHalf = DES.circularShiftLeft(leftHalf);
                     rightHalf = DES.circularShiftLeft(rightHalf);
                 }
                 keys.add(leftHalf + rightHalf);
             }
             return keys;
         }
         
         private static String circularShiftLeft(String half) {
             char tempChar = half.charAt(0);
             String rest = half.substring(1);
             String output = rest + tempChar;
             return output;
         }
         
         private static String XOR(String a, String b){
             StringBuilder sb = new StringBuilder();
             for (int i = 0; i < a.length(); i++){
                 sb.append((a.charAt(i) ^ b.charAt(i)));
             }
             return sb.toString();
         }
         
         private static String SBox(String newRight){
             StringBuilder builder = new StringBuilder();
             
             for (int i = 0; i < 48; i +=6){
                 String sum = newRight.substring(i,i+6);
                 char first = sum.charAt(0);
                 char second = sum.charAt(5);
                 StringBuilder sb = new StringBuilder();
                 sb.append(first);
                 sb.append(second);
                 int row = Integer.parseInt(sb.toString(),2);
                 String column = sum.substring(1,5);
                 int col = Integer.parseInt(column,2);
                 
                 int value = sbox[i/6][row][col];
                 String x = Integer.toBinaryString(value);
                 while(x.length() < 4){
                     x = "0"+x;
                 }
                 builder.append(x);
             }
             return builder.toString();
        }

    private static String convertBytesIntoString(String input){
        StringBuilder sb = new StringBuilder();
        Arrays.stream(input.split("(?<=\\G.{8})")).forEach(s ->sb.append((char) Integer.parseInt(s, 2)));
        return sb.toString();
    }

    private static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
        }
        return result.toString();
    }

    private static List<String> splitToEncode(String text) {
        String[] results = text.split("(?<=\\G.{" + 8 + "})");
        if ( results[results.length-1].length() != 8) {
            int zeros = 8 - results[results.length-1].length();
            for (int i = 0; i < zeros-1; i++)
                results[results.length-1] += "0";
            results[results.length-1] += zeros;
            return Arrays.asList(results);
        }
        else {
            String[] f_results = Arrays.copyOf(results, results.length+1);
            f_results[results.length] = "0000000~";
            return Arrays.asList(f_results);
        }
    }

    private static List<String> splitToDecode(String text) {
        String[] results = text.split("(?<=\\G.{" + 64 + "})");
        return Arrays.asList(results);
    }

    public static String takeIn(String text) {
        List<String> strings = splitToEncode(text);
        String out = "";
        for ( String string : strings) {
             String str = convertStringToBinary(string);
             String encoded = encode(str,"KEY");
             out += encoded;
        }
        return out;
    }

    public static String takeOut(String text) {
        List<String> strings = splitToDecode(text);
        String out = "";
        for (String string : strings) {
            String decoded = decode(string, "KEY");
            String str = convertBytesIntoString(decoded);
            if ( strings.indexOf(string) == strings.size() - 1) {
                if ( str.equals("0000000~"))
                    break;
                int bits = Character.getNumericValue(str.charAt(str.length() - 1));
                str = str.substring(0, str.length()-bits);
            }
            out += str;
        }
        return out;
    }
}
