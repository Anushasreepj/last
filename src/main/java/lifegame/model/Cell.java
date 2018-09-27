package lifegame.model;

public class Cell {
    public CellStatus evolve() {

        return getCurStatus();
    }

    private CellStatus getCurStatus() {
        return CellStatus.DEAD;
    }
}
