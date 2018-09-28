package lifegame.model;

import java.util.Objects;

public class Cell {
    private CellStatus prevStatus = CellStatus.DEAD;
    private CellStatus curStatus = CellStatus.DEAD;
    private int x;
    private int y;

    private Cell(char body, int y, int x) {
        if (body == 'O') {
            prevStatus = CellStatus.ALIVE;
        }

        this.x = x;
        this.y = y;
    }

    public static Cell of(char body, int y, int x) {
        return new Cell(body, y, x);
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

    public boolean isAlive() {
        return prevStatus.equals(CellStatus.ALIVE);
    }

    public void alive() {
        curStatus = CellStatus.ALIVE;
    }

    public boolean isCurAlive() {
        return curStatus.equals(CellStatus.ALIVE);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y &&
                prevStatus == cell.prevStatus &&
                curStatus == cell.curStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prevStatus, curStatus, x, y);
    }
}
