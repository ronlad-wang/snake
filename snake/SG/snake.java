package snake.SG;

import snake.InputSource.KeyboardInputSource;
import snake.queue.queue;

import java.util.Random;

public class snake {
    public int x;
    public int y;
    public int snakeSize = 9;
    public int MAP_MAX_SIZE = 10;
    public KeyboardInputSource src;


    public snake(KeyboardInputSource kis) {
        Random rand = new Random();
        x = rand.nextInt(0, MAP_MAX_SIZE);
        y = rand.nextInt(0, MAP_MAX_SIZE);
        src = kis;

        System.out.println(x + ", " + y);
    }

    public int[] getLocation() {
        return new int[]{x, y};
    }

    public int[] move() {
        char c = src.getNextKey();
        switch(c) {
            case 'W':
                if(y == MAP_MAX_SIZE-1) {
                    return new int[]{-1, -1};
                }
                y += 1;
                break;
            case 'A':
                if(x == 0) {
                    return new int[]{-1, -1};
                }
                x -= 1;
                break;
            case 'S':
                if(y == 0) {
                    return new int[]{-1, -1};
                }
                y -= 1;
                break;
            case 'D':
                if(x == MAP_MAX_SIZE-1) {
                    return new int[]{-1, -1};
                }
                x += 1;
                break;
        }
        return new int[]{x ,y};
    }
}
