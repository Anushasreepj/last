package lifegame.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {
    @Test
    public void evolve() {
        Cell cell = new Cell();
        assertThat(cell.evolve(CellMatrix.of(1, 3))).isEqualTo(CellStatus.DEAD);
    }
}
