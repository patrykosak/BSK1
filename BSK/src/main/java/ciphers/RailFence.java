package ciphers;

public class RailFence {


    public static String encode(String word, int key){
        char[][] fence = new char[word.length()][key];
        int row = 0;
        boolean down = false;
        //tworzenie płotka
        for(int i =0; i<word.length();i++){
            fence[i][row]=word.charAt(i);
            //odbiajnie się od góry i od dołu
            if(row==key-1||row==0)
                down=!down;
            if(down)
                row++;
            else
                row--;
        }

        //odczytywanie płotka
        String result = "";
        for (int j = 0; j < key; j++) {
            for (int i = 0; i < word.length(); i++) {
                if (fence[i][j] != 0) {
                    result += fence[i][j];
                }
            }
        }
        return result;
    }

    public static String decode(String word, int key){
        char[][] fence = new char[word.length()][key];
        int row = 0;
        boolean down = false;
        //tworzenie płotka
        for(int i =0; i<word.length();i++){
            //zaznaczanie wystąpienia litery
            fence[i][row]='*';
            //odbiajnie się od góry i od dołu
            if(row==key-1||row==0)
                down=!down;
            if(down) row++;
            else row--;
        }

        int charCounter = 0;
        //zamiana gwiazdek na litery
        for(int j=0;j<key;j++){
            for(int i=0;i<word.length();i++){
                if(fence[i][j]=='*'){
                    fence[i][j]=word.charAt(charCounter);
                    charCounter++;
                }
            }
        }

        String result="";
        down=false;
        row=0;
        //odczytytanie wyniku
        for(int i=0;i<word.length();i++){
            if(row==0||row==key-1){
                down=!down;
            }
            result+=fence[i][row];
            if(down) row++;
            else row--;
        }
        return result;
    }

}
