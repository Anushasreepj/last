package lifegame.utils;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FileReadTest {
    @Test(expected = RuntimeException.class)
    public void fileRead_fail() {
        FileRead.readInStream("test.txt");
    }

    @Test
    public void fileRead_success_oneLine() {
        assertThat(FileRead.readInStream("success.txt")).isEqualTo(Arrays.asList(".O."));
    }

    @Test
    public void fileRead_success_twoLine() {
        assertThat(FileRead.readInStream("success2.txt")).isEqualTo(Arrays.asList(".O.", "O.O"));
    }
}
