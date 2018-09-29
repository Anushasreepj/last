package lifegame;

import lifegame.model.CellMatrix;

import java.util.List;

class LifeWorld {

    private final CellMatrix cellMatrix;

    LifeWorld(String fileName, int generationNum) {
        cellMatrix = CellMatrix.of(fileName);

        for (int i = 0; i < generationNum; i++) {
            cellMatrix.evolveProcess();

            if (i == generationNum - 1) {
                break;
            }

            cellMatrix.curToPrevStatus();
        }
    }

    List<String> getResult() {
        return cellMatrix.makeResult();
    }
}
