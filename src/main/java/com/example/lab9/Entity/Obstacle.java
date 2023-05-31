package com.example.lab9.Entity;

public class Obstacle extends Element {

    public Obstacle(Position position) {
        super(position);
        this.entityIcons = EntityIcons.OBSTACLE;
    }

    @Override
    boolean pushBy(GameMap map, Element element, Direction dir) {
        if (element instanceof Box) {
            return false;
        } else
            return true;
    }
}
