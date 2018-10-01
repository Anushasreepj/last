package lifegame;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LifeWorldTest {
    private static final Logger log = LoggerFactory.getLogger(LifeWorldTest.class);

    @Test
    public void getResult() {
        LifeWorld lifeWorld = new LifeWorld("success4.txt", 1);
        List<String> result = lifeWorld.getResult();
        List<String> assertList = Arrays.asList("..O..", ".O.O.", ".O.O.", "..O..", ".....");
        assertThat(result).isEqualTo(assertList);

        LifeWorld lifeWorld2 = new LifeWorld("success4.txt", 2);
        List<String> result2 = lifeWorld2.getResult();
        List<String> assertList2 = Arrays.asList("..O..", ".O.O.", ".O.O.", "..O..", ".....");
        assertThat(result2).isEqualTo(assertList2);
    }

    @Test
    public void getResult_beacon() {
        LifeWorld lifeWorld = new LifeWorld("beacon.txt", 1);
        List<String> result = lifeWorld.getResult();
        List<String> assertList = Arrays.asList("......", ".OO...", ".OO...", "...OO.", "...OO.", "......");
        log.debug("List : {}", result);
        assertThat(result).isEqualTo(assertList);

        LifeWorld lifeWorld2 = new LifeWorld("beacon.txt", 2);
        List<String> result2 = lifeWorld2.getResult();
        log.debug("List : {}", result2);
        assertThat(result2).isNotEqualTo(result);
    }

    @Test
    public void getResult_blinker() {
        LifeWorld lifeWorld = new LifeWorld("blinker.txt", 1);
        List<String> result = lifeWorld.getResult();
        List<String> assertList = Arrays.asList(".....", "..O..", "..O..", "..O..", ".....");
        log.debug("List : {}", result);
        assertThat(result).isEqualTo(assertList);

        LifeWorld lifeWorld2 = new LifeWorld("blinker.txt", 2);
        List<String> result2 = lifeWorld2.getResult();
        log.debug("List : {}", result2);
        assertThat(result2).isNotEqualTo(result);

        LifeWorld lifeWorld3 = new LifeWorld("blinker.txt", 3);
        List<String> result3 = lifeWorld3.getResult();
        log.debug("List : {}", result3);
        assertThat(result3).isEqualTo(result);
    }

    @Test
    public void getResult_cross() {
        LifeWorld lifeWorld = new LifeWorld("cross.txt", 1);
        List<String> result = lifeWorld.getResult();
        List<String> assertList = Arrays.asList(
                "...........",
                "...........",
                "...........",
                "...........",
                "....OOO....",
                "....O.O....",
                "....OOO....",
                "...........",
                "...........",
                "...........",
                "...........");
        log.debug("List : {}", result);
        assertThat(result).isEqualTo(assertList);

        LifeWorld lifeWorld2 = new LifeWorld("cross.txt", 2);
        List<String> result2 = lifeWorld2.getResult();
        List<String> assertList2 = Arrays.asList(
                "...........",
                "...........",
                "...........",
                ".....O.....",
                "....O.O....",
                "...O...O...",
                "....O.O....",
                ".....O.....",
                "...........",
                "...........",
                "...........");
        log.debug("List : {}", result2);
        assertThat(result2).isEqualTo(assertList2);

        LifeWorld lifeWorld3 = new LifeWorld("cross.txt", 3);
        List<String> result3 = lifeWorld3.getResult();
        List<String> assertList3 = Arrays.asList(
                "...........",
                "...........",
                "...........",
                ".....O.....",
                "....OOO....",
                "...OO.OO...",
                "....OOO....",
                ".....O.....",
                "...........",
                "...........",
                "...........");
        log.debug("List : {}", result3);
        assertThat(result3).isEqualTo(assertList3);
    }
}