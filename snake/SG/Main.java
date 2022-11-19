package snake.SG;
import snake.InputSource.KeyboardInputSource;
import snake.TileEngine.*;

public class Main {
    public static int[] snakeLocation;
    public static void main(String[] arg) {
        TETile[][] worldMap = new TETile[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                worldMap[i][j] = Tileset.FLOOR;
            }
        }
        TERenderer rend = new TERenderer();
        KeyboardInputSource keyboardsrc = new KeyboardInputSource();
        snake s = new snake(keyboardsrc);

        snakeLocation = s.getLocation();
        worldMap[snakeLocation[0]][snakeLocation[1]] = Tileset.AVATAR;

        rend.initialize(20, 20, 5, 5);
        rend.renderFrame(worldMap);



        while(true) {
            int[] newLocation = s.move();
            System.out.println(newLocation[0] + ", " + newLocation[1]);
            worldMap[snakeLocation[0]][snakeLocation[1]] = Tileset.FLOOR;
            worldMap[newLocation[0]][newLocation[1]] = Tileset.AVATAR;
            snakeLocation = newLocation;
            rend.renderFrame(worldMap);
        }
    }
}
