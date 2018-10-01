package lifegame.model;

import lifegame.error.IllegalGenerationException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerationTest {
    @Test
    public void init() {
        Generation generation = Generation.of(3);
        assertThat(generation.getNum()).isEqualTo(3);
    }

    @Test(expected = IllegalGenerationException.class)
    public void init_false() {
        Generation generation = Generation.of(-1);
    }

    @Test
    public void checkLastGeneration() {
        Generation generation = Generation.of(3);
        assertThat(generation.checkLastGeneration(1)).isFalse();
        assertThat(generation.checkLastGeneration(2)).isTrue();
    }
}
