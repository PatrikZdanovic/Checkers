package com.company.model;

import java.util.ArrayList;

public class LoadDefaultBoard {
    ArrayList<Checkers>defPlayerA = new ArrayList<>();
    ArrayList<Checkers>defPlayerB = new ArrayList<>();
    public LoadDefaultBoard() {
    }

    public ArrayList<Checkers> getPlayerA(){
        defPlayerA.add(new Checkers(1,2,1));
        defPlayerA.add(new Checkers(1,4,1));
        defPlayerA.add(new Checkers(1,6,1));
        defPlayerA.add(new Checkers(1,8,1));
        defPlayerA.add(new Checkers(2,1,1));
        defPlayerA.add(new Checkers(2,3,1));
        defPlayerA.add(new Checkers(2,5,1));
        defPlayerA.add(new Checkers(2,7,1));
        defPlayerA.add(new Checkers(3,2,1));
        defPlayerA.add(new Checkers(3,4,1));
        defPlayerA.add(new Checkers(3,6,1));
        defPlayerA.add(new Checkers(3,8,1));
        return defPlayerA;
    }
    public ArrayList<Checkers> getPlayerB(){
        defPlayerB.add(new Checkers(8,1,-1));
        defPlayerB.add(new Checkers(8,3,-1));
        defPlayerB.add(new Checkers(8,5,-1));
        defPlayerB.add(new Checkers(8,7,-1));
        defPlayerB.add(new Checkers(7,2,-1));
        defPlayerB.add(new Checkers(7,4,-1));
        defPlayerB.add(new Checkers(7,6,-1));
        defPlayerB.add(new Checkers(7,8,-1));
        defPlayerB.add(new Checkers(6,1,-1));
        defPlayerB.add(new Checkers(6,3,-1));
        defPlayerB.add(new Checkers(6,5,-1));
        defPlayerB.add(new Checkers(6,7,-1));
        return defPlayerB;
    }

}
