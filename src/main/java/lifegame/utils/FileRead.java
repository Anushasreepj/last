package lifegame.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileRead {
    private FileRead() {
    }

    public static List<String> readInStream(String fileName) {
        // TODO resource에서 간단하게 읽어오려면?
        // TODO 추후에 properties로 경로 분리
        File file = new File("/home/jh/lifegame/src/main/resources/file/" + fileName);
        Stream<String> returnStream = null;

        try {
            returnStream = Files.lines(file.toPath());
        } catch (IOException e) {
            e.getStackTrace();
        }

        return Objects.requireNonNull(returnStream).collect(Collectors.toList());
    }
}
