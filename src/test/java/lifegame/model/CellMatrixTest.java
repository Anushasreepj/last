package lifegame.model;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CellMatrixTest {
    private static final Logger log = LoggerFactory.getLogger(CellMatrixTest.class);

    @Test
    public void initByFile_oneLine() {
        CellMatrix cellMatrix = CellMatrix.of("success.txt");
        log.debug("cell : {}", cellMatrix);

        assertThat(cellMatrix.checkStatus(0, 0)).isEqualTo(CellStatus.DEAD);
        assertThat(cellMatrix.checkStatus(0, 1)).isEqualTo(CellStatus.ALIVE);
        assertThat(cellMatrix.checkStatus(0, 2)).isEqualTo(CellStatus.DEAD);
        assertThat(cellMatrix.size()).isEqualTo(3);
    }

    @Test
    public void initByFile_twoLine() {

        CellMatrix cellMatrix2 = CellMatrix.of("success2.txt");
        log.debug("cell2 : {}", cellMatrix2);

        assertThat(cellMatrix2.checkStatus(0, 0)).isEqualTo(CellStatus.DEAD);
        assertThat(cellMatrix2.checkStatus(0, 1)).isEqualTo(CellStatus.ALIVE);
        assertThat(cellMatrix2.checkStatus(0, 2)).isEqualTo(CellStatus.DEAD);
        assertThat(cellMatrix2.checkStatus(1, 0)).isEqualTo(CellStatus.ALIVE);
        assertThat(cellMatrix2.checkStatus(1, 1)).isEqualTo(CellStatus.DEAD);
        assertThat(cellMatrix2.checkStatus(1, 2)).isEqualTo(CellStatus.ALIVE);
        assertThat(cellMatrix2.size()).isEqualTo(6);
    }

    @Test
    public void evolveTest() {
        CellMatrix cellMatrix2 = CellMatrix.of("success2.txt");
        cellMatrix2.evloveProcess();

        assertThat(cellMatrix2.isCurAlive(0, 0)).isFalse();
        assertThat(cellMatrix2.isCurAlive(0, 1)).isTrue();
        assertThat(cellMatrix2.isCurAlive(0, 2)).isFalse();
        assertThat(cellMatrix2.isCurAlive(1, 0)).isFalse();
        assertThat(cellMatrix2.isCurAlive(1, 1)).isTrue();
        assertThat(cellMatrix2.isCurAlive(1, 2)).isFalse();

        log.debug("matrix : {}", cellMatrix2);
    }


    @Test
    public void evolveTest2() {
        CellMatrix cellMatrix2 = CellMatrix.of("success4.txt");
        cellMatrix2.evloveProcess();

        assertThat(cellMatrix2.isCurAlive(0, 2)).isTrue();
        assertThat(cellMatrix2.isCurAlive(1, 1)).isTrue();
        assertThat(cellMatrix2.isCurAlive(1, 2)).isFalse();
        assertThat(cellMatrix2.isCurAlive(1, 3)).isTrue();
        assertThat(cellMatrix2.isCurAlive(2, 1)).isTrue();
        assertThat(cellMatrix2.isCurAlive(2, 2)).isFalse();
        assertThat(cellMatrix2.isCurAlive(2, 3)).isTrue();
        assertThat(cellMatrix2.isCurAlive(3, 1)).isFalse();
        assertThat(cellMatrix2.isCurAlive(3, 2)).isTrue();
        assertThat(cellMatrix2.isCurAlive(3, 3)).isFalse();

        log.debug("matrix : {}", cellMatrix2);
    }
}
