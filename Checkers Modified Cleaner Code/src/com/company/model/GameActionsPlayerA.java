package com.company.model;

public class GameActionsPlayerA implements GameActions{

    private PlayerA playerA;
    private PlayerB playerB;

    public GameActionsPlayerA(PlayerA playerA, PlayerB playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    @Override
    public void hitLeft(int x, int y, GameMap map) {
        Checkers checker = playerA.findChecker(x, y);
        if(map.isHittableLeft(x+1,y-1,true)){
            Checkers enemyChecker = playerB.findChecker(x+1,y-1);
            playerB.getCheckers().remove(enemyChecker);
            playerB.reduceCheckers();
            checker.setY(y-2);
            checker.setX(x+2);
            System.out.println("MoveComplete");

        }
        else{
            System.out.println("You Cannot Move There");
        }
    }

    @Override
    public void hitRight(int x, int y, GameMap map) {
        Checkers checker = playerA.findChecker(x, y);
        if(map.isHittableRight(x+1,y+1,true)){
            Checkers enemyChecker = playerB.findChecker(x+1,y+1);
            System.out.println(enemyChecker);
            playerB.getCheckers().remove(enemyChecker);
            playerB.reduceCheckers();
            checker.setY(y+2);
            checker.setX(x+2);
            System.out.println("MoveComplete");
        }
        else{
            System.out.println("You Cannot Move There");
        }
    }

    @Override
    public void moveLeft(int x, int y, GameMap map) {
        Checkers checker = playerA.findChecker(x, y);
        if(map.isAvailable(x+1,y-1)){
            checker.setY(y-1);
            checker.setX(x+1);
            System.out.println("MoveComplete");
        }
        else{
            System.out.println("You Cannot Move There");
        }
    }

    @Override
    public void moveRight(int x, int y, GameMap map) {
        Checkers checker = playerA.findChecker(x, y);
        if(map.isAvailable(x+1,y+1)){
            try {
                checker.setY(y+1);
                checker.setX(x+1);
                System.out.println("MoveComplete");
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else{
            System.out.println("You Cannot Move There");
        }
    }
}
