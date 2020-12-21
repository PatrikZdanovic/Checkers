package com.company.model;

import java.util.ArrayList;

public class GameMap {
    private int [][] model = new int[][]{
            {7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
    };
    private int[][] cleanModel = new int[][]{
            {7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
    };


    public boolean isHittableLeft(int x, int y, boolean turn){
        if (turn && model[x][y]==-1 && model[x+1][y-1]==0){
            return true;
        }
        else return !turn && model[x][y] == 1 && model[x-1][y-1]==0;
    }
    public boolean isHittableRight(int x, int y, boolean turn){
        if (turn && model[x][y]==-1 && model[x+1][y+2]==0){
            return true;
        }
        else return !turn && model[x][y] == 1 && model[x-1][y+2]==0;
    }
    public boolean isAvailable(int x, int y){
        return model[x][y] == 0;
    }

    public void updateMap(ArrayList<Checkers> checkers, ArrayList<Checkers> checkers2){

        for (Checkers a: checkers){
            model[a.getX()][a.getY()]=a.getValue();
        }
        for (Checkers b: checkers2){
            model[b.getX()][b.getY()]=b.getValue();
        }
    }

    public void draw(boolean turn) {
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                System.out.print("   ");
            } else {
                System.out.printf("%3d", i);
            }
        }
        System.out.println("\n" + "     ----------------------");
        for (int i = 1; i < model.length-1; i++) {
            if (turn) {
                System.out.printf("%2d", i);
            } else {
                System.out.printf("%2d", model.length - i-1);
            }
            System.out.print("|");
            for (int j = 1; j < model.length-1; j++) {
                System.out.printf("%3d", model[i][j]);
            }
            System.out.println();
        }
    }
}
