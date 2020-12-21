package com.company.model;

import java.util.Scanner;

public class GamePlay {
    private PlayerA playerA;
    private PlayerB playerB;
    Scanner myScanner = new Scanner(System.in);
    Scanner strScanner = new Scanner(System.in);

    public GamePlay(PlayerA playerA, PlayerB playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }
    public GamePlay() {

    }
    public boolean GameOver(){
        return playerA.getCheckersLeft() == 0 || playerB.getCheckersLeft() == 0;
    }

    public void processInput(boolean turn){
        GameMap map = new GameMap();
        map.updateMap(playerA.getCheckers(), playerB.getCheckers());
        map.draw(turn);
        if (turn){
            System.out.println("Player A Select Checker line");
        }
        else
        {
            System.out.println("Player B Select Checker line");
        }
        int[] key = new int[2];
        key[0] = myScanner.nextInt();
        System.out.println("Select Checker Row");
        key[1] = myScanner.nextInt();

        System.out.println("Where do you want to Move L or R | HitL or HitR");
        String mov = strScanner.nextLine();
        if (turn){
            processAction(key[0], key[1],map,mov);
        }
        else{
            processActionEnemy(key[0], key[1],map,mov);
        }
    }

    public void processAction(int x, int y, GameMap map, String mov){
        GameActions gameActionsPlayerA = new GameActionsPlayerA(playerA,playerB);
        switch (mov){
            case "L":
                playerA.moveLeft(gameActionsPlayerA,x,y,map);
                break;
            case "R":
                playerA.moveRight(gameActionsPlayerA,x,y,map);
                break;
            case "HitL":
                playerA.hitLeft(gameActionsPlayerA,x,y,map);
                break;
            case "HitR":
                playerA.hitRight(gameActionsPlayerA,x,y,map);
                break;
            default:
                break;
        }
    }

    public void processActionEnemy(int x, int y, GameMap map, String mov){
        GameActions gameActionsPlayerB = new GameActionsPlayerB(playerA,playerB);
        switch (mov){
            case "L":
                playerB.moveLeft(gameActionsPlayerB,x,y,map);
                break;
            case "R":
                playerB.moveRight(gameActionsPlayerB,x,y,map);
                break;
            case "HitL":
                playerB.hitLeft(gameActionsPlayerB,x,y,map);
                break;
            case "HitR":
                playerB.hitRight(gameActionsPlayerB,x,y,map);
                break;
            default:
                break;
        }
    }



}
