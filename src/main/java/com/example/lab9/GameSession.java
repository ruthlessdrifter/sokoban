package com.example.lab9;

import com.example.lab9.Entity.Direction;
import com.example.lab9.Entity.GameMap;

public class GameSession {
    private String playerName;

    private GameMap map;
    private int totalMovements = 0;
    private int invalidMovements = 0;

    public GameSession(String playerName, GameMap map) {
        this.playerName = playerName;
        this.map = map;
    }

    public int getTotalMovements() {
        return totalMovements;
    }

    public int getInvalidMovements() {
        return invalidMovements;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void move(Direction dir) {
        if (isFinished())
            throw new RuntimeException("can't run finished session");
        System.out.println("player " + playerName + ", move dir:" + dir);
        MoveResult result = map.moveGameBoy(dir);
        totalMovements++;
        if (!((MoveResult) result).isMoveSuccess())
            invalidMovements++;
    }

    public boolean isFinished() {
        return map.isFinished();
    }

    @Override
    public String toString() {
        return "GameSession [playerName=" + playerName + ", totalMovement=" + totalMovements + ", invalidMovement="
                + invalidMovements + ", isFinished=" + isFinished() + "]";
    }
}