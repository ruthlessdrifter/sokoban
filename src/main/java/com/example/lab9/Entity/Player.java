package com.example.lab9.Entity;


public class Player extends Moveable{


    public Player(Position position) {
        super(position);
        this.position=position;
        this.entityIcons = EntityIcons.PLAYER;
    }



}
