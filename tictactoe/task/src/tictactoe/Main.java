package tictactoe;

import java.io.*;

public class Main {

    public static String[][] tictactoeMatrix() {
        String[][] arr = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = "_";
            }
        }
        return arr;
    }

    public static void printMatrix(String[][] str) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            StringBuilder s = new StringBuilder("| ");
            for (int j = 0; j < 3; j++) {
                s.append(str[i][j]).append(" ");
            }
            System.out.println(s + "|");
        }
        System.out.println("---------");
    }

    public static void gamePlay(String[][] str) throws IOException {
        int n = 1;
        while (n < 10) {
            System.out.print("Enter the coordinates: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] inp = br.readLine().split(" ");
            try {
                int x = Integer.parseInt(inp[0]);
                int y = Integer.parseInt(inp[1]);
                if ((x - 1) > 3 || (y - 1) > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (str[x - 1][y - 1].equals("_")) {
                    if (n % 2 != 0) {
                        str[x - 1][y - 1] = "X";
                    } else {
                        str[x - 1][y - 1] = "O";
                    }
                    printMatrix(str);
                    String ans = resultOfTictactoe(str);
                    if (ans.equals("X wins") || ans.equals("O wins")) {
                        System.out.println(ans);
                        break;
                    }
                    n++;
                } else if (str[x - 1][y - 1].equals("X") || str[x - 1][y - 1].equals("O")) {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
        if (draw(str)) {
            System.out.println("Draw");
        }
    }


    public static String resultOfTictactoe(String[][] str) {
        if (xWins(str)) {
            return "X wins";
        } else if (oWins(str)) {
            return "O wins";
        }
        return "";
    }

    public static boolean draw(String[][] str) {
        return !(xWins(str) || oWins(str));
    }

    public static boolean xWins(String[][] str) {
        String X = "XXX";
        boolean x = false;
        boolean y = false;
        for (int i = 0; i < 3; i++) {
            StringBuilder check = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                check.append(str[i][j]);
            }
            if (check.toString().equals(X)) {
                x = true;
            }
        }
        for (int j = 0; j < 3; j++) {
            StringBuilder check = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                check.append(str[i][j]);
            }
            if (check.toString().equals(X)) {
                y = true;
            }
        }
        String s1 = str[0][0]+ str[1][1] + str[2][2];
        String s2 = str[0][2]+ str[1][1] + str[2][0];
        return x || y || s1.equals(X) || s2.equals(X);
    }

    public static boolean oWins(String[][] str) {
        String O = "OOO";
        boolean x = false;
        boolean y = false;
        for (int i = 0; i < 3; i++) {
            StringBuilder check = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                check.append(str[i][j]);
            }
            if (check.toString().equals(O)) {
                x = true;
            }
        }
        for (int j = 0; j < 3; j++) {
            StringBuilder check = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                check.append(str[i][j]);
            }
            if (check.toString().equals(O)) {
                y = true;
            }
        }
        String s1 = str[0][0]+ str[1][1] + str[2][2];
        String s2 = str[0][2]+ str[1][1] + str[2][0];
        return x || y || s1.equals(O) || s2.equals(O);
    }


    public static void main(String[] args) throws IOException {
        // write your code here
        String[][] str = tictactoeMatrix();
        printMatrix(str);
        gamePlay(str);


    }
}
