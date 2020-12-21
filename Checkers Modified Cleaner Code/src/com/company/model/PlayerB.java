package com.company.model;

import java.util.ArrayList;

public class PlayerB extends Player{
    boolean status;

    public PlayerB(int checkersLeft, ArrayList<Checkers> checkers, boolean status) {
        super(checkersLeft, checkers);
        this.status = status;
    }
}
