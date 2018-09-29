package lifegame;

import lifegame.model.CellMatrix;
import lifegame.model.Generation;

import java.util.List;

class LifeWorld {
    private final CellMatrix cellMatrix;

    LifeWorld(String fileName, int num) {
        Generation generation = Generation.of(num);
        cellMatrix = CellMatrix.of(fileName);

        for (int i = 0; i < generation.getNum(); i++) {
            cellMatrix.evolveProcess();

            if (generation.checkLastGeneration(i)) {
                break;
            }

            cellMatrix.curToPrevStatus();
        }
    }

    List<String> getResult() {
        return cellMatrix.makeResult();
    }
}
