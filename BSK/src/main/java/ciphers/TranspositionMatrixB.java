package ciphers;

import java.util.Arrays;

public class TranspositionMatrixB {

    public static String encode(String message, String keyword) {
        message = message.replaceAll(" ", "");
        String encodedMessage = "";
        int rows = message.length() / keyword.length() + 1;
        char[][] matrix = new char[rows][keyword.length()];
        char[] messageToEncode = message.toCharArray();

        //Tworzenie tablicy z wiadomością
        int idx = 0;
        for (int row = 0; row < rows; row++) {
            if (messageToEncode.length == idx)
                break;
            for (int col = 0; col < keyword.length(); col++) {
                matrix[row][col] = messageToEncode[idx];
                idx++;
                if (messageToEncode.length == idx)
                    break;
            }
        }

        //Kodowanie wiadomości
        int key[] = TranspositionMatrixB.getKey(keyword);
        for (int i = 1; i <= keyword.length(); i++) {
            for (int col = 0; col < keyword.length(); col++) {
                if (i == key[col]) {
                    for (int row = 0; row < rows; row++) {
                        encodedMessage += matrix[row][col];
                    }
                    encodedMessage += " ";
                }
            }
        }
        encodedMessage = encodedMessage.replaceAll("\0", "");
        return encodedMessage;
    }


    public static String decode(String message, String keyword) {

        //Przygotowanie danych
        String[] strings = message.split(" ");
        message = message.replaceAll(" ", "");
        int rows = message.length() / keyword.length() + 1;
        char[][] matrix = new char[rows][keyword.length()];
        char[] messageToDecode = message.toCharArray();


        //Dekodowanie wiadomości
        int key[] = TranspositionMatrixB.getKey(keyword);
        for(int keyNumber = 0; keyNumber < key.length; keyNumber++) {
            char [] chunk = strings[key[keyNumber]-1].toCharArray();
            for (int row = 0; row<rows;row ++) {
                matrix[row][keyNumber] = chunk[row];
                if(chunk.length == row+1)
                    break;
            }
        }
        //Odczytanie wiadomości
        String clearMessage = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < keyword.length(); col++) {
                clearMessage += matrix[row][col];
            }
        }
        clearMessage = clearMessage.replaceAll("\0", "");
        return clearMessage;
    }

    // Metoda zwraca klucz w postaci tablicy liczb na podstawie danego słowa kluczowego
    // (każdej literze przypisuje liczbę na podstawie jej kodu ASCII oraz jej pozycji w słowie
    private static int[] getKey (String keyword){
        char[] keyChars = keyword.toCharArray();
        char[] tempKeyChars = keyChars.clone();
        int[] key = new int[keyword.length()];
        Arrays.sort(tempKeyChars);
        for (int idx = 0; idx < tempKeyChars.length; idx++) {
            int letter = tempKeyChars[idx];
            for (int jdx = 0; jdx < keyChars.length; jdx++) {
                if (keyChars[jdx] == letter && key[jdx] == 0) {
                    key[jdx] = idx + 1;
                    break;
                }
            }
        }
        return key;
    }
}
