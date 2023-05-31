package com.example.lab9;

import com.example.lab9.Entity.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class Controller {
    private static GameMap map;

    private static Player player;
    private static ArrayList<Box> boxes=new ArrayList<>();

    public static void readMap(String path) {
        List<Element[]> initialmap = new ArrayList<>();
        Position finalPosition = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String str;
            int y_axis = 0;
            while ((str = in.readLine()) != null) {
                String[] row = str.split(" ");
                Element[] elements = new Element[row.length];
                for (int x_axis = 0; x_axis < row.length; x_axis++) {
                    int type = Integer.parseInt(row[x_axis]);
                    switch (type) {
                        case 0:  // 空地
                            elements[x_axis] = new Empty(new Position(x_axis,y_axis));
                            break;
                        case 1:  // 墙壁
                            elements[x_axis] = new Wall(new Position(x_axis,y_axis));
                            break;
                        case 2:  // 玩家
                            player = new Player(new Position(x_axis,y_axis));  // 创建玩家并记录其位置
                            elements[x_axis] = new Empty(new Position(x_axis,y_axis));
                            break;
                        case 3:  // end
                            finalPosition=new Position(x_axis,y_axis);
                            elements[x_axis] = new Empty(new Position(x_axis,y_axis));
                            break;
                        case 4:  // obstacle
                            elements[x_axis] = new Obstacle(new Position(x_axis,y_axis));
                            break;
                        case 5:
                            Box box = new Box(new Position(x_axis,y_axis));
                            elements[x_axis] = new Empty(new Position(x_axis,y_axis));
                            boxes.add(box);
                            break;
                    }
                }
                initialmap.add(elements);
                y_axis++;
            }
        map=new GameMap(initialmap,finalPosition,player,boxes);
        } catch (IOException e){
                e.printStackTrace();
        }
    }


    public static void drawMap(GraphicsContext gc) {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        for (int y = 0; y < map.getMap().size(); y++) {
            Element[] row = map.getMap().get(y);
            for (int x = 0; x < row.length; x++) {
                Element element = row[x];
                Image image = element.getEntityIcons().getImage();
                gc.drawImage(image, x*element.getEntityIcons().getWidth(), y * element.getEntityIcons().getHeight());
            }
        }
        Image playerImage = player.getEntityIcons().getImage();
        gc.drawImage(playerImage, player.getPos_x()*player.getEntityIcons().getWidth(), player.getPos_y() * player.getEntityIcons().getHeight());
        for (Box box:boxes) {
            gc.drawImage(box.getEntityIcons().getImage(), box.getPos_x()*box.getEntityIcons().getWidth(), box.getPos_y() * box.getEntityIcons().getHeight());
        }
    }

    public static boolean click (int x, int y){
        int dx=player.getPos_x()-x;
        int dy=player.getPos_y()-y;
        if (Math.abs(dy)+Math.abs(dx)==1) {
            if(dy==1&&dx==0){
                map.moveGameBoy(Direction.up);
            }
            if(dy==-1&&dx==0){
                map.moveGameBoy(Direction.down);
            }
            if(dy==0&&dx==1){
                map.moveGameBoy(Direction.left);
            }
            if(dy==0&&dx==-1){
                map.moveGameBoy(Direction.right);
            }
            return true;
       }
        return false;
    }

}