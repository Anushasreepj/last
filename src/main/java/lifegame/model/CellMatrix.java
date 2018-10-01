package lifegame.model;

import lifegame.utils.FileRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CellMatrix {
    private static final Logger log = LoggerFactory.getLogger(CellMatrix.class);
    private List<CellColumns> cellsRows = new ArrayList<>();

    private CellMatrix(int row, int column) {
        for (int i = 0; i < row; i++) {
            cellsRows.add(CellColumns.of(column, this));
        }
    }

    public static CellMatrix of(String fileName) {
        List<String> rows = FileRead.readInStream(fileName);
        int rowSize = rows.size();
        int colSize = rows.get(0).length();

        CellMatrix cellMatrix = new CellMatrix(rowSize, colSize);

        for (int i = 0; i < rowSize; i++) {
            CellColumns cellColumns = cellMatrix.getRow(i);
            for (int j = 0; j < colSize; j++) {
                cellColumns.putCell(Cell.of(rows.get(i).charAt(j), i, j));
            }
        }

        return cellMatrix;
    }

    private CellColumns getRow(int i) {
        return cellsRows.get(i);
    }

    int size() {
        // TODO 나중에 스트림으로?
        int count = 0;
        for (CellColumns cellsRow : cellsRows) {
            count += cellsRow.size();
        }

        return count;
    }

    CellStatus checkStatus(int y, int x) {
        if (checkOuter(y, x)) return CellStatus.GUTTER;

        return cellsRows.get(y).checkStatus(x);
    }

    private boolean checkOuter(int y, int x) {
        return x < 0 || x >= cellsRows.get(0).size() || y < 0 || y >= cellsRows.size();
    }

    public void evolveProcess() {
        for (CellColumns cellColumns : cellsRows) {
            log.debug("진화 진행");

            cellColumns.evolveProcess();
        }
    }

    boolean isAlive(int y, int x) {
        if (checkOuter(y, x)) {
            return false;
        }

        return cellsRows.get(y).isAlive(x);
    }

    boolean isCurAlive(int y, int x) {
        return cellsRows.get(y).isCurAlive(x);
    }

    public List<String> makeResult() {
        List<String> result = new ArrayList<>();

        for (CellColumns cellColumns : cellsRows) {
            result.add(cellColumns.transToString());
        }

        return result;
    }

    public void curToPrevStatus() {
        for (CellColumns cellColumns : cellsRows) {
            cellColumns.curToPrevStatus();
        }
    }

    @Override
    public String toString() {
        return "CellMatrix{" +
                "cellsRows=" + cellsRows +
                '}';
    }
}
