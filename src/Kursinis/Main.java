package Kursinis;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static private int model[][] = new int[][]{
            {7, 7, 7, 7, 7, 7, 7, 7, 7},
            {7, 0, 1, 0, 1, 0, 1, 0, 1},
            {7, 1, 0, 0, 0, 1, 0, 1, 0},
            {7, 0, 1, 0, 1, 0, 1, 0, 1},
            {7, 0, 0, 0, 0, 0, 0, 0, 0},
            {7, 0, 0, 0, 1, 0, 0, 0, 0},
            {7,-1, 0,-1, 0,-1, 0,-1, 0},
            {7, 0,-1, 0,-1, 0,-1, 0, 0},
            {7,-1, 0,-1, 0,-1, 0,-1, 0},
    };
    static private int friendlyLeft = 12;
    static private int enemyLeft = 12;
    static private boolean turnMade;
    static private String mov;

    public static void main(String[] args) throws IOException {
        boolean gameOver = false;
        boolean turn = true;
        Scanner myScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        while (!gameOver) {
            turnMade = false;
            int key[] = new int[2];
            draw(turn);
            System.out.println("Select Checker line");
            key[0] = myScanner.nextInt();
            System.out.println("Select Checker Row");
            key[1] = myScanner.nextInt();
            if (!turn) {
                key[0] = (key[0] - 9) * (-1);
                System.out.println(key[0]);
            }
            if (isValid(key[0], key[1], turn)) {
                System.out.println("Where do you want to Move L or R | HitL or HitR");
                mov = strScanner.nextLine();
                while (!turnMade) {
                    mov = mov.toUpperCase();
                    switch (mov) {
                        case "L":
                            //Simple move left
                            System.out.println("line is " + key[0]);
                            System.out.println("row is " + key[1]);
                            if (model[key[0] + 1][key[1] - 1] == 0 && turn || (!turn && model[key[0] - 1][key[1] - 1] == 0)) {
                                if (!turn) {
                                    model[key[0] - 1][key[1] - 1] = -1;
                                } else {
                                    model[key[0] + 1][key[1] - 1] = 1;
                                }
                                turnMade = true;
                                model[key[0]][key[1]] = 0;
                                System.out.println("aaa");
                                break;
                            } else {
                                break;
                            }
                        case "R":
                            //Simple move right
                            if (!turn && (model[key[0] - 1][key[1] + 1] == 0)){
                                model[key[0] - 1][key[1] + 1] = -1;
                                model[key[0]][key[1]] = 0;
                                turnMade = true;
                                break;
                            }
                            else if (turn && (model[key[0] + 1][key[1] + 1] == 0)) {
                                model[key[0] + 1][key[1] + 1] = 1;
                                model[key[0]][key[1]] = 0;
                                turnMade = true;
                                break;
                            } else {
                                System.out.println("WRONG INPUT");
                            }
                        case "HITL":
                            try {
                                if (turn) {
                                    if ((model[key[0] + 1][key[1] - 1] == -1 && model[key[0] + 2][key[1] - 2] == 0)) {
                                        model[key[0] + 2][key[1] - 2] = 1;
                                        model[key[0] + 1][key[1] - 1] = 0;
                                        model[key[0]][key[1]] = 0;
                                        enemyLeft--;
                                        key[0] = key[0] + 2;
                                        key[1] = key[1] - 2;
                                        hitRepeat(isHit(key[0],key[1],turn),turn);
                                        break;
                                    }
                                }

                                if ((model[key[0] - 1][key[1] - 1] == 1 && model[key[0] - 2][key[1] - 2] == 0) && !turn) {
                                    model[key[0] - 2][key[1] - 2] = -1;
                                    model[key[0] - 1][key[1] - 1] = 0;
                                    model[key[0]][key[1]] = 0;
                                    friendlyLeft--;
                                    key[0] = key[0] - 2;
                                    key[1] = key[1] - 2;
                                    hitRepeat(isHit(key[0],key[1],turn),turn);
                                    break;
                                }
                            } catch (Exception e) {

                                System.out.println("WRONG INPUT");
                                break;
                            }

                        case "HITR":
                            //When moving right check if you can hit
                            try {
                                if (turn) {
                                    if ((model[key[0] + 1][key[1] + 1] == -1 && model[key[0] + 2][key[1] + 2] == 0)) {
                                        model[key[0] + 2][key[1] + 2] = 1;
                                        model[key[0] + 1][key[1] + 1] = 0;
                                        model[key[0]][key[1]] = 0;
                                        enemyLeft--;
                                        key[0] = key[0] + 2;
                                        key[1] = key[1] + 2;
                                        hitRepeat(isHit(key[0],key[1],turn),turn);
                                        break;
                                    }
                                }

                                if ((model[key[0] - 1][key[1] + 1] == 1 && model[key[0] - 2][key[1] + 2] == 0) && !turn) {
                                    model[key[0] - 2][key[1] + 2] = -1;
                                    model[key[0] - 1][key[1] + 1] = 0;
                                    model[key[0]][key[1]] = 0;
                                    friendlyLeft--;
                                    key[0] = key[0] - 2;
                                    key[1] = key[1] + 2;
                                    hitRepeat(isHit(key[0],key[1],turn),turn);
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("WRONG INPUT");
                                break;
                            }

                        default:
                            break;
                    }
                }

                if (turnMade) turn = !turn;

            }
            else System.out.println("WRONG INPUT" + model[key[0]][key[1]]);
            System.out.println("\n \n \n \n \n \n \n \n \n \n \n");
        }
    }

    public static void draw(boolean turn) {

        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                System.out.print("   ");
            } else {
                System.out.printf("%3d", i);
            }
        }
        System.out.println("\n" + "     ----------------------");
        for (int i = 1; i < model.length; i++) {
            if (turn) {
                System.out.printf("%2d", i);
            } else {
                System.out.printf("%2d", model.length - i);
            }
            System.out.print("|");
            for (int j = 1; j < model.length; j++) {
                System.out.printf("%3d", model[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isValid(int a, int b, boolean turn) {
        if (turn && (model[a][b] == 1 || model[a][b] == 2 )) {
            return true;
        }
        if (!turn && (model[a][b] == -1 || model[a][b] == -2 )) {
            return true;
        }
        return false;
    }

    public static String isHit(int key0, int key1,boolean turn) {
        if (turn){
            if (model[key0+1][key1-1]==-1 && model[key0+2][key1-2]==0){
                return "HitL";
            }
            if (model[key0+1][key1+1]==-1 && model[key0+2][key1+2]==0){
                return "HitR";
            }
        }
        if(!turn){
            if (model[key0-1][key1-1]==1 && model[key0-2][key1-2]==0){
                return "HitL";
            }
            if (model[key0-1][key1+1]==1 && model[key0-2][key1+2]==0){
                return "HitR";
            }
        }
        return "";
    }
    public static void hitRepeat(String next,boolean turn){
        Scanner strScanner = new Scanner(System.in);
        if (next==""){
            turnMade=true;
        }
        else
        {
            System.out.println("\n \n \n \n \n \n \n \n \n \n \n");
            draw(turn);
            System.out.println("Do you want to hit one More time? Y/N");
            if (strScanner.nextLine().equals("Y")){
                System.out.println("mov is "+next);
                mov=next;
            }
            else{
                turnMade=true;
            }
        }
    }

}
