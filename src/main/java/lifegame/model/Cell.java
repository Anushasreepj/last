package lifegame.model;

public class Cell {
    private CellStatus prevStatus;
    private CellStatus curStatus;

    public Cell() {
        prevStatus = CellStatus.DEAD;
        curStatus = CellStatus.DEAD;
    }

    public CellStatus evolve() {
        return getCurStatus();
    }

    private CellStatus getCurStatus() {
        return curStatus;
    }

    public CellStatus getPrevStatus() {
        return prevStatus;
    }
}
