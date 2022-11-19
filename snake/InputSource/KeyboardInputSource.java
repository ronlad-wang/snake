package snake.InputSource;

import snake.libraries.StdDraw;

import java.io.Serializable;

/**
 * Created by hug.
 */
public class KeyboardInputSource implements InputSource, Serializable {
    private static final boolean PRINT_TYPED_KEYS = true;
    public KeyboardInputSource() {
        StdDraw.text(0.3, 0.3, "press m to moo, q to quit");
    }


    public char getNextKey() {
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char c = Character.toUpperCase(StdDraw.nextKeyTyped());
                if (PRINT_TYPED_KEYS) {
                    System.out.print(c);
                }
                return c;
            }
        }
    }

    public boolean possibleNextInput() {
        return true;
    }
}

