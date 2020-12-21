package com.company.model;

import java.util.ArrayList;

public class PlayerA extends Player {
    boolean status;

    public PlayerA(int checkersLeft, ArrayList<Checkers> checkers, boolean status) {
        super(checkersLeft, checkers);
        this.status = status;
    }


}
