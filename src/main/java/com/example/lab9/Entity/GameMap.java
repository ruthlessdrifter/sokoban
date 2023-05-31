package com.example.lab9.Entity;


import com.example.lab9.MoveResult;

import java.util.ArrayList;
        import java.util.List;

public class GameMap {
    private List<Element[]> map = new ArrayList<>();
    private ArrayList<Box> boxes;
    private Position finalPosition;
    private Player player;

    public Element getelement(Position position){
        for (Box box:boxes) {
            if(box.getPosition().equals(position)==true){
                return box;
            }
        }
        return  map.get(position.getY())[position.getX()];
    }
    public GameMap(List<Element[]> map, Position finalPosition, Player player, ArrayList<Box> boxes) {
        this.map=map;
        this.finalPosition = finalPosition;
        this.player = player;
        this.boxes = boxes;
    }

    public List<Element[]> getMap() {
        return map;
    }

    public MoveResult moveGameBoy(Direction dir) {
        boolean result = player.pushBy(this, null, dir);
        if (isFinished())
            return new MoveResult(result, true);
        else
            return new MoveResult(result, false);
    }

    public boolean isFinished() {
        for (Box box:boxes) {
            if(box.getPosition().equals(finalPosition)==false){
                return false;
            }
        }
        return true ;
    }
}
