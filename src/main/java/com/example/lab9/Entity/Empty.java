package com.example.lab9.Entity;



public class Empty extends Element{
    public Empty(Position position) {
        this.position=position;
        this.entityIcons = EntityIcons.EMPTY;
    }
    boolean pushBy(GameMap map, Element element, Direction dir) {
        return true;
    }

}
