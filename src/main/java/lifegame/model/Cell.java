package lifegame.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Cell {
    private static final Logger log = LoggerFactory.getLogger(Cell.class);
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

    static Cell of(char body, int y, int x) {
        return new Cell(body, y, x);
    }

    CellStatus getPrevStatus() {
        return prevStatus;
    }

    int getY() {
        return y;
    }

    int getX() {
        return x;
    }

    boolean isAlive() {
        return prevStatus.equals(CellStatus.ALIVE);
    }

    void alive() {
        log.debug("curStatus를 ALIVE로 변경");
        curStatus = CellStatus.ALIVE;
    }

    boolean isCurAlive() {
        return curStatus.equals(CellStatus.ALIVE);
    }

    void curToPrevStatus() {
        prevStatus = curStatus;
    }

    void dead() {
        curStatus = CellStatus.DEAD;
        log.debug("x:{}, y:{} 가 죽음", x, y);
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
