package lifegame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CellColumns {
    private List<Cell> cells;

    public CellColumns(int column) {
        for (int i = 0; i < column; i++) {
            cells = new ArrayList<>(Collections.nCopies(column, Cell.of(' ', 0, 0)));
        }
    }

    public static CellColumns of(int column) {
        return new CellColumns(column);
    }

    public int size() {
        return cells.size();
    }

    public Cell putCell(Cell cell) {
        return cells.set(cell.getX(), cell);
    }

    @Override
    public String toString() {
        return "CellColumns{" +
                "cells=" + cells +
                '}';
    }

    public CellStatus checkStatus(int x) {
        return cells.get(x).getPrevStatus();
    }
}
