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
    private static final int INITIAL_VALUE = -1;
    private static final int FIRST_LINE = 0;
    private static final int NEW_ALIVE_NUM = 3;
    private static final int OVER_NUM = 4;
    private static final int LOW_NUM = 1;

    private CellMatrix cellsRows;
    private List<Cell> cells;

    private CellColumns(int column, CellMatrix cellsRows) {
        this.cellsRows = cellsRows;

        for (int i = 0; i < column; i++) {
            cells = new ArrayList<>(Collections.nCopies(column, Cell.of(' ', INITIAL_VALUE, -1)));
        }
    }

    CellColumns(String fileName, CellMatrix cellsRows) {
        this.cellsRows = cellsRows;
        List<String> rows = FileRead.readInStream(fileName);
        int colSize = rows.get(FIRST_LINE).length();
        cells = new ArrayList<>();

        for (int i = 0; i < colSize; i++) {
            cells.add(i, Cell.of(rows.get(FIRST_LINE).charAt(i), 0, i));
        }
    }

    static CellColumns of(int column, CellMatrix cellsRows) {
        return new CellColumns(column, cellsRows);
    }

    int size() {
        return cells.size();
    }

    Cell putCell(Cell cell) {
        return cells.set(cell.getX(), cell);
    }

    CellStatus checkStatus(int x) {
        return cells.get(x).getPrevStatus();
    }

    void evolveProcess() {
        for (Cell curCell : cells) {
            if (!curCell.isAlive()) {
                newAliveProcess(curCell);

                continue;
            }

            remainProcess(curCell);
        }
    }

    private int checkAround(Cell curCell) {
        int[][] direction = {{-1, 0}, {-1, -1}, {0, -1}, {+1, -1}, {+1, 0}, {+1, +1}, {0, +1}, {-1, +1}};
        int x = curCell.getX();
        int y = curCell.getY();

        int count = 0;

        for (int i = 0; i < DIR_SIZE; i++) {
            if (cellsRows.isAlive(y + direction[i][0], x + direction[i][1])) {
                count++;
            }
        }
        return count;
    }

    private void newAliveProcess(Cell curCell) {
        int count = checkAround(curCell);

        if (count == NEW_ALIVE_NUM) {
            curCell.alive();
            log.debug("New ALIVE : {}", curCell);
        }
    }

    private void remainProcess(Cell curCell) {
        if (checkAroundRemain(curCell)) {
            curCell.alive();
            log.debug("Still ALIVE : {}", curCell);
            return;
        }

        curCell.dead();
    }

    private boolean checkAroundRemain(Cell curCell) {
        int count = checkAround(curCell);

        return count > LOW_NUM && count < OVER_NUM;
    }

    boolean isAlive(int x) {
        return cells.get(x).isAlive();
    }

    boolean isCurAlive(int i) {
        return cells.get(i).isCurAlive();
    }

    String transToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Cell cell : cells) {
            if (cell.isCurAlive()) {
                stringBuilder.append('O');
                continue;
            }
            stringBuilder.append('.');
        }

        return stringBuilder.toString();
    }

    // TODO 메서드명 같아도 되나?
    void curToPrevStatus() {
        for (Cell cell : cells) {
            cell.curToPrevStatus();
        }
    }

    @Override
    public String toString() {
        return "CellColumns{" +
                "cells=" + cells +
                '}';
    }
}
