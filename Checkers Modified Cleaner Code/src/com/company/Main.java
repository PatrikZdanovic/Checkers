package com.company;

import com.company.model.*;


public class Main {

    public static void main(String[] args) {
        LoadDefaultBoard loadDefaultBoard = new LoadDefaultBoard();
        PlayerA playerA = new PlayerA(12,loadDefaultBoard.getPlayerA(),true);
        PlayerB playerB = new PlayerB(12,loadDefaultBoard.getPlayerB(),false);

        GamePlay gamePlay = new GamePlay(playerA,playerB);
        boolean turn = true;
        while (!gamePlay.GameOver()){
            gamePlay.processInput(turn);
            turn=!turn;
        }

    }
}
