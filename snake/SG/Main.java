package snake.SG;
import snake.InputSource.KeyboardInputSource;
import snake.TileEngine.*;
import snake.queue.queue;
import java.util.Random;

public class Main {
    public static queue snakeLocations = new queue();
    public static TETile[][] worldMap;
    public static int MAX_MAP_SIZE = 10;
    public static snake s;
    public static Random rand = new Random();
    public static int numApples = 0;
    public static void main(String[] arg) {

        //Sets up all necessaries objects, also sets all tiles in the worldMap to floor tiles
        worldMap = new TETile[MAX_MAP_SIZE][MAX_MAP_SIZE];
        for(int i = 0; i < MAX_MAP_SIZE; i++) {
            for(int j = 0; j < MAX_MAP_SIZE; j++) {
                worldMap[i][j] = Tileset.FLOOR;
            }
        }
        TERenderer rend = new TERenderer();
        KeyboardInputSource keyboardsrc = new KeyboardInputSource();
        s = new snake(keyboardsrc);

        //initializing snake sets its original location, then we set that location to a tile representing
        //the snake
        int[] snakeLocation = s.getLocation();
        snakeLocations.add(snakeLocation);
        worldMap[snakeLocation[0]][snakeLocation[1]] = Tileset.AVATAR;

        //sets up world map
        rend.initialize(MAX_MAP_SIZE + 10, MAX_MAP_SIZE + 10, 5, 5);
        rend.renderFrame(worldMap);


        //temporary code to test how the snake moves
        while(true) {
            generateApple();
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
            if(temp.equals(Tileset.FLOWER)) {
                numApples -= 1;
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

    public static void generateApple() {
        //randomly places an apple in an unoccupied spot in the worldmap
        int numPossibleTiles = (MAX_MAP_SIZE * MAX_MAP_SIZE) - s.snakeSize - numApples;

        if(numPossibleTiles == 0) {
            //if there are no more possible tiles it means that the snake is literally the size of the
            //map
            winState();
            return;
        }

        //randomly choose a tile that is not occupied on the worldmap
        int chosenTile = rand.nextInt(1, numPossibleTiles + 1);
        appleHelper(chosenTile);
    }
    public static void appleHelper(int tile) {
        for(int i = 0; i < MAX_MAP_SIZE; i++) {
            for(int j = 0; j < MAX_MAP_SIZE; j++) {
                if(worldMap[i][j] == Tileset.FLOOR) {
                    tile -= 1;
                }
                if(tile == 0) {
                    System.out.println(" apple generated ");
                    numApples += 1;
                    worldMap[i][j] = Tileset.FLOWER;
                    return;
                }
            }
        }
        System.out.println(" apple generation failed ");
    }

    public static void failState() {
        System.out.print("failState Detected");
    }
    public static void winState() {
        System.out.println("touch grass");
    }


}
