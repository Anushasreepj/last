package lifegame.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {
    @Test
    public void init() {
        Cell cell = Cell.of('O', 0, 1);
        assertThat(cell.getPrevStatus()).isEqualTo(CellStatus.ALIVE);
    }
}
