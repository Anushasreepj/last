package lifegame.model;

public class Cell {
    private CellStatus prevStatus = CellStatus.DEAD;
    private CellStatus curStatus = CellStatus.DEAD;
    //    private char body;
    private int x;
    private int y;

    public Cell() {
    }

    public Cell(char body, int y, int x) {
        if (body == 'O') {
            prevStatus = CellStatus.ALIVE;
        }

        this.x = x;
        this.y = y;
    }

    public static Cell of() {
        return new Cell();
    }

    public static Cell of(char body, int y, int x) {
        return new Cell(body, y, x);
    }

    // TODO 8dir check & change status
    public CellStatus evolve(CellMatrix cellMatrix) {
        return getCurStatus();
    }

    public CellStatus getCurStatus() {
        return curStatus;
    }

    public CellStatus getPrevStatus() {
        return prevStatus;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "prevStatus=" + prevStatus +
                ", curStatus=" + curStatus +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
