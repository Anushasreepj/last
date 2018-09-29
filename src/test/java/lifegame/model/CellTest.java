package lifegame.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {
    @Test
    public void init() {
        Cell cell = Cell.of('O', 0, 1);
        assertThat(cell.getPrevStatus()).isEqualTo(CellStatus.ALIVE);
        assertThat(cell.getX()).isEqualTo(1);
        assertThat(cell.getY()).isEqualTo(0);
    }

    @Test
    public void checkAlive() {
        Cell cell = Cell.of('O', 0, 1);
        assertThat(cell.isCurAlive()).isFalse();
        assertThat(cell.isAlive()).isTrue();
    }

    @Test
    public void transStatusAlive() {
        Cell cell = Cell.of('.', 0, 1);
        cell.alive();
        assertThat(cell.isCurAlive()).isTrue();
        assertThat(cell.isAlive()).isFalse();
    }

    @Test
    public void transStatusDead() {
        Cell cell = Cell.of('O', 0, 1);
        cell.dead();
        assertThat(cell.isCurAlive()).isFalse();
        assertThat(cell.isAlive()).isTrue();
    }

    @Test
    public void curToPrevStatus() {
        Cell cell = Cell.of('O', 0, 1);
        assertThat(cell.isAlive()).isTrue();
        assertThat(cell.isCurAlive()).isFalse();

        cell.curToPrevStatus();
        assertThat(cell.isAlive()).isFalse();
        assertThat(cell.isCurAlive()).isFalse();
    }
}
