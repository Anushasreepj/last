package lifegame;

import lifegame.model.CellMatrix;

import java.util.List;

public class LifeWorld {

    private final CellMatrix cellMatrix;

    public LifeWorld(String fileName, int generationNum) {
        cellMatrix = CellMatrix.of(fileName);

        for (int i = 0; i < generationNum; i++) {
            cellMatrix.evolveProcess();

            if (i != generationNum - 1) {
                cellMatrix.curToPrevStatus();
            }
        }
    }

    public List<String> getResult() {
        return cellMatrix.makeResult();
    }
}
