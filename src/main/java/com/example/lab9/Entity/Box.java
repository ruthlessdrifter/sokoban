package com.example.lab9.Entity;

public class Box extends Moveable {

    public Box(Position position) {
        super(position);
        this.entityIcons = EntityIcons.BOX;
    }

    @Override
    boolean pushBy(GameMap map, Element element, Direction dir) {
        if (element instanceof Box)
            return false; // 只能推动一个箱子
        return super.pushBy(map, element, dir);
    }

}
