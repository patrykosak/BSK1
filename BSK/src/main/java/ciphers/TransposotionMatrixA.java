/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciphers;

/**
 *
 * @author Marcin
 */
public class TransposotionMatrixA {
    public static String encode (String word) {
		int n = word.length();
		int d = 5;
		int rows = ((n-1)/d)+1;
		int tab[] = {3,4,1,5,2};
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
		return result;
	}
	public static String decode (String word) {
		int n = word.length();
		int d = 5;
		int rows = ((n-1)/d)+1;
		int tab[] = {3,5,1,2,4};
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
		return result;
	}
}
