package ciphers;

import java.util.Arrays;
import java.util.List;

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
        encodedMessage = encodedMessage.replaceAll(" ", "");
        return encodedMessage;
    }


    public static String decode(String message, String keyword) {

        int rows = message.length()/keyword.length() + 1; //obliczenie ilości wierszy
        int cols = keyword.length();
        char[][] matrix = new char[rows][cols];
        int iterator = 0; 

        int spaces = rows * cols - message.length(); //obliczamy ilość nadmaiarowych komórek
        int index = cols - 1;
        while (spaces > 0) {
            matrix[rows - 1][index] = '0'; // wypełniamy 0 nadmariowe komórki
            spaces--;
            index--;
        }

        // Przedstawienie klucza jako tablica intów
        Integer[] keyOrder = new Integer[cols];
        int iteratorKey = 1;
        for (int i = 65; i <= 90; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                if (i == (int)keyword.charAt(j)) {
                    keyOrder[j] = iteratorKey;
                    iteratorKey++;
                }
            }
        }

        // Wypełnienie macierzy
        List<Integer> keyOrderList = Arrays.asList(keyOrder);
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                if (matrix[i][keyOrderList.indexOf(j+1)] != '0') {
                    matrix[i][keyOrderList.indexOf(j+1)] = message.charAt(iterator);
                    iterator++;
                }
            }
        }
        String result = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result += matrix[i][j];
            }
        }

        result = result.replace("0", "");

        return result;
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
