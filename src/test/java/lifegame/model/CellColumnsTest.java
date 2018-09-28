package lifegame.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CellColumnsTest {
    @Test
    public void putCell() {
        CellColumns cellColumns = CellColumns.of(3);

        cellColumns.putCell(Cell.of('O', 0, 1));
        assertThat(cellColumns.checkStatus(0)).isEqualTo(CellStatus.DEAD);
        assertThat(cellColumns.checkStatus(1)).isEqualTo(CellStatus.ALIVE);
        assertThat(cellColumns.checkStatus(2)).isEqualTo(CellStatus.DEAD);
    }
}
