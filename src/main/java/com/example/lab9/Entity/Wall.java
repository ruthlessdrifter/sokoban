package com.example.lab9.Entity;



public class Wall extends Element{
    public Wall(Position position) {
        super(position);
        this.entityIcons = EntityIcons.WALL;
    }

    @Override
    boolean pushBy(GameMap map, Element element, Direction dir) {
        return false;
    }

}
