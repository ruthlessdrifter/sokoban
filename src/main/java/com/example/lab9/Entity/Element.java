package com.example.lab9.Entity;


public abstract class Element {
    Position position;
    EntityIcons entityIcons;
    public EntityIcons getEntityIcons() {
        return entityIcons;
    }
    public Position getPosition() {
        return position;
    }
    @Override
    public String toString() {
        return this.getClass().toString();
    }
    public Element(Position position) {
        this.position = position;
    }
    public Element() {
    }
    /**
     *
     * 某种元素被element沿着dir推动时候的反应。
     *
     * @param map     地图
     * @param element 推动的直接发起方。对于GameBoy，没有东西直接推他，推动的发起方为Null。
     * @param dir     推动的方向
     * @return 如果被成功推动，返回true，否则返回false。
     */
    abstract boolean pushBy(GameMap map, Element element, Direction dir);
}









