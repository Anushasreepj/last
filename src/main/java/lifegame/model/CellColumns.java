package lifegame.model;

import lifegame.utils.FileRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CellColumns {
    private static final Logger log = LoggerFactory.getLogger(CellColumns.class);
    private static final int DIR_SIZE = 8;

    private CellMatrix cellsRows;
    private List<Cell> cells;

    public CellColumns(int column, CellMatrix cellsRows) {
        this.cellsRows = cellsRows;

        for (int i = 0; i < column; i++) {
            cells = new ArrayList<>(Collections.nCopies(column, Cell.of(' ', -1, -1)));
        }
    }

    public CellColumns(String fileName, CellMatrix cellsRows) {
        this.cellsRows = cellsRows;
        List<String> rows = FileRead.readInStream(fileName);
        int colSize = rows.get(0).length();
        cells = new ArrayList<>();

        for (int i = 0; i < colSize; i++) {
            cells.add(i, Cell.of(rows.get(0).charAt(i), 0, i));
        }
    }

    public static CellColumns of(int column, CellMatrix cellsRows) {
        return new CellColumns(column, cellsRows);
    }

    public int size() {
        return cells.size();
    }

    public Cell putCell(Cell cell) {
        // TODO 데메테르 위반, 혹시 객체로 빼면 과도한 추상화가 되지 않을까?
        return cells.set(cell.getX(), cell);
    }

    public CellStatus checkStatus(int x) {
        return cells.get(x).getPrevStatus();
    }

    public boolean evolveProcess() {
        for (Cell curCell : cells) {
            if (!curCell.isAlive()) {
                continue;
            }

            // TODO 처리안함
            if (checkAround(curCell)) {
                curCell.alive();
                log.debug("ALIVE : {}", curCell);
            }
        }

        return true;
    }

    // TODO 리팩토링 필요
    private boolean checkAround(Cell curCell) {
        int[][] direction = {{-1, 0}, {-1, -1}, {0, -1}, {+1, -1}, {+1, 0}, {+1, +1}, {0, +1}, {-1, +1}};
        int x = curCell.getX();
        int y = curCell.getY();

        int count = 0;

        for (int i = 0; i < DIR_SIZE; i++) {
            if (cellsRows.isAlive(y + direction[i][0], x + direction[i][1])) {
                count++;
            }
        }

        if (count > 1 && count < 4) {
            return true;
        }

        return false;
    }

    public boolean isAlive(int x) {
        return cells.get(x).isAlive();
    }

    public boolean isCurAlive(int i) {
        return cells.get(i).isCurAlive();
    }

    @Override
    public String toString() {
        return "CellColumns{" +
                "cells=" + cells +
                '}';
    }
}
