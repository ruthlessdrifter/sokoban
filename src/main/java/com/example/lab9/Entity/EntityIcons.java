package com.example.lab9.Entity;

import javafx.scene.image.Image;



public enum EntityIcons {
    PLAYER("src/main/resources/com/example/lab9/img/character.png", 100, 100),OBSTACLE("src/main/resources/com/example/lab9/img/obstacle.png", 100, 100),WALL("src/main/resources/com/example/lab9/img/wall.png", 100, 100),EMPTY("src/main/resources/com/example/lab9/img/empty.png", 100, 100),BOX("src/main/resources/com/example/lab9/img/box.png", 100, 100);
    private int width;
    private int height;
    private Image image;

    EntityIcons(String imagePath, int width, int height) {
        this.width = width;
        this.height = height;
        this.image = new Image("file:" + imagePath, width, height, true, true);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }
}

