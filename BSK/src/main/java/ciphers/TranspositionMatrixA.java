/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciphers;

/**
 *
 * @author Marcin
 */
public class TranspositionMatrixA {
    
       public static String encode(String word, Integer [] key) {
           
        int d = key.length;
        char[][] matrix = new char[word.length()/d + 1][d];
        int iterator = 0;

        // Uzupełnianie macierzy
        for (int i = 0; i < word.length()/d+1; i++) {
            for (int j = 0; j < d; j++) {
                // dopisywanie zer gdy słowo się skończy
                if (iterator >= word.length()) {
                    matrix[i][j] = '0';
                } else {
                    matrix[i][j] = word.charAt(iterator);
                }
                iterator++;
            }
        }

        // Odczytanie zakodowanego slowa
        String result = "";
        for (int j = 0; j < word.length()/d + 1; j++) {
            for (int i = 0; i < d; i++) {
                result += matrix[j][key[i]-1];
            }
        }
        result = result.replace("0", "");
        return result;
    }

    public static String decode(String word, Integer [] key) {
        int d = key.length;
        char[][] matrix = new char[word.length()/d + 1][d];
        int iterator = 0;

        // obliczenie liczby pustych komórek
        int space = ((word.length()/d + 1) * d) - word.length();
        // uzupełnienie pustych komórek
        for (int i = d-1; space > 0; i--) {
            matrix[word.length()/d][i] = '0';
            space--;
        }

        // Wpisywanie liter według klucza
        for (int j = 0; j < word.length()/d + 1; j++) {
            for (int i = 0; i < d; i++) {
                if (matrix[j][key[i]-1] != '0') {
                    matrix[j][key[i]-1] = word.charAt(iterator);
                    iterator++;
                }
            }
        }

        // Oczytanie odszyfrowanej wiadomości
        String result = "";
        for (int j = 0; j < word.length()/d + 1; j++) {
            for (int i = 0; i < d; i++) {
                result += matrix[j][i];
            }
        }
        result = result.replace("0", "");
        return result;
    }
}
