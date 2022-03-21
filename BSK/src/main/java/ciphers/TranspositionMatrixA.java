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
    public static String encode (String word) {
		int n = word.length();
		int d = 5;                  //liczba kolumn
		int rows = ((n-1)/d)+1;     //zapewnienie odpowiedniej liczby wierszy
		int tab[] = {3,4,1,5,2};    //klucz do szyfracji
		for (int i=0; i<tab.length;i++) {   
			tab[i]--;           //zmniejszenie klucza o 1 do lepszego indeksowanie
		}
		int dl = n;
		while((dl%d)!=0) {      //dopelnienie slowa spacjami do wielokrotnosci d
			word+=" ";
			dl++;
		}
		char[][] t_matrix = new char[rows][d];  //inicjalizacja tablicy wypelnionej slowem
		for (int i=0; i<rows; i++) {
			for (int j=0; j<d; j++) {
				t_matrix[i][j] = word.charAt(i*d+j);    //wpisywanie slowa do tablicy
			}
		}
		String result = "";
		char[][] result_matrix = new char[rows][d]; //inicjalizacja tablicy z zaszyfrowanym slowem
		for (int i=0; i<rows; i++) {
			for (int j=0; j<d; j++) {
				result_matrix[i][tab[j]] = t_matrix[i][j];  //wypelnienie tablicy zaszyfrowanej
			}

		}
		for (int i=0; i<rows; i++) {
			for (int j=0; j<d; j++) {
				result+=result_matrix[i][j];    //odczytywanie slowa
			}
		}
		String encoded_word;
		encoded_word = result.replaceAll(" ","");   //usuwanie spacji
		return encoded_word;
	}
	public static String decode (String word) {
		int n = word.length();
		int d = 5;
		int rows = ((n-1)/d)+1;
		int tab[] = {3,5,1,2,4};    //klucz do deszyfracji
		for (int i=0; i<tab.length;i++) {
			tab[i]--;
		}
		int dl = n;
		while((dl%d)!=0) {
			word+=" ";
			dl++;
		}
		char[][] t_matrix = new char[rows][d];
		for (int i=0; i<rows; i++) {
			for (int j=0; j<d; j++) {
				t_matrix[i][j] = word.charAt(i*d+j);
			}
		}
		String result = "";
		char[][] result_matrix = new char[rows][d];
		for (int i=0; i<rows; i++) {
			for (int j=0; j<d; j++) {
				result_matrix[i][tab[j]] = t_matrix[i][j];
			}

		}
		for (int i=0; i<rows; i++) {
			for (int j=0; j<d; j++) {
				result+=result_matrix[i][j];
			}
		}
		String decoded_word;
		decoded_word = result.replaceAll(" ","");
		return decoded_word;
	}
}
