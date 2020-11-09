package Kursinis;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static private int friendlyLeft = 12;
    static private int enemyLeft = 12;
    static private boolean turnMade;
    static private String mov;
    static GameMap map = new GameMap();

    public static void main(String[] args) throws IOException {

        boolean gameOver = false;
        boolean turn = true;
        Scanner myScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        while (!gameOver) {
            turnMade = false;
            int key[] = new int[2];
            map.draw(turn);
            System.out.println("Select Checker line");
            key[0] = myScanner.nextInt();
            System.out.println("Select Checker Row");
            key[1] = myScanner.nextInt();
            if (!turn) {
                key[0] = (key[0] - 9) * (-1);
            }

            if (map.isValid(key[0], key[1], turn)) {
                System.out.println("Where do you want to Move L or R | HitL or HitR");
                mov = strScanner.nextLine();
                while (!turnMade) {
                    mov = mov.toUpperCase();
                    switch (mov) {
                        case "L":
                            //Simple move left
                            System.out.println("line is " + key[0]);
                            System.out.println("row is " + key[1]);

                            if ( map.checkLeft(key[0],key[1],turn)) {
                                if (!turn) {
                                    map.moveEnemyMap(key[0],key[1],'l');
                                } else {
                                    map.moveFriendlyMap(key[0],key[1],'l');
                                }
                                turnMade = true;
                                map.setNone(key[0],key[1]);
                                break;
                            } else {
                                break;
                            }
                        case "R":
                            //Simple move right
                            if (map.checkRight(key[0],key[1],turn)){
                                map.moveEnemyMap(key[0],key[1],'r');
                                map.setNone(key[0],key[1]);
                                turnMade = true;
                                break;
                            }
                            else {
                                map.moveFriendlyMap(key[0],key[1],'r');
                                map.setNone(key[0],key[1]);
                                turnMade = true;
                                break;
                            } //else {
                               // System.out.println("WRONG INPUT");
                            //}
                        case "HITL":
                            try {
                                if (map.checkIsHittableLeft(key[0],key[1],turn) && turn) {
                                        map.hitFriendly(key[0],key[1],'l');
                                        map.setNone(key[0],key[1]);
                                        enemyLeft--;
                                        key[0] = key[0] + 2;
                                        key[1] = key[1] - 2;
                                        hitRepeat(map.isHit(key[0],key[1],turn),turn);
                                        break;
                                }
                                if (map.checkIsHittableLeft(key[0],key[1],turn)) {
                                    map.hitEnemy(key[0],key[1],'l');
                                    map.setNone(key[0],key[1]);
                                    friendlyLeft--;
                                    key[0] = key[0] - 2;
                                    key[1] = key[1] - 2;
                                    hitRepeat(map.isHit(key[0],key[1],turn),turn);
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("WRONG INPUT");
                                break;
                            }

                        case "HITR":
                            try {
                                if (turn) {
                                    if (map.checkIsHittableRight(key[0],key[1],turn)) {
                                        map.hitFriendly(key[0],key[1],'r');
                                        map.setNone(key[0],key[1]);
                                        enemyLeft--;
                                        key[0] = key[0] + 2;
                                        key[1] = key[1] + 2;
                                        hitRepeat(map.isHit(key[0],key[1],turn),turn);
                                        break;
                                    }
                                }

                                if (map.checkIsHittableRight(key[0],key[1],turn)) {
                                    map.hitEnemy(key[0],key[1],'r');
                                    map.setNone(key[0],key[1]);
                                    friendlyLeft--;
                                    key[0] = key[0] - 2;
                                    key[1] = key[1] + 2;
                                    hitRepeat(map.isHit(key[0],key[1],turn),turn);
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
            else System.out.println("WRONG INPUT");
            System.out.println("\n \n \n \n \n \n \n \n \n \n \n");
            if (friendlyLeft==0 || enemyLeft==0){
                gameOver=!gameOver;
                System.out.println("GAME OVER");
            }

        }
    }

    public static void hitRepeat(String next,boolean turn){
        Scanner strScanner = new Scanner(System.in);
        if (next==""){
            turnMade=true;
        }
        else
        {
            System.out.println("\n \n \n \n \n \n \n \n \n \n \n");
            map.draw(turn);
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