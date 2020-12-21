package com.company.model;

public class Checkers {
    private int y;
    private int x;
    private int value;

    public Checkers(int x, int y, int value) {
        this.y = y;
        this.x = x;
        this.value = value;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }



    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Checkers)) {
            return false;
        }
        Checkers other = (Checkers) o;
        return x==other.getX() && y==other.getY();
    }

    @Override
    public String toString() {
        return "Checkers{" +
                "y=" + y +
                ", x=" + x +
                ", value=" + value +
                '}';
    }


}
