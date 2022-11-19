package snake.SG;
import snake.InputSource.KeyboardInputSource;
import snake.TileEngine.*;

public class Main {
    public static void main(String[] arg) {
        TETile[][] worldMap = new TETile[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                worldMap[i][j] = Tileset.FLOOR;
            }
        }
        TERenderer rend = new TERenderer();
        rend.initialize(20, 20, 5, 5);
        rend.renderFrame(worldMap);

        KeyboardInputSource keyboardsrc = new KeyboardInputSource();


        while(true) {
            keyboardsrc.getNextKey();
        }
    }
}
