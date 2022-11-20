package snake.SG;
import snake.InputSource.KeyboardInputSource;
import snake.TileEngine.*;
import snake.queue.queue;

public class Main {
    public static queue snakeLocations = new queue();
    public static void main(String[] arg) {

        //Sets up all necessaries objects, also sets all tiles in the worldMap to floor tiles
        TETile[][] worldMap = new TETile[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                worldMap[i][j] = Tileset.FLOOR;
            }
        }
        TERenderer rend = new TERenderer();
        KeyboardInputSource keyboardsrc = new KeyboardInputSource();
        snake s = new snake(keyboardsrc);

        //initializing snake sets its original location, then we set that location to a tile representing
        //the snake
        int[] snakeLocation = s.getLocation();
        snakeLocations.add(snakeLocation);
        worldMap[snakeLocation[0]][snakeLocation[1]] = Tileset.AVATAR;

        //sets up world map
        rend.initialize(20, 20, 5, 5);
        rend.renderFrame(worldMap);


        //temporary code to test how the snake moves
        while(true) {
            int[] newLocation = s.move();
            if(newLocation[0] == -1) {
                //if the location array has a -1 it means that the player hit a wall, in which case
                //we enter a fail state that stops the program
                failState();
                break;
            }

            TETile temp = worldMap[newLocation[0]][newLocation[1]];
            if(temp.equals(Tileset.AVATAR)) {
                //If the new location is already occupied by an Avatar tile, then it means that
                //the snake has collided with itself
                failState();
                break;
            }

            System.out.println(newLocation[0] + ", " + newLocation[1]);
            snakeLocations.add(newLocation);
            if(s.snakeSize < snakeLocations.size()) {
                int[] removedLocation = (int[]) snakeLocations.remove();
                worldMap[removedLocation[0]][removedLocation[1]] = Tileset.FLOOR;
            }

            worldMap[newLocation[0]][newLocation[1]] = Tileset.AVATAR;
            rend.renderFrame(worldMap);
        }
    }

    public static void failState() {
        System.out.print("failState Detected");
    }
}
