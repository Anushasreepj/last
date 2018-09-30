package lifegame;

import lifegame.model.Cell;

public enum Direction {
    LL(-1, 0),
    LU(-1, -1),
    UU(0, -1),
    RU(1, -1),
    RR(1, 0),
    RD(1, 1),
    DD(0, 1),
    LD(-1, 1);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int moveX(Cell cell) {
        return this.x + cell.getX();
    }

    public int moveY(Cell cell) {
        return this.y + cell.getY();
    }
}
