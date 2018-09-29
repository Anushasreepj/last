package lifegame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LifeWorld world = new LifeWorld("cross.txt", 5);
        world.getResult().forEach(log::info);
    }
}
