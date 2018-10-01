package lifegame.model;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CellColumnsTest {
    private static final Logger log = LoggerFactory.getLogger(CellColumnsTest.class);

    @Test
    public void putCell() {
        CellColumns cellColumns = CellColumns.of(3, null);

        // 넣기 전 Cell 리턴
        Cell returnedCell = cellColumns.putCell(Cell.of('O', 0, 1));
        assertThat(returnedCell.getPrevStatus()).isEqualTo(CellStatus.DEAD);

        assertThat(cellColumns.checkStatus(0)).isEqualTo(CellStatus.DEAD);
        assertThat(cellColumns.checkStatus(1)).isEqualTo(CellStatus.ALIVE);
        assertThat(cellColumns.checkStatus(2)).isEqualTo(CellStatus.DEAD);
    }

    @Test
    public void columnEvoloveTest() {
        // TODO 컬럼 테스트를 위해서 매트릭스를 쓰는게 합당한가?
        CellMatrix cellMatrix = CellMatrix.of("success3.txt");

        CellColumns cellColumns = new CellColumns("success3.txt", cellMatrix);
        cellColumns.evolveProcess();

        assertThat(cellColumns.isCurAlive(0)).isFalse();
        assertThat(cellColumns.isCurAlive(1)).isTrue();
        assertThat(cellColumns.isCurAlive(2)).isFalse();
    }
}
