package com.example.lab9.Entity;


abstract public class Moveable extends Element {
    public Moveable(Position position) {
        super(position);
    }

    void moveTo(Direction dir) {
        position = position.at(dir);
    }

    @Override
    boolean pushBy(GameMap map, Element element, Direction dir) {
        Element nextElement = map.getelement(this.position.at(dir));
        if (nextElement.pushBy(map, this, dir)) {
            this.moveTo(dir);
            return true;
        } else {
            return false;
        }
    }
    public int getPos_x() {
        return position.getX();
    }

    public int getPos_y() {
        return position.getY();
    }

}