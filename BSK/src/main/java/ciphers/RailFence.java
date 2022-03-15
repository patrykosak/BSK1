package ciphers;

public class RailFence {


    public static String encode(String word, int key){
        char[][] fence = new char[word.length()][key];
        int row = 0;
        boolean down = false;
        for(int i =0; i<word.length();i++){
            fence[i][row]=word.charAt(i);
            if(row==key-1||row==0)
                down=!down;
            if(down)
                row++;
            else
                row--;
        }

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
        for(int i =0; i<word.length();i++){
            fence[i][row]='*';
            if(row==key-1||row==0)
                down=!down;
            if(down)
                row++;
            else
                row--;
        }

        int charCounter = 0;

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
        for(int i=0;i<word.length();i++){
            if(row==0||row==key-1){
                down=!down;
            }
            result+=fence[i][row];
            if(down)
                row++;
            else
                row--;

        }


        return result;
    }

}
