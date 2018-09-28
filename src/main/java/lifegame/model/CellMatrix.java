package lifegame.model;

import lifegame.utils.FileRead;

import java.util.ArrayList;
import java.util.List;

public class CellMatrix {
    private List<CellColumns> cellsRows = new ArrayList<CellColumns>();

    public CellMatrix(int row, int column) {
        for (int i = 0; i < row; i++) {
            cellsRows.add(CellColumns.of(column));
        }
    }

    public static CellMatrix of(int row, int column) {
        return new CellMatrix(row, column);
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

    public int size() {
        // TODO 나중에 스트림으로
        int count = 0;
        for (CellColumns cellsRow : cellsRows) {
            count += cellsRow.size();
        }

        return count;
    }

    // checkStatus()

    @Override
    public String toString() {
        return "CellMatrix{" +
                "cellsRows=" + cellsRows +
                '}';
    }

    public CellStatus checkStatus(int y, int x) {
        return cellsRows.get(y).checkStatus(x);
    }
}
