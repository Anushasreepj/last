package lifegame.model;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CellMatrixTest {
    private static final Logger log = LoggerFactory.getLogger(CellMatrixTest.class);

    @Test
    public void makeMatrix13() {
        CellMatrix cellMatrix = CellMatrix.of(1, 3);
        assertThat(cellMatrix.size()).isEqualTo(3);
    }

    @Test
    public void makeMatrix24() {
        CellMatrix cellMatrix = CellMatrix.of(2, 4);
        assertThat(cellMatrix.size()).isEqualTo(8);
    }

    @Test
    public void initByFile() {
        CellMatrix cellMatrix = CellMatrix.of("success.txt");
        log.debug("cell : {}", cellMatrix);

        CellMatrix cellMatrix2 = CellMatrix.of("success2.txt");
        log.debug("cell2 : {}", cellMatrix2);

        assertThat(cellMatrix2.checkStatus(0, 0)).isEqualTo(CellStatus.DEAD);
        assertThat(cellMatrix2.checkStatus(0, 1)).isEqualTo(CellStatus.ALIVE);
        assertThat(cellMatrix2.checkStatus(0, 2)).isEqualTo(CellStatus.DEAD);
        assertThat(cellMatrix2.checkStatus(1, 0)).isEqualTo(CellStatus.ALIVE);
        assertThat(cellMatrix2.checkStatus(1, 1)).isEqualTo(CellStatus.DEAD);
        assertThat(cellMatrix2.checkStatus(1, 2)).isEqualTo(CellStatus.ALIVE);
    }
}
