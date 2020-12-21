package com.company.model;

import java.util.ArrayList;

public class Player {
    private int checkersLeft;
    private ArrayList<Checkers> checkers;

    public Player(int checkersLeft, ArrayList<Checkers> checkers) {
        this.checkersLeft = checkersLeft;
        this.checkers = checkers;
    }

    public int getCheckersLeft() {
        return checkersLeft;
    }

    public void setCheckersLeft(int checkersLeft) {
        this.checkersLeft = checkersLeft;
    }

    public ArrayList<Checkers> getCheckers() {
        return checkers;
    }

    public void setCheckers(ArrayList<Checkers> checkers) {
        this.checkers = checkers;
    }
    public Checkers findChecker(int x, int y){
        int index=0;
        for (Checkers checker: checkers){
            if(checker.getX()==x && checker.getY()==y){
                return checkers.get(index);
            }
            index++;
        }
        return null;
    }
    public void getCheckerList(){
        for (Checkers check:checkers){
            System.out.println(check.getX()+"  "+check.getY());
        }
    }

    public void reduceCheckers(){
        this.checkersLeft--;
    }
    public void hitLeft(GameActions gameActions, int x, int y, GameMap map){
        gameActions.hitLeft(x,y,map);
    }
    public void hitRight(GameActions gameActions, int x, int y, GameMap map){
        gameActions.hitRight(x,y,map);
    }
    public void moveLeft(GameActions gameActions, int x, int y, GameMap map){
        gameActions.moveLeft(x,y,map);
    }
    public void moveRight(GameActions gameActions, int x, int y, GameMap map){
        gameActions.moveRight(x,y,map);
    }

}
