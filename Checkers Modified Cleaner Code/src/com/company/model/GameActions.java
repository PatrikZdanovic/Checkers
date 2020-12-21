package com.company.model;

public interface GameActions {
    void hitLeft(int x, int y,GameMap map);
    void hitRight(int x, int y, GameMap map);
    void moveLeft(int x,int y, GameMap map);
    void moveRight(int x,int y,GameMap map);
}
