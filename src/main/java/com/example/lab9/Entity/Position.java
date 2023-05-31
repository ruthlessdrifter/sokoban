package com.example.lab9.Entity;

public class Position {
    public static Position UP = new Position(0, -1);
    public static Position DOWN = new Position(0, 1);
    public static Position LEFT = new Position(-1, 0);
    public static Position RIGHT = new Position(1, 0);

    private int x, y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position at(Direction dir) {
        Position move = null;
        switch (dir) {
            case up:
                move = UP;
                break;
            case down:
                move = DOWN;
                break;
            case left:
                move = LEFT;
                break;
            case right:
                move = RIGHT;
                break;
        }
        return new Position(x + move.x, y + move.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position p = (Position) obj;
            return p.x == this.x && p.y == this.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Position [x=" + x + ", y=" + y + "]";
    }
}
