package com.company.model;

public class GameActionsPlayerB implements GameActions{
    private PlayerA playerA;
    private PlayerB playerB;

    public GameActionsPlayerB(PlayerA playerA, PlayerB playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }
    @Override
    public void hitLeft(int x, int y, GameMap map) {
        x=(x-9)*(-1);
        Checkers checker = playerB.findChecker(x, y);
        if(map.isHittableLeft(x-1,y-1,false)){
            Checkers enemyChecker = playerA.findChecker(x-1,y-1);
            playerA.getCheckers().remove(enemyChecker);
            playerA.reduceCheckers();
            checker.setY(y-2);
            checker.setX(x-2);
            System.out.println("MoveComplete");
        }
        else{
            System.out.println("You Cannot Move There");
        }
    }

    @Override
    public void hitRight(int x, int y, GameMap map) {
        x=(x-9)*(-1);
        Checkers checker = playerB.findChecker(x, y);
        if(map.isHittableLeft(x-1,y+1,false)){
            Checkers enemyChecker = playerA.findChecker(x-1,y+1);
            playerA.getCheckers().remove(enemyChecker);
            playerA.reduceCheckers();
            checker.setY(y+2);
            checker.setX(x-2);
            System.out.println("MoveComplete");
        }
        else{
            System.out.println("You Cannot Move There");
        }
    }

    @Override
    public void moveLeft(int x, int y, GameMap map) {
        x=(x-9)*(-1);
        Checkers checker = playerB.findChecker(x, y);
        if(map.isAvailable(x-1,y-1)){
            checker.setX(x-1);
            checker.setY(y-1);
            System.out.println("MoveComplete");
        }
        else{
            System.out.println("You Cannot Move There");
        }
    }

    @Override
    public void moveRight(int x, int y, GameMap map) {
        x=(x-9)*(-1);
        Checkers checker = playerB.findChecker(x, y);
        if(map.isAvailable(x-1,y+1)){
            checker.setX(x-1);
            checker.setY(y+1);
            System.out.println("MoveComplete");
        }
        else{
            System.out.println("You Cannot Move There");
        }
    }
}
